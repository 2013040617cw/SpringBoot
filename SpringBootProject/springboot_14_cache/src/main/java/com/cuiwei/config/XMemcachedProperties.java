package com.cuiwei.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {
    private String servers;
    private int poolSize;
    private long opTimeOut;

    public XMemcachedProperties() {
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public long getOpTimeOut() {
        return opTimeOut;
    }

    public void setOpTimeOut(long opTimeOut) {
        this.opTimeOut = opTimeOut;
    }

    public XMemcachedProperties(String servers, int poolSize, long opTimeOut) {
        this.servers = servers;
        this.poolSize = poolSize;
        this.opTimeOut = opTimeOut;
    }

    @Override
    public String toString() {
        return "XMemcachedProperties{" +
                "servers='" + servers + '\'' +
                ", poolSize=" + poolSize +
                ", opTimeOut=" + opTimeOut +
                '}';
    }
}
