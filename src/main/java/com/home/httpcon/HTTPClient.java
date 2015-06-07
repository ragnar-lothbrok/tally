package com.home.httpcon;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPClient implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CloseableHttpClient closeableHttpClient;

    private final HttpGet httpGet;

    private PoolingHttpClientConnectionManager connManager;

    public int leasedConn;

    private Thread httpThread;

    public HTTPClient(final CloseableHttpClient client, final HttpGet get,
            final PoolingHttpClientConnectionManager connManager) {
        this.closeableHttpClient = client;
        this.httpGet = get;
        this.connManager = connManager;
        leasedConn = 0;
        this.httpThread = new Thread(this);
    }

    public HTTPClient(final CloseableHttpClient client, final HttpGet get) {
        this.closeableHttpClient = client;
        this.httpGet = get;
        this.httpThread = new Thread(this);
    }

    public final int getLeasedConn() {
        return leasedConn;
    }

    public void run() {
        try {
            logger.debug("Thread Running: " + Thread.currentThread().getName());

            if (connManager != null) {
                logger.info(Thread.currentThread().getName() + " Before - Leased Connections = "
                        + connManager.getTotalStats().getLeased());
                logger.info(Thread.currentThread().getName() + " Before - Available Connections = "
                        + connManager.getTotalStats().getAvailable());
            }

            final HttpResponse response = closeableHttpClient.execute(httpGet);

            if (connManager != null) {
                leasedConn = connManager.getTotalStats().getLeased();
                logger.info(Thread.currentThread().getName() + " After - Leased Connections = "
                        + connManager.getTotalStats().getLeased());
                logger.info(Thread.currentThread().getName() + " After - Available Connections = "
                        + connManager.getTotalStats().getAvailable());
            }

            logger.info(Thread.currentThread().getName() + " ContentType : "
                    + ContentType.getOrDefault(response.getEntity()).getMimeType() + " Status Code : "
                    + response.getStatusLine().getStatusCode());
            EntityUtils.consume(response.getEntity());
        } catch (final ClientProtocolException ex) {
            logger.error("", ex);
        } catch (final IOException ex) {
            logger.error("", ex);
        }
    }

    public static Thread getThread(HTTPClient httpClientThread) {
        return new Thread(httpClientThread);
    }

    public Thread getHttpThread() {
        return httpThread;
    }

}
