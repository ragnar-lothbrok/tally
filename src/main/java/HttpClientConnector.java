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
		// String serviceUrl = "http://10.11.22.12:3333/uaa/login";
		// String serviceUrl = "http://localhost:8081/uaa/oauth/authorize";
		// String serviceUrl = "http://localhost:3333/uaa/login";
		String serviceUrl = "http://app-mobile-api-355317418.ap-southeast-1.elb.amazonaws.com/uaa/login";
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
						"FHNAfz0oMvz1FzfMa5EOOGmfqQtDMwpBT5G6bvEfnmyL_vtK7XoyTOHF4T-bUKEnpog-2Tj1oLdTVSIok9XZKlJ12m2J5bRqnjIe0lMmFWVtzHL-MPGxi6B0RU24_D5I");
				// loginServiceSocialGetRequest.setHeader("X-SOCIAL-TOKEN",
				// "CAACXHJL0waQBAP7TFI3i00KfTczZBWiqYzKB0dZAXIKYNRDUaAqVGdZCzShzt80OZA1sgcZCKP9jQOpvjg1V8ZAIUXuk51dyG7SoyQpOVv2SZCNbg7VCAC2zCkO0LsRIn45UK7ni0D6ljETnZBOICGoqN7p8Y0zUWy5a9FLKIctorukNXBYP0hoyTS5L1PlnsRZB10PooBWUE6zkZBvEfkL3ZCUB5EhysNLFdvfnIs2LVWc2QZDZD");
				// loginServiceSocialGetRequest.setHeader("X-SOCIAL-TYPE",
				// "Facebook");
				System.out.println("Basic " + bytesEncoded);
				// loginServiceSocialGetRequest.setHeader("Authorization",
				// "Basic " + bytesEncoded);
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

			System.out.println(Process_Input(-1));
			if(true)
				return;
			call();
			System.out.println("###############################################################");
			HttpResponse response = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			// This code is getting connection from
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("123abc@gmail.com", "secret");
			provider.setCredentials(AuthScope.ANY, credentials);
			// response = httpClient.execute(new
			// HttpGet("http://localhost:9999/dashboard/login"));
			HttpGet get = new HttpGet("http://localhost:3333/uaa/userDetails");
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

	private static Integer Process_Input(Integer x) throws Exception {
		if (x == null || x < 0) {
			throw new Exception("Negative_Error");
		} else if (x >= 130) {
			throw new Exception("Large_Error");
		}else if(x >= 0 && x < 50){
			return x;
		}else {
			return 2*x;
		}
	}

}
