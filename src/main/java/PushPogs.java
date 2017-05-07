//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//import com.amazonaws.services.identitymanagement.model.CreateAccessKeyRequest;
//import com.google.common.base.Joiner;
//import com.google.gson.Gson;
//import com.snapdeal.cps.common.dto.ProductKafkaEvent;
//import com.snapdeal.cps.common.dto.ProductKafkaEvent.ProductEvent;
//
//public class PushPogs {
//
//	
//	
//	public static void create() throws IOException{
//		BufferedReader br = new BufferedReader(new FileReader("/tmp/result1.csv"));
//		String line = br.readLine();
//		int count = 0;
//		int batch = 0;
//		List<Long> pogs = new ArrayList<Long>();
//		while(line != null){
//			Long pog = Long.parseLong(line);
//			count++;
//			pogs.add(pog);
//			if(count % 100 == 0 && count != 0){
//				batch++;
//				String str = Joiner.on(",").join(pogs);
//				String sql = "update vendor_product_published_info set is_published=0 where pog_id in ("+str+") and publisher_id=2";
//				System.out.println(sql);
//				pogs = new ArrayList<Long>();
//				if(batch > 25){
//					return;
//				}
//			}
//			line = br.readLine();
//		}
//		String str = Joiner.on(",").join(pogs);
//		String sql = "update vendor_product_published_info set is_published=0 where pog_id in ("+str+") and publisher_id=2";
//		System.out.println(sql);
//	}
//	
//	
//	
//	public static void main(String[] args) throws ClientProtocolException, IOException {
////		create();
//		
////		if(true)
////			return;
////		
//		BufferedReader br = new BufferedReader(new FileReader("/tmp/result1.csv"));
//		String line = br.readLine();
//		int count = 0;
//		ProductKafkaEvent productKafkaEvent = new ProductKafkaEvent();
//		int batch = 0;
//		while(line != null){
//			System.out.println(line);
//			Long pog = Long.parseLong(line);
//			productKafkaEvent.getProductEvents().add(new ProductEvent(pog));
//			count++;
//			System.out.println("========="+count);
//			if(count % 100 == 0 && count != 0){
//				batch++;
//				HttpClient httpClient = HttpClientBuilder.create().build();
//				HttpPost post = new HttpPost("http://30.0.8.41:8080/test/publishDeleteProduct?insert=insert&kafka.feed.authentication.key=kafka@snap1234");
////				HttpPost post = new HttpPost("http://10.42.3.38:8080/test/publishDeleteProduct?insert=insert&kafka.feed.authentication.key=kafka@snap");
//				post.addHeader("content-type", "application/json");
//				StringEntity entity = new StringEntity(new Gson().toJson(productKafkaEvent));
//				post.setEntity(entity);
//				org.apache.http.HttpResponse response = httpClient.execute(post);
//				System.out.println(response.getStatusLine().getStatusCode());
//				productKafkaEvent = new ProductKafkaEvent();
//				System.out.println("-------"+batch);
//				System.out.println();
//			}
//			/*if(count == 100){
//				try {
//					System.out.println("Sleeping");
//					Thread.sleep(10000l);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}*/
//			line = br.readLine();
//		}
//	}
//
//}
