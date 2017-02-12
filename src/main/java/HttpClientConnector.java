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

	public static void call() {
		System.out.println(Math.pow(2, 9));
//		 String serviceUrl = "http://api.exclusively.com/uaa/login";
//		 String serviceUrl = "http://localhost:8081/uaa/oauth/authorize";
		// String serviceUrl = "http://localhost:8081/uaa/oauth/authorize";
		 String serviceUrl = "http://10.11.27.213:8081/uaa/oauth/authorize";
//		 String serviceUrl = "http://localhost:3333/uaa/login";
//		 String serviceUrl = "http://10.30.59.152:8888/uaa/login";
//		String serviceUrl = "http://localhost:8082/cart/login";
		if (serviceUrl != null) {
			try {

				HttpResponse response = null;
				// String userName = "anshul.chauhan@exclusively.com";
				String userName = "namo@gmail.com";
				String password = "secret";
				String appended = userName + ":" + password;
				String bytesEncoded = new String(Base64.encodeBase64(appended.getBytes()));

				HttpGet loginServiceSocialGetRequest = new HttpGet(serviceUrl);
				 loginServiceSocialGetRequest.setHeader("Login-Token",
				 "Scufun4IejYz6mJQiYwZcKG59Ayw0eS0gjIt-vpB6BwuEglHeWh6XqZjVsRcJrp0MJEoLVdwTPgaa7f0Am4hs4Y828xtbrnYJbuyYYbVzJBnQ9WGZNLjgl66-dYqSXTx");

//				loginServiceSocialGetRequest.setHeader("Login-Token",
//						"Vzg3Y7c_liGZYGiBRgVWo71ggpA7KZfZkAXAHchGPC1fC2TMnGkWIp8kS5wClEelUn5B3yDeu9E7U7oqd6cTBJ0TaY7xw-qEqrjaPFjzGA9SfQIXZhXpJKXQnujzItqF");

				// loginServiceSocialGetRequest.setHeader("GENDER", "female");
//				loginServiceSocialGetRequest.setHeader("X-SOCIAL-TOKEN",
//						"CAACXHJL0waQBAL4MCnsh4DcaNwy5xYF9Ve3KOdJNrcMOOc3PTnSzNxtI5GI6eD023k07ZB358gDWQrY2ntZC6PBDZAxZC8Yq5JdO9rYXuGRzXf43vxEPsYp5a6hMZCmq41ceMMXc8wRKKLqp6VrhqBrknyjL6e3CQeFHqwdX0H9bMmng0ml16nif65Ur3eLGTS3mj39Wccbvhp9t2MhVdv8ZAVYlQVk5ZBcgHgGDIpjDQZDZD");
//				loginServiceSocialGetRequest.setHeader("X-SOCIAL-TYPE", "FACEBOOK");

				// loginServiceSocialGetRequest.setHeader("X-SOCIAL-TOKEN",
				// "ya29.hQLUuQ6k1qAex1Xj9E-Faqhrd1fAP9MmpoYr6RXyINvM5WR2SGUy-H8A39p_34XjW1xz");
				// loginServiceSocialGetRequest.setHeader("X-SOCIAL-TYPE",
				// "GOOGLE");

				System.out.println("Basic " + bytesEncoded);
//				 loginServiceSocialGetRequest.setHeader("Authorization",
//				 "Basic " + bytesEncoded);
				HttpClient httpClient = HttpClientBuilder.create().build();
				response = httpClient.execute(loginServiceSocialGetRequest);
				if (response.getHeaders("X-API-TOKEN").length > 0) {
					System.out.println(">>>>" + response.getHeaders("X-API-TOKEN")[0].toString());
					token = response.getHeaders("X-API-TOKEN")[0].toString();
				}
				InputStream inputStream = response.getEntity().getContent();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println("###" + line);
				}
				int statusCode = response.getStatusLine().getStatusCode();
				System.out.println(statusCode);

			} catch (Exception e) {
				System.out.println("Exception occured while login " + e);
			}
		}
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {

		try {
			for(int i=0;i<1;i++){
				call();
			}
			if (true)
				return;
			System.out.println("###############################################################");
			HttpResponse response = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			// This code is getting connection from
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("123abc@gmail.com", "secret");
			provider.setCredentials(AuthScope.ANY, credentials);
			// response = httpClient.execute(new
			// HttpGet("http://localhost:9999/dashboard/login"));
			HttpGet get = new HttpGet("http://10.41.64.84:3333/uaa/userDetails");
			// HttpGet get = new
			// HttpGet("http://app-mobile-api-355317418.ap-southeast-1.elb.amazonaws.com/uaa/userDetails");
			// get.addHeader("visitorId",
			// "33c792b2-0316-4fb0-9488-884aba178ab8");
			get.addHeader("visitorId", "123456");
			get.addHeader("X-API-TOKEN",
					"eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE0ODc3NDk3NTksInVzZXJfbmFtZSI6Im1hbm9qZ3VwdGEwMUB5YWhvby5jby5pbiIsImF1dGhvcml0aWVzIjpbIlJPTEVfQVVUSEVOVElDQVRFRF9VU0VSIl0sImp0aSI6ImVlZjVlMzQyLTE5ODQtNDM1My1iYWE5LTU5OGM3NGZlZjk5MiIsImNsaWVudF9pZCI6ImFjbWUiLCJzY29wZSI6WyJvcGVuaWQiXX0.jpbCDHhYq7t16emboZWf3WTiXVmth1HyJynlqLoOHr1PTLrhBCauaI-0gLApXwMHxVWxeF_gh2IN53la2HZBHprZIm-kGT4TI7OkGs19jmHhYEJudsf5nk11Hu04AhpSBmytlGTgm-0-N7SDhzh7iAYaOrSfbpq2nlgoTGaR4_Lwtgydlicjqh0WOBF9ccnPng_NYOFxXmfZOVJ8ay48kAYUdwwk2VcGej7TwXI2iBeLojVMO0k2IMhwXsOo0Dov-SWnNpnsslcSdEqkN_w8-fMxysf-JBlCG5uv4SstcNZoSHDatTrCiIA4rBGMw-JKHi83AxEu6ubvnCvlLkGNMA"/*
																																																																																																																																																														 */);
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

		// try {
		// HttpResponse response = null;
		// CredentialsProvider provider = new BasicCredentialsProvider();
		// HttpClient httpClient =
		// HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		//
		// // This code is getting connection from
		// UsernamePasswordCredentials credentials = new
		// UsernamePasswordCredentials("namo@gmail.com", "secret");
		// provider.setCredentials(AuthScope.ANY, credentials);
		// // response = httpClient.execute(new
		// // HttpGet("http://localhost:9999/dashboard/login"));
		// HttpPost post = new
		// HttpPost("http://localhost:3333/uaa/resetPassword");
		// // get.addHeader("visitorId",
		// // "33c792b2-0316-4fb0-9488-884aba178ab8");
		// List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		// JSONObject json = new JSONObject();
		// // json.put("id", "2");
		// // json.put("firstName", "John");
		// // json.put("lastName", "Wick");
		// json.put("token", "123444");
		// json.put("password", "abc123");
		// json.put("confirmPassword", "abc123");
		// StringEntity entity = new StringEntity(json.toString());
		// post.addHeader("content-type", "application/json");
		// post.setEntity(entity);
		// // post.addHeader("TOKEN",
		// //
		// "eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE0NDk4MDU2NDMsInVzZXJfbmFtZSI6Im5hbW9AZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BVVRIRU5USUNBVEVEX1VTRVIiXSwianRpIjoiMmZkZjY5MGMtNzdjZC00M2U0LWJjMWItNzM4YjllM2JhZTg2IiwiY2xpZW50X2lkIjoiYWNtZSIsInNjb3BlIjpbIm9wZW5pZCJdfQ.KB7maErcsxpco1tK4ZAtjkIFkCLtXgOuRonZfGkY6-7bJhRBP27IdkjrFX9n6EbJaQituHCY__zkoKyCIkVd4z140ud-IcDCdieEHQE18br9Y2xRgExiJQWZlVcgR4a-tLDAKh1iKk9xxeruZAdARhI2D_2KW6s88k-_wmI24jg8fFfHSJPdZiLEG225OSupqKe4cpFCANkDiIxprMg-jjtOSzJEw94kphezfdhtAG8dsr9aXNLi2-380Wv1NxyAyi0VGLlFlETtMBlHoll_XGuXKp0EB3aKkHpZs4-IndDekU8hfCEkQwS-mfv4NnKXpzavncVfYVtT2o61hkMLRg");
		// response = httpClient.execute(post);
		// InputStream inputStream = response.getEntity().getContent();
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(inputStream));
		// String line = null;
		// while ((line = bufferedReader.readLine()) != null) {
		// System.out.println("###" + line);
		// }
		// int statusCode = response.getStatusLine().getStatusCode();
		// System.out.println(statusCode);
		// } catch (Exception exception) {
		// System.out.println("Exception occured : " + exception.getMessage());
		// }
		//
		// Map<String, Object> responseMap = new HashMap<String, Object>();
		// try {

		// HttpResponse httpResponse = null;
		// CredentialsProvider provider = new BasicCredentialsProvider();
		// HttpClient httpClient =
		// HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		//
		// // This code is getting connection from
		// UsernamePasswordCredentials credentials = new
		// UsernamePasswordCredentials("namo@gmail.com", "secret");
		// provider.setCredentials(AuthScope.ANY, credentials);
		// httpResponse = httpClient.execute(new
		// HttpGet("http://localhost/cart/login"));
		// String line = null;
		// Header[] tokens = httpResponse.getHeaders("TOKEN");
		// if (tokens.length != 0) {
		// String token = tokens[0].getValue();
		// System.out.println(token);
		// }
		// System.out.println(httpResponse.getHeaders("TOKEN")[0].toString());
		// InputStream inputStream = httpResponse.getEntity().getContent();
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(inputStream));
		// while ((line = bufferedReader.readLine()) != null) {
		// break;
		// }
		// System.out.println("Line : " + line);
		// } catch (Exception exception) {
		// System.out.println(exception.getMessage());
		// }
	}
}
