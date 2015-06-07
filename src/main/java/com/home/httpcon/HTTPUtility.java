package com.home.httpcon;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class HTTPUtility {

    public static String expandSafe(String urlArg, CloseableHttpClient closeableHttpClient) throws IOException {
        String originalUrl = urlArg;
        String newUrl = expandSingleLevelSafe(originalUrl, closeableHttpClient).getRight();
        final List<String> alreadyVisited = Lists.newArrayList(originalUrl, newUrl);
        while (!originalUrl.equals(newUrl)) {
            originalUrl = newUrl;
            final Pair<Integer, String> statusAndUrl = expandSingleLevelSafe(originalUrl, closeableHttpClient);
            newUrl = statusAndUrl.getRight();
            final boolean isRedirect = statusAndUrl.getLeft() == 301 || statusAndUrl.getLeft() == 302;
            if (isRedirect && alreadyVisited.contains(newUrl)) {
                throw new IllegalStateException("Likely a redirect loop");
            }
            alreadyVisited.add(newUrl);
        }

        return newUrl;
    }

    private static Pair<Integer, String> expandSingleLevelSafe(final String url,
            final CloseableHttpClient closeableHttpClient) throws IOException {
        HttpHead request = null;
        HttpEntity httpEntity = null;
        final InputStream entityContentStream = null;

        try {
            request = new HttpHead(url);
            final HttpResponse httpResponse = closeableHttpClient.execute(request);

            httpEntity = httpResponse.getEntity();

            final int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 301 && statusCode != 302) {
                return new ImmutablePair<Integer, String>(statusCode, url);
            }
            final Header[] headers = httpResponse.getHeaders(HttpHeaders.LOCATION);
            Preconditions.checkState(headers.length == 1);
            final String newUrl = headers[0].getValue();
            return new ImmutablePair<Integer, String>(statusCode, newUrl);
        } catch (final IllegalArgumentException uriEx) {
            return new ImmutablePair<Integer, String>(500, url);
        } finally {
            if (request != null) {
                request.releaseConnection();
            }
            if (entityContentStream != null) {
                entityContentStream.close();
            }
            if (httpEntity != null) {
                EntityUtils.consume(httpEntity);
            }
        }
    }

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
