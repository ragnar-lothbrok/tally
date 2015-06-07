package com.home.httpcon;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;

public class SSLFactory {

    private static volatile SSLConnectionSocketFactory sslConnectionSocketFactory = null;

    private SSLFactory() {
        
    }
    
    public static SSLConnectionSocketFactory getInstance() {
        if (sslConnectionSocketFactory == null) {
            synchronized (ConnectionManagerFactory.class) {
                if (sslConnectionSocketFactory == null) {
                    try{
                        SSLContextBuilder builder = new SSLContextBuilder();
                        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
                        sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build());
                    }catch(Exception exception){
                        exception.getStackTrace();
                    }
                }
            }
        }
        return sslConnectionSocketFactory;
    }

}
