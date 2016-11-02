import java.io.BufferedReader;
import java.util.StringTokenizer;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class Project1 {

	public static BufferedReader myFile;
	public static StringTokenizer myTokens;
	public static String[] dates;
	public static String line;

	public static void main(String[] args) throws Exception {
		String data = "ggg;ggg;nnn;nnn;aaa;aaa;xxx;xxx;";
		String del = ";";
		int splitSize = 2;
		
		StringBuilder sb  = new StringBuilder();
		for (Iterable<String> iterable : Iterables.partition(Splitter.on(del).split(data), splitSize)) {
			sb.append("\"").append(Joiner.on(del).join(iterable)).append(";\"");
		}
		System.out.println(sb.toString());
		
		
		for(String value : data.split("(?=\\G\\w+;\\w+;\\w+;);")){
			System.out.println(value);
		}
	
	}

}
