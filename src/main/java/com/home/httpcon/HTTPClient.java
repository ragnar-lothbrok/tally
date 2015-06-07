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

    private final String url;

    private PoolingHttpClientConnectionManager connManager;

    public int leasedConn;

    private Thread httpThread;

    public HTTPClient(final CloseableHttpClient client, final String url,
            final PoolingHttpClientConnectionManager connManager) {
        this.closeableHttpClient = client;
        this.url = url;
        this.connManager = connManager;
        leasedConn = 0;
        this.httpThread = new Thread(this);
    }

    public HTTPClient(final CloseableHttpClient client, final String url) {
        this.closeableHttpClient = client;
        this.url = url;
        this.httpThread = new Thread(this);
    }

    public void run() {
        HttpGet request = null;
        HttpResponse response = null;
        try {
            logger.debug("Thread Running: " + Thread.currentThread().getName());

            if (connManager != null) {
                logger.info(Thread.currentThread().getName() + " Before - Leased  = "
                        + connManager.getTotalStats().getLeased() + " Available  = "
                        + connManager.getTotalStats().getAvailable() + " Pending  = "
                        + connManager.getTotalStats().getPending() + " Total  = "
                        + connManager.getTotalStats().getMax());
            }
            request = new HttpGet(this.url);
            response = closeableHttpClient.execute(request);
            EntityUtils.consume(response.getEntity());
            logger.info(Thread.currentThread().getName() + " ContentType : "
                    + ContentType.getOrDefault(response.getEntity()).getMimeType() + " Status Code : "
                    + response.getStatusLine().getStatusCode());
            if (connManager != null) {
                leasedConn = connManager.getTotalStats().getLeased();
                logger.info(Thread.currentThread().getName() + " After - Leased  = "
                        + connManager.getTotalStats().getLeased() + " Available  = "
                        + connManager.getTotalStats().getAvailable() + " Pending  = "
                        + connManager.getTotalStats().getPending() + " Total  = "
                        + connManager.getTotalStats().getMax());
            }

        } catch (final ClientProtocolException ex) {
            logger.error("", ex);
        } catch (final IOException ex) {
            logger.error("", ex);
        } finally {
            if (request != null) {
                request.releaseConnection();
            }
        }
    }

    public static Thread getThread(HTTPClient httpClientThread) {
        return new Thread(httpClientThread);
    }

    public Thread getHttpThread() {
        return httpThread;
    }

}
