package com.home.httpcon;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class TestClass {

    public static void main(String[] args) throws InterruptedException {

        final HttpGet get = new HttpGet("http://echo.200please.com");
        PoolingHttpClientConnectionManager poolingConnManager = ConnectionManagerFactory.getInstance();
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(poolingConnManager).build();
        final HTTPClient[] httpClient = new HTTPClient[10];
        for (int i = 0; i < httpClient.length; i++) {
            httpClient[i] = new HTTPClient(client, get, poolingConnManager);
        }
        for (final HTTPClient httpClientThread : httpClient) {
            httpClientThread.getHttpThread().start();
        }
        for (final HTTPClient httpClientThread : httpClient) {
            httpClientThread.getHttpThread().join(10000);
        }
    }
}
