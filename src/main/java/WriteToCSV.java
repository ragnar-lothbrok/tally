import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class WriteToCSV {

	public static void main(String[] args) throws IOException {

		BufferedWriter br = new BufferedWriter(new FileWriter("/tmp/impression_first"));

		for (int i = 10000; i < 20000; i++) {
			br.write(buildRecord(i));
		}
		br.close();
		
		br = new BufferedWriter(new FileWriter("/tmp/click_first"));
		
		for (int i = 15000; i < 18000; i++) {
			br.write(buildRecord(i));
		}
		br.close();

		br = new BufferedWriter(new FileWriter("/tmp/impression_second"));

		for (int i = 25000; i < 45000; i++) {
			br.write(buildRecord(i));
		}
		br.close();
		
		br = new BufferedWriter(new FileWriter("/tmp/click_second"));

		for (int i = 20000; i < 40000; i++) {
			br.write(buildRecord(i));
		}
		br.close();
		
	}

	private static String buildRecord(int trackerId) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 17; i++) {
			sb.append(UUID.randomUUID().toString() + ",");
		}
		sb.append(trackerId+",");
		for (int i = 0; i < 1; i++) {
			sb.append(UUID.randomUUID().toString());
		}

		return sb.toString()+"\n";
	}
}
