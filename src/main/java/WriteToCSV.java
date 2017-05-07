import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WriteToCSV {

	public static void main(String[] args) throws IOException {

		{
			CSVParser parser = new CSVParser(new FileReader("/home/raghunandangupta/Downloads/click/Impression_30.0.4.179_13_2016-09-23.csv"),
					CSVFormat.DEFAULT.withHeader());

			for (CSVRecord record : parser) {
				System.out.println(record);
				/*try {
					if (record.isMapped("os") && record.get("os") != null && record.get("os").trim().length() > 0) {
						System.out.println("####" + record.get("os")+", "+record);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		}

		if (true) {
			return;
		}

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
		sb.append(trackerId + ",");
		for (int i = 0; i < 1; i++) {
			sb.append(UUID.randomUUID().toString());
		}

		return sb.toString() + "\n";
	}
}
