package com.home.httpcon;

import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.UrlValidator;

public class CommonValidatorUtils {

    private static final Integer CONNECTION_TIMEOUT = 40000; /* 40 sec */
    private static final Integer RESPONSE_CODE_403 = 403;
    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";

    public static boolean checkHttpURLExistence(String httpUrl) {
        // If httpurl is null
        if (null == httpUrl)
            return false;

        boolean res = false;
        HttpURLConnection con = null;
        try {
            // Setting up Proxy Settings
            Properties systemSettings = System.getProperties();
//            systemSettings.put("proxySet", "true");
//            systemSettings.put("http.proxyHost", "proxy.mycompany.local");
//            systemSettings.put("http.proxyPort", "80");

            URL url = getASCIIUrl(httpUrl);
            boolean isValidUrl = checkIfValidURL(url.toString());
            if (!isValidUrl) {
                return false;
            }
            // Open a http connection via the url
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("HEAD");
            HttpURLConnection.setFollowRedirects(false);
            // Putting connection timeout
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            // Response Status code
            int code = con.getResponseCode();
            System.out.println(code);

            if (4 == code / 100 && RESPONSE_CODE_403 != code) {
                con.disconnect();
                con = null;
                con = (HttpURLConnection) new URL(httpUrl).openConnection();
                HttpURLConnection.setFollowRedirects(false);
                con.setRequestMethod("HEAD");
                // Putting connection timeout
                con.setConnectTimeout(CONNECTION_TIMEOUT);
                con.addRequestProperty("User-Agent", "");
                code = con.getResponseCode();
            }

            if (RESPONSE_CODE_403 == code || 2 == code / 100 || 3 == code / 100 || code == 503)
                res = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                con.disconnect();
                con = null;
            }
        }

        return res;
    }

    public static boolean checkIfValidURL(final String url) {
        System.out.println("checkIfValidURL : url : " + url);
        if (null == url)
            return false;
        String temp = url.toLowerCase();
        boolean isValidUrl = temp.startsWith(HTTP) || temp.startsWith(HTTPS);
        if (isValidUrl) {
            UrlValidator urlValidator = new UrlValidator();
            isValidUrl = urlValidator.isValid(getASCIIUrl(url).toString());
            System.out.println("URL VALIDATOR : " + getASCIIUrl(url).toString() + " FLAG : " + isValidUrl);
            if (!isValidUrl) {
                if (urlValidator.isValid(getASCIIUrl(url).toString() + ".com")) {
                    isValidUrl = DomainValidator.getInstance().isValidGenericTld(url);
                }
            }
        }
        return isValidUrl;
    }

    public static URL getASCIIUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            String host = url.getHost();

            String protocol = url.getProtocol();
            url = new URL(protocol + "://" + IDN.toASCII(host));
        } catch (MalformedURLException e) {
            return null;
        }
        return url;
    }

    public static void main(String[] args) {
        // System.out.println(checkHttpURLExistence("https://saverocity.com"));
        // System.out.println(checkHttpURLExistence("http://www.google.com"));
        // System.out.println(checkHttpURLExistence("https://www.candis.co.uk/1"));
        // System.out.println(checkHttpURLExistence("http://www.minimonos.com"));
        // System.out.println(checkHttpURLExistence("http://bumpingbellies.com"));
        // System.out.println(checkHttpURLExistence("http://mymakeup.it/"));
        // System.out.println(checkHttpURLExistence("http://elgoog.im"));
        // System.out.println(checkHttpURLExistence("http://www.kissms.me/"));
        // System.out.println(checkHttpURLExistence("http://www.kissms.me/"));
        // System.out.println(checkHttpURLExistence("http://www.viraljolt.com/"));
        System.out.println(checkHttpURLExistence("http://kissanime.com/"));
    }

}
