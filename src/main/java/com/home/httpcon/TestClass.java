package com.home.httpcon;

import java.io.IOException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class TestClass {
    
    public static void main(String[] args) throws InterruptedException, IOException {

        PoolingHttpClientConnectionManager poolingConnManager = ConnectionManagerFactory.getInstance();
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(poolingConnManager).build();
        String actualURL = HTTPUtility.expandSafe("http://bit.ly/1GfsOL3", client);
        System.out.println("actualURL : "+actualURL);
        final HTTPClient[] httpClient = new HTTPClient[10];
        for (int i = 0; i < httpClient.length; i++) {
            httpClient[i] = new HTTPClient(client, actualURL, poolingConnManager);
        }
        for (final HTTPClient httpClientThread : httpClient) {
            httpClientThread.getHttpThread().start();
        }
        for (final HTTPClient httpClientThread : httpClient) {
            httpClientThread.getHttpThread().join(10000);
        }
    }
}
