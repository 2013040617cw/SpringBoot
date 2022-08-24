package com.cuiwei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC的调用
@AutoConfigureMockMvc
public class webTest {
    @Test
    void test(){
    }
    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception{
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        mvc.perform(builder);
    }


    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception{
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book1");
        ResultActions action = mvc.perform(builder);
        //设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        //结果匹配器
        //status当前模拟运行的状态
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用时成功的状态：200
        ResultMatcher ok = status.isOk();
        //添加预计值到本次调用过程中进行匹配
        action.andExpect(ok);

    }


//响应体匹配（非json格式）
    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception{
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        ResultActions action = mvc.perform(builder);
        //设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        //结果匹配器
        //status当前模拟运行的状态
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功的状态：200
        ResultMatcher springboot = content.string("springboot");
        //添加预计值到本次调用过程中进行匹配
        action.andExpect(springboot);
    }

    //Json匹配
    @Test
    void testJSON(@Autowired MockMvc mvc) throws Exception{
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        ResultActions action = mvc.perform(builder);
        //设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        //结果匹配器
        //status当前模拟运行的状态
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功的状态：200
        ResultMatcher springboot = content.json("{\"id\":1,\"name\":\"崔巍\",\"type\":\"帅哥\",\"description\":\"他是中北大学第一帅比\"}");
        //添加预计值到本次调用过程中进行匹配
        action.andExpect(springboot);
    }

    //响应头信息匹配（非json格式）
    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception{
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        ResultActions action = mvc.perform(builder);
        //设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        //结果匹配器
        //status当前模拟运行的状态
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //预计本次调用时成功的状态：200
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        //添加预计值到本次调用过程中进行匹配
        action.andExpect(contentType);
    }

}
