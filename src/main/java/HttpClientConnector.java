import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

public class HttpClientConnector {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		try {
			HttpResponse response = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			// This code is getting connection from
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("namo@gmail.com", "secret");
			provider.setCredentials(AuthScope.ANY, credentials);
			// response = httpClient.execute(new
			// HttpGet("http://localhost:9999/dashboard/login"));
			HttpGet get = new HttpGet(
					"http://localhost:3333/cart/getCart");
			// get.addHeader("visitorId",
			// "33c792b2-0316-4fb0-9488-884aba178ab8");
			get.addHeader("visitorId", "123456");
			response = httpClient.execute(get);
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

		// response = httpClient.execute(new
		// HttpGet("http://localhost:9999/dashboard/user"));
		// System.out.println("#######"+response.getStatusLine().getStatusCode());
		// InputStream inputStream = response.getEntity().getContent();
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(inputStream));
		// String line = null;
		// while ((line = bufferedReader.readLine()) != null) {
		// System.out.println("###"+line);
		// }

		try {
			HttpResponse response = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			// This code is getting connection from
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("namo@gmail.com", "secret");
			provider.setCredentials(AuthScope.ANY, credentials);
			// response = httpClient.execute(new
			// HttpGet("http://localhost:9999/dashboard/login"));
			HttpPost post = new HttpPost("http://localhost:3333/uaa/resetPassword");
			// get.addHeader("visitorId",
			// "33c792b2-0316-4fb0-9488-884aba178ab8");
			List<NameValuePair> params = new ArrayList<NameValuePair>(3);
			JSONObject json = new JSONObject();
//			json.put("id", "2");
//			json.put("firstName", "John");
//			json.put("lastName", "Wick");
			json.put("token", "123444");
			json.put("password", "abc123");
			json.put("confirmPassword","abc123");
			StringEntity entity = new StringEntity(json.toString());
			post.addHeader("content-type", "application/json");
			post.setEntity(entity);
//			post.addHeader("TOKEN",
//					"eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE0NDk4MDU2NDMsInVzZXJfbmFtZSI6Im5hbW9AZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BVVRIRU5USUNBVEVEX1VTRVIiXSwianRpIjoiMmZkZjY5MGMtNzdjZC00M2U0LWJjMWItNzM4YjllM2JhZTg2IiwiY2xpZW50X2lkIjoiYWNtZSIsInNjb3BlIjpbIm9wZW5pZCJdfQ.KB7maErcsxpco1tK4ZAtjkIFkCLtXgOuRonZfGkY6-7bJhRBP27IdkjrFX9n6EbJaQituHCY__zkoKyCIkVd4z140ud-IcDCdieEHQE18br9Y2xRgExiJQWZlVcgR4a-tLDAKh1iKk9xxeruZAdARhI2D_2KW6s88k-_wmI24jg8fFfHSJPdZiLEG225OSupqKe4cpFCANkDiIxprMg-jjtOSzJEw94kphezfdhtAG8dsr9aXNLi2-380Wv1NxyAyi0VGLlFlETtMBlHoll_XGuXKp0EB3aKkHpZs4-IndDekU8hfCEkQwS-mfv4NnKXpzavncVfYVtT2o61hkMLRg");
			response = httpClient.execute(post);
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
		
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {

			HttpResponse httpResponse = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			// This code is getting connection from
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("namo@gmail.com", "secret");
			provider.setCredentials(AuthScope.ANY, credentials);
			httpResponse = httpClient.execute(new HttpGet("http://localhost/cart/login"));
			String line = null;
			Header[] tokens = httpResponse.getHeaders("TOKEN");
			if(tokens.length != 0){
				String token = tokens[0].getValue();
				System.out.println(token);
			}
			System.out.println(httpResponse.getHeaders("TOKEN")[0].toString());
			InputStream inputStream = httpResponse.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = bufferedReader.readLine()) != null) {
				break;
			}
			System.out.println("Line : "+line);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

}
