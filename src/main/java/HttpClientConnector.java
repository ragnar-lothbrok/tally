import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientConnector {
	static String token = null;

	

	public static void main(String[] args) throws ClientProtocolException, IOException {

		try {
//			call();
			System.out.println("###############################################################");
			HttpResponse response = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			// This code is getting connection from
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("123abc@gmail.com", "secret");
			provider.setCredentials(AuthScope.ANY, credentials);
			// response = httpClient.execute(new
			// HttpGet("http://localhost:9999/dashboard/login"));
			HttpGet get = new HttpGet("http://localhost:3331/uaa/userDetails");
			// HttpGet get = new
			// HttpGet("http://app-mobile-api-355317418.ap-southeast-1.elb.amazonaws.com/uaa/userDetails");
			// get.addHeader("visitorId",
			// "33c792b2-0316-4fb0-9488-884aba178ab8");
			get.addHeader("visitorId", "123456");
			get.addHeader("X-API-TOKEN", token.substring(token.indexOf(' ')));
			response = httpClient.execute(get);
			System.out.println(">>>>" + response.getHeaders("X-API-TOKEN"));
			InputStream inputStream = response.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println("###" + line);
			}
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
		} catch (Exception exception) {
			System.out.println("Exception occured : " + exception.getMessage());
		}
	}
}
