import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MappingJsonFactory;

public class JsonParsingUtility {

	public static void main(String[] args) {
		try {
			JsonFactory f = new MappingJsonFactory();
			JsonParser jp = f.createJsonParser(new File("/tmp/report1521"));

			JsonToken current;

			current = jp.nextToken();
			if (current != JsonToken.START_OBJECT) {
				System.out.println("Error: root should be object: quiting.");
				return;
			}
			int totaImpressionYes = 0;
			int totaImpressionNo = 0;
			int totalClicksYes = 0;
			int totalClicksNo = 0;
			int totalConversionYes =0;
			int totalConversionNo =0;
			StringBuilder sb = new StringBuilder();
			sb.append("accountId,campaignId,date,filtername,enabled,impressions,clicks,Conversion\n");
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = jp.getCurrentName();
				// move from field name to field value
				current = jp.nextToken();
				if (fieldName.equals("result")) {
					if (current == JsonToken.START_ARRAY) {
						// For each of the records in the array
						while (jp.nextToken() != JsonToken.END_ARRAY) {
							// read the record into a tree model,
							// this moves the parsing position to the end of it
							JsonNode node = jp.readValueAsTree();
							// And now we have random access to everything in
							// the object
							if (node.get("filter_names") == null) {
								continue;
							}
							String filterNames = node.get("filter_names").getTextValue();
							String filterValues = node.get("filter_values").getTextValue();
							List<String> activeFilters = new ArrayList<String>();
							Long impressions = node.get("impressions").getLongValue();
							Long clicks = node.get("clicks").getLongValue();
							String date = node.get("date").getTextValue();
							Long accountId = node.get("account_id").getLongValue();
							Long campaignId = node.get("campaign_id").getLongValue();
							Long conversion = 0l;
							if (node.get("1_day_window") != null)
								conversion = node.get("1_day_window").getLongValue();

							if (filterNames != null /*
													 * && impressions >= clicks
													 */) {
								String filterNameSplits[] = filterNames.split(",");
								String filterValueSplits[] = filterValues.split(",");
								for (int i = 0; i < filterNameSplits.length; i++) {
									try {
										if (Integer.parseInt(filterValueSplits[i]) != -1 && impressions != 0
												&& "mlf".equalsIgnoreCase(filterNameSplits[i])) {
											activeFilters.add(filterNameSplits[i]);
											sb.append(accountId + ",").append(campaignId + ",").append(date + ",").append(filterNameSplits[i] + ",")
													.append(("1".equalsIgnoreCase(filterValueSplits[i]) ? "yes" : "no") + ",")
													.append(impressions + ",").append(clicks+",").append(conversion);
											sb.append("\n");
											if ("1".equalsIgnoreCase(filterValueSplits[i])) {
												totaImpressionYes += impressions;
												totalClicksYes += clicks;
												totalConversionYes += conversion;
											} else {
												totaImpressionNo += impressions;
												totalClicksNo += clicks;
												totalConversionNo += conversion;
											}
										}
									} catch (Exception exception) {

									}
								}
							}
						}
					} else {
						System.out.println("Error: records should be an array: skipping.");
						jp.skipChildren();
					}
				} else {
					System.out.println("Unprocessed property: " + fieldName);
					jp.skipChildren();
				}
			}

			StringBuilder aggSb = new StringBuilder();
			aggSb.append("\n");
			aggSb.append("ML" + "," + "Total Impressions,Total Clicks,CTR,Conversion" + "\n");
			aggSb.append("Yes," + totaImpressionYes + "," + totalClicksYes + "," + (totalClicksYes * 100.0 / totaImpressionYes) +","+totalConversionYes+"\n");
			aggSb.append("No," + totaImpressionNo + "," + totalClicksNo + "," + (totalClicksNo * 100.0 / totaImpressionNo) +","+totalConversionNo+ "\n");
			aggSb.append("\n").append(sb);

			writeListInFile(aggSb);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static void writeListInFile(StringBuilder sb) {
		try {
			PrintWriter writer = new PrintWriter("/tmp/ML-FILTER-15-Dec-" + Calendar.getInstance().getTimeInMillis() + ".csv", "UTF-8");
			writer.println(sb);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
