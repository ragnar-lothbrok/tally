package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//https://www.hackerearth.com/code_mania_20/algorithm/listing-names-3/
public class Dictionary {

	public static void main(String[] args) throws NoSuchMethodException, ScriptException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException, FileNotFoundException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
		String script = "function AndroidSuccess(input){PayU.onSuccess(input);}";
		File functionscript = new File("/home/raghunandangupta/mygit/tally/src/main/java/com/home/codehunt_/abc.js");
		Reader reader = new FileReader(functionscript);
		scriptEngine.eval(reader);
		Invocable inv = (Invocable) scriptEngine;
		inv.invokeFunction("AndroidSuccess", "abc");
	}

	public static void main1(String args[]) throws Exception {
		PayUResponse payUResponse = new PayUResponse();
		Class klass = payUResponse.getClass();
		Field f = klass.getDeclaredField("mihpayid");
		f.setAccessible(true);
		f.set(payUResponse, "abc");
		System.out.println(payUResponse.toString());
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int N = Integer.parseInt(line);
			Map<String, Integer> treeMap = new TreeMap<String, Integer>();
			for (int i = 0; i < N; i++) {
				line = br.readLine().trim();
				if (treeMap.get(line) == null) {
					treeMap.put(line, 1);
				} else {
					treeMap.put(line, treeMap.get(line) + 1);
				}
			}

			for (Entry<String, Integer> entry : treeMap.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		} catch (Exception exception) {

		}
		
	}

}
