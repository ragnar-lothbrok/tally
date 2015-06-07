package com.home.httpcon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class HTTPUtility {
    
    public void getConnection() throws ClientProtocolException, IOException {

        HttpResponse httpResponse = sendGetRequest(getHttpClient());
        parseHttpResponse(httpResponse);
    }

    public static HttpClient getHttpClient() {
        return HttpClientBuilder.create().setDefaultRequestConfig(getDefaultConfig()).disableRedirectHandling()
                .setDefaultHeaders(getGlobalHeaders()).build();
    }

    public static RequestConfig getDefaultConfig() {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000).build();
        return requestConfig;
    }

    public HttpResponse sendGetRequest(HttpClient httpClient) throws ClientProtocolException, IOException {
        return httpClient.execute(getHttpGet("http://www.elgoog.im/"));
        // return
        // httpClient.execute(getHttpGetWithAbort("http://www.elgoog.im/"));
    }

    public HttpGet getHttpGet(String url) {
        HttpGet httpget = new HttpGet(url);
        RequestConfig requestConfig = getDefaultConfig();
        httpget.setConfig(requestConfig);

        return httpget;
    }

    public static List<Header> getGlobalHeaders() {
        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        List<Header> headers = new ArrayList<Header>();
        headers.add(header);
        return headers;
    }

    // Can be set for individual request
    public static void setHeaders(HttpGet httpGet) {
        if (httpGet != null) {
            httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        }
    }

    public HttpGet getHttpGetWithAbort(String url) throws ClientProtocolException, IOException {
        final HttpGet httpget = getHttpGet(url);
        int hardTimeout = 10;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (httpget != null) {
                    httpget.abort();
                }
            }
        };
        new Timer(true).schedule(task, hardTimeout * 1000);
        return httpget;
    }

    public static void parseHttpResponse(HttpResponse response) throws IOException {
        if (response == null) {
            return;
        }
        try {
            System.out.println("Status Code : " + getHttpResponseStatusCode(response));
            System.out.println("Response Body : " + getResponseBody(response));
        } finally {
        }
    }


    public static String getResponseBody(HttpResponse httpResponse) throws ParseException, IOException {
        return (httpResponse == null ? null : (httpResponse.getEntity() == null ? null : EntityUtils
                .toString(httpResponse.getEntity())));
    }

    public static Integer getHttpResponseStatusCode(HttpResponse httpResponse) {
        return httpResponse == null ? null : httpResponse.getStatusLine().getStatusCode();
    }

    public HttpPost getPostRequestWithAuth(String url) throws ClientProtocolException, IOException,
            AuthenticationException {
        HttpPost request = new HttpPost(url);
        request.setEntity(new StringEntity("Test POST"));
        final UsernamePasswordCredentials creds = new UsernamePasswordCredentials("username", "password");
        request.addHeader(new BasicScheme().authenticate(creds, request, null));
        return request;
    }
}
