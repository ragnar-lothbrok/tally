package com.home.httpcon;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class ConnectionManagerFactory {

    private static int MAX_CON = 25;
    private static int MAX_ROUTE = 5;

    private volatile static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;

    private ConnectionManagerFactory() {

    }

    public static PoolingHttpClientConnectionManager getInstance() {
        if (poolingHttpClientConnectionManager == null) {
            synchronized (ConnectionManagerFactory.class) {
                if (poolingHttpClientConnectionManager == null) {
                    Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", new PlainConnectionSocketFactory())
                            .register("https", SSLFactory.getInstance())
                            .build();
                    poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
                    poolingHttpClientConnectionManager.setMaxTotal(MAX_CON);
                    poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_ROUTE);
                    
                }
            }
        }
        return poolingHttpClientConnectionManager;
    }

}
