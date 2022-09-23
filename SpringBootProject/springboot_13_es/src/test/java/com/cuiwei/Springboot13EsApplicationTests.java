package com.cuiwei;

import com.alibaba.fastjson.JSON;
import com.cuiwei.dao.BookDao;
import com.cuiwei.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class Springboot13EsApplicationTests {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private RestHighLevelClient client;

	@BeforeEach
	void setUp(){  // 在每个测试方法前运行
		//创建主机地址
		HttpHost host = HttpHost.create("http://localhost:9200");
		//传入主机地址
		RestClientBuilder builder = RestClient.builder(host);
		//创建客户端
		RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

	}

	@AfterEach
	void tearDown() throws Exception{//在每个测试方法后运行
		//关闭客户端
		client.close();
	}
	@Test()
	void testCreateClient() throws Exception{
		//创建了一个索引，索引的名字叫books
		CreateIndexRequest request = new CreateIndexRequest("books");
		//设置请求中的参数
		String json = "{\n" +
				"    \"mappings\":{\n" +
				"        \"properties\":{\n" +
				"            \"id\":{\n" +
				"                \"type\":\"keyword\"\n" +
				"            },\n" +
				"            \"name\":{\n" +
				"                \"type\":\"text\",               \n" +
				"                \"analyzer\":\"ik_max_word\",            \n" +
				"                \"copy_to\":\"all\"\n" +
				"            },\n" +
				"            \"type\":{\n" +
				"                \"type\":\"keyword\"\n" +
				"            },\n" +
				"            \"description\":{\n" +
				"                \"type\":\"text\",           \n" +
				"                \"analyzer\":\"ik_max_word\",                \n" +
				"                \"copy_to\":\"all\"\n" +
				"            },\n" +
				"            \"all\":{\n" +
				"                \"type\":\"text\",\t                \n" +
				"                \"analyzer\":\"ik_max_word\"\n" +
				"            }\n" +
				"        }\n" +
				"    }\n" +
				"}";

		request.source(json, XContentType.JSON);
		client.indices().create(request,RequestOptions.DEFAULT);

	}
	//创建文档
	@Test
	void testCreateDoc() throws Exception{
		Book book = bookDao.selectById(1);
		IndexRequest request = new IndexRequest("books").id(book.getId().toString());
		String json = JSON.toJSONString(book);
		request.source(json,XContentType.JSON);
		client.index(request,RequestOptions.DEFAULT);
	}
	@Test
//批量添加文档
	void testCreateDocAll() throws IOException {
		List<Book> bookList = bookDao.selectList(null);
		BulkRequest bulk = new BulkRequest();
		for (Book book : bookList) {
			IndexRequest request = new IndexRequest("books").id(book.getId().toString());
			String json = JSON.toJSONString(book);
			request.source(json,XContentType.JSON);
			bulk.add(request);
		}
		client.bulk(bulk,RequestOptions.DEFAULT);
	}

	@Test
//按条件查询
	void testSearch() throws IOException {
		SearchRequest request = new SearchRequest("books");

		SearchSourceBuilder builder = new SearchSourceBuilder();
		builder.query(QueryBuilders.termQuery("all","spring"));
		request.source(builder);

		SearchResponse response = client.search(request, RequestOptions.DEFAULT);
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			String source = hit.getSourceAsString();
			//System.out.println(source);
			Book book = JSON.parseObject(source, Book.class);
			System.out.println(book);
		}
	}
}

