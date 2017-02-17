package com.home.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SeverLogAnalysis {

	private final static String SEPERATOR = "***************###############***************";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = br.readLine();
		Map<String, Integer> filterMap = new LinkedHashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		RequestFormat requestFormat = new RequestFormat();
		while (firstLine.trim().indexOf(SEPERATOR) == -1) {
			if (firstLine.indexOf("Started") != -1) {
				if (sb.length() > 0) {
					requestFormat.getLines().add(sb.toString());
				}
				sb = new StringBuilder();
			}
			sb.append(firstLine + "\n");
			firstLine = br.readLine();
		}
		if (sb.length() > 0) {
			requestFormat.getLines().add(sb.toString());
		}

		int count = 0;
		filterMap.put("REQUEST_TYPE", 0);
		filterMap.put("RELATIVE_URL", 0);
		filterMap.put("IP", 0);
		filterMap.put("REQUEST_FORMAT", 0);
		filterMap.put("RESPONSE_CODE", 0);
		int result = 0;
		if (firstLine.trim().indexOf(SEPERATOR) != -1) {
			firstLine = br.readLine();
			while (firstLine != null && firstLine.trim().length() > 0) {
				if (count == 0) {
					result = countFiltersCounts(requestFormat, firstLine, "REQUEST_TYPE");
					filterMap.put("REQUEST_TYPE", filterMap.get("REQUEST_TYPE") + result);
				} else if (count == 1) {
					result = countFiltersCounts(requestFormat, firstLine, "RELATIVE_URL");
					filterMap.put("RELATIVE_URL", filterMap.get("RELATIVE_URL") + result);
				} else if (count == 2) {
					result = countFiltersCounts(requestFormat, firstLine, "IP");
					filterMap.put("IP", filterMap.get("IP") + result);
				} else if (count == 3) {
					result = countFiltersCounts(requestFormat, firstLine, "REQUEST_FORMAT");
					filterMap.put("REQUEST_FORMAT", filterMap.get("REQUEST_FORMAT") + result);
				} else if (count == 4) {
					result = countFiltersCounts(requestFormat, firstLine, "RESPONSE_CODE");
					filterMap.put("RESPONSE_CODE", filterMap.get("RESPONSE_CODE") + result);
				}
				count++;
				firstLine = br.readLine();
			}
		}
		for (Integer value : filterMap.values()) {
			System.out.println(value);
		}
	}

	private static int countFiltersCounts(RequestFormat requestFormat, String filterValue, String filterType) {
		int count = 0;
		if (requestFormat.getLines().size() > 0) {
			if (filterType.equalsIgnoreCase("REQUEST_TYPE")) {
				for (String format : requestFormat.getLines()) {
					if (format.indexOf("\n") != -1) {
						String splits[] = format.substring(0, format.indexOf("\n")).split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
						if (splits.length > 1) {
							if (splits[0].equals("Started")) {
								if (splits[1].equals(filterValue)) {
									count++;
									continue;
								}
							}
						}
					}
				}
			} else if (filterType.equalsIgnoreCase("IP")) {
				for (String format : requestFormat.getLines()) {
					if (format.indexOf("\n") != -1) {
						String splits[] = format.substring(0, format.indexOf("\n")).split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
						if (splits.length > 1) {
							if (splits[0].equals("Started")) {
								for (int i = 0; i < splits.length; i++) {
									String value = splits[i];
									if (value.equals("for")) {
										if (splits[i + 1].equals(filterValue)) {
											count++;
											break;
										}
									}
								}
							}
						}
					}
				}
			} else if (filterType.equalsIgnoreCase("RELATIVE_URL")) {
				for (String format : requestFormat.getLines()) {
					if (format.indexOf("\n") != -1) {
						String splits[] = format.substring(0, format.indexOf("\n")).split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
						if (splits.length > 1) {
							if (splits[0].equals("Started")) {
								for (int i = 0; i < splits.length; i++) {
									splits[i] = splits[i].replaceAll("\"", "");
									if (splits[i].equals(filterValue)) {
										count++;
										break;
									}
								}
							}
						}
					}
				}
			} else if (filterType.equalsIgnoreCase("REQUEST_FORMAT")) {
				for (String format : requestFormat.getLines()) {
					if (format.indexOf("\n") != -1) {
						String splits[] = format.split("\n");
						for (int i = 0; i < splits.length; i++) {
							if (splits[i].indexOf("Processing by") != -1) {
								String splitLine[] = splits[i].split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
								if (splitLine[splitLine.length - 1].equalsIgnoreCase(filterValue)) {
									count++;
									break;
								}
							}
						}
					}
				}
			} else if (filterType.equalsIgnoreCase("RESPONSE_CODE")) {
				for (String format : requestFormat.getLines()) {
					if (format.indexOf("\n") != -1) {
						String splits[] = format.split("\n");
						for (int i = 0; i < splits.length; i++) {
							if (splits[i].indexOf("Completed") != -1) {
								if (splits[i].indexOf(filterValue) != -1) {
									count++;
									break;
								}
							}
						}
					}
				}
			}
		}
		return count;
	}

	static class RequestFormat implements Serializable {

		private static final long serialVersionUID = 1L;
		private List<String> lines = new ArrayList<String>();

		public List<String> getLines() {
			return lines;
		}

		public void setLines(List<String> lines) {
			this.lines = lines;
		}
	}

}
