import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PLALogParser {

	public static void main(String[] args) throws IOException {
		try {
			totalConsumed();
		} catch (Exception e) {
			
		}
		
		try {
			totalskipped();
		} catch (Exception e) {
			
		}
		
		try {
			actualSend();
		} catch (Exception e) {
			
		}
		
		try {
			mongoSend();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void mongoSend() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("/tmp/abc_mongo.txt"));
		String line = null;
		int count = 0;
		while ((line = br.readLine()) != null) {
			int index = line.lastIndexOf("Saving Product Count");
			String value = line.substring(index + "Saving Product Count".length(), index + "Saving Product Count".length()+4);
			count += Integer.parseInt(value.trim());
		}
		System.out.println("Send to Mongo :>> Total : " + count);
	}
	
	private static void actualSend() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("/tmp/abc_priceinv.txt"));
		String line = null;
		int count = 0;
		Set<Long> pogSet = new HashSet<Long>();
		while ((line = br.readLine()) != null) {
			int index = line.lastIndexOf("priceInventoryMap => [");
			String str[] = line.substring(index + "priceInventoryMap => [".length(), line.indexOf("] fbInventoryRequestSize")).split(",");
			count += str.length;
			for (String value : str) {
				if (value.trim().length() > 0)
					pogSet.add(Long.parseLong(value.trim()));
			}
		}
		System.out.println("Send to Facebook :>> Total : " + count + " Set : " + pogSet.size());
	}

	private static void totalskipped() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("/tmp/abc_skipped.txt"));
		String line = null;
		int count = 0;
		Set<Long> pogSet = new HashSet<Long>();
		while ((line = br.readLine()) != null) {
			int index = line.lastIndexOf("are = [");
			String str[] = line.substring(index + "are = [".length(), line.length() - 2).split(",");
			count += str.length;
			for (String value : str) {
				if (value.trim().length() > 0)
					pogSet.add(Long.parseLong(value.trim()));
			}
		}
		System.out.println("Skipped :>> Total : " + count + " Set : " + pogSet.size());
	}

	private static void totalConsumed() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("/tmp/abc_actual.txt"));
		String line = null;
		int count = 0;
		Set<Long> pogSet = new HashSet<Long>();
		while ((line = br.readLine()) != null) {
			int index = line.lastIndexOf("Pogs = [");
			String str[] = line.substring(index + "Pogs = [".length(), line.length() - 2).split(",");
			count += str.length;
			for (String value : str) {
				pogSet.add(Long.parseLong(value.trim()));
			}
		}
		System.out.println("Consumed :>> Total : " + count + " Set : " + pogSet.size());
	}
}
