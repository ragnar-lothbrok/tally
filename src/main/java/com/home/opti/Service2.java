package com.home.opti;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.index.suffix.SuffixTreeIndex;

public class Service2 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		File folder = new File("/tmp/overall-data");
		int totalJsonCounter = 0;
		File[] allFiles = folder.listFiles();
		IndexedCollection<ProductInfo2> productInfo = CQEngine.newInstance();
		productInfo.clear();
		for (File file : allFiles) {
			try (InputStream inputStream = new FileInputStream(file)) {
				JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
				jsonReader.setLenient(true);
				while (jsonReader.hasNext()) {
					totalJsonCounter++;
					try {
						ProductInfo2 productInfoBuilder = gson.fromJson(jsonReader, ProductInfo2.class);
						productInfo.add(productInfoBuilder);
					} catch (Exception e) {
						System.out.println(file);
						e.printStackTrace();
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(file);
			}
		}
		System.out.println(totalJsonCounter + " " + productInfo.size());
		float heapUsedMemory = (float) ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024f);
		System.out.println("Before Attributes : " + heapUsedMemory);

		productInfo.addIndex(NavigableIndex.onAttribute(POG_ID));
		productInfo.addIndex(NavigableIndex.onAttribute(SELLER_CODE));
		productInfo.addIndex(NavigableIndex.onAttribute(SUPC));
		productInfo.addIndex(SuffixTreeIndex.onAttribute(CAT1));
		productInfo.addIndex(SuffixTreeIndex.onAttribute(CAT2));
		productInfo.addIndex(SuffixTreeIndex.onAttribute(CAT3));
		productInfo.addIndex(SuffixTreeIndex.onAttribute(CAT4));
		productInfo.addIndex(SuffixTreeIndex.onAttribute(CAT5));
		productInfo.addIndex(SuffixTreeIndex.onAttribute(CAT6));

		float heapUsedMemory1 = (float) ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024f);
		System.out.println("After Attributes : " + heapUsedMemory1);

	}

	public static final Attribute<ProductInfo2, String> SUPC = new SimpleAttribute<ProductInfo2, String>("supc") {
		public String getValue(ProductInfo2 productInfo) {
			return productInfo.supc;
		}
	};

	/*
	 * public static final Attribute<ProductInfo2, String> NAME = new
	 * SimpleAttribute<ProductInfo2, String>("name") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.name; } };
	 */

	public static final Attribute<ProductInfo2, String> SELLER_CODE = new SimpleAttribute<ProductInfo2, String>("seller_code") {
		public String getValue(ProductInfo2 productInfo) {
			return productInfo.seller_code;
		}
	};

	/*
	 * public static final Attribute<ProductInfo2, String> SELLER_NAME = new
	 * SimpleAttribute<ProductInfo2, String>("seller_name") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.seller_name; } };
	 */

	/*
	 * public static final Attribute<ProductInfo2, Integer> OFFER_PRICE = new
	 * SimpleAttribute<ProductInfo2, Integer>("offer_price") { public Integer
	 * getValue(ProductInfo2 productInfo) { return productInfo.offer_price; } };
	 */

	/*
	 * public static final Attribute<ProductInfo2, Double> RATING = new
	 * SimpleAttribute<ProductInfo2, Double>("rating") { public Double
	 * getValue(ProductInfo2 productInfo) { return productInfo.rating; } };
	 */

	/*
	 * public static final Attribute<ProductInfo2, String> NODE_PATH = new
	 * SimpleAttribute<ProductInfo2, String>("node_path") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.node_path; } };
	 */

	/*
	 * public static final Attribute<ProductInfo2, Integer> DISCOUNT = new
	 * SimpleAttribute<ProductInfo2, Integer>("discount") { public Integer
	 * getValue(ProductInfo2 productInfo) { return productInfo.discount; } };
	 */
	/*
	 * public static final Attribute<ProductInfo2, Integer> INVENTORY = new
	 * SimpleAttribute<ProductInfo2, Integer>("inventory") { public Integer
	 * getValue(ProductInfo2 productInfo) { return productInfo.inventory; } };
	 */

	/*
	 * public static final Attribute<ProductInfo2, Boolean> SOLD_OUT = new
	 * SimpleAttribute<ProductInfo2, Boolean>("sold_out") { public Boolean
	 * getValue(ProductInfo2 productInfo) { return productInfo.sold_out; } };
	 */
	/*
	 * public static final Attribute<ProductInfo2, String> PRODUCT_DESC = new
	 * SimpleAttribute<ProductInfo2, String>("product_desc") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.product_desc; }
	 * };
	 */
	/*
	 * public static final Attribute<ProductInfo2, Integer> PRICE = new
	 * SimpleAttribute<ProductInfo2, Integer>("price") { public Integer
	 * getValue(ProductInfo2 productInfo) { return productInfo.price; } };
	 * 
	 * public static final Attribute<ProductInfo2, Boolean> SD_PLUS = new
	 * SimpleAttribute<ProductInfo2, Boolean>("sdplus") { public Boolean
	 * getValue(ProductInfo2 productInfo) { return productInfo.sdplus; } };
	 * 
	 * public static final Attribute<ProductInfo2, Integer> NO_OF_RATING = new
	 * SimpleAttribute<ProductInfo2, Integer>("no_of_rating") { public Integer
	 * getValue(ProductInfo2 productInfo) { return productInfo.no_of_rating; }
	 * };
	 * 
	 * public static final Attribute<ProductInfo2, String> IS_SELECTED = new
	 * SimpleAttribute<ProductInfo2, String>("is_selected") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.is_selected; } };
	 * 
	 * public static final Attribute<ProductInfo2, String> PAGE_URL = new
	 * SimpleAttribute<ProductInfo2, String>("page_url") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.page_url; } };
	 * 
	 * public static final Attribute<ProductInfo2, String> CATEGORY = new
	 * SimpleAttribute<ProductInfo2, String>("category") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.category; } };
	 */

	public static final Attribute<ProductInfo2, Long> POG_ID = new SimpleAttribute<ProductInfo2, Long>("pog_id") {
		public Long getValue(ProductInfo2 productInfo) {
			return productInfo.pog_id;
		}
	};

	/*
	 * public static final Attribute<ProductInfo2, Integer> SHIPPING_DAYS = new
	 * SimpleAttribute<ProductInfo2, Integer>("shipping_days") { public Integer
	 * getValue(ProductInfo2 productInfo) { return productInfo.shipping_days; }
	 * };
	 * 
	 * public static final Attribute<ProductInfo2, String> BRAND = new
	 * SimpleAttribute<ProductInfo2, String>("brand") { public String
	 * getValue(ProductInfo2 productInfo) { return productInfo.brand; } };
	 * 
	 * public static final Attribute<ProductInfo2, Boolean> LIVE = new
	 * SimpleAttribute<ProductInfo2, Boolean>("live") { public Boolean
	 * getValue(ProductInfo2 productInfo) { return productInfo.live; } };
	 */

	public static final Attribute<ProductInfo2, String> CAT1 = new SimpleAttribute<ProductInfo2, String>("cat1") {
		public String getValue(ProductInfo2 productInfo) {
			return productInfo.cat1;
		}
	};
	public static final Attribute<ProductInfo2, String> CAT2 = new SimpleAttribute<ProductInfo2, String>("cat2") {

		public String getValue(ProductInfo2 productInfo) {
			return productInfo.cat2;
		}
	};
	public static final Attribute<ProductInfo2, String> CAT3 = new SimpleAttribute<ProductInfo2, String>("cat3") {

		public String getValue(ProductInfo2 productInfo) {
			return productInfo.cat3;
		}
	};
	public static final Attribute<ProductInfo2, String> CAT4 = new SimpleAttribute<ProductInfo2, String>("cat4") {

		public String getValue(ProductInfo2 productInfo) {
			return productInfo.cat4;
		}
	};
	public static final Attribute<ProductInfo2, String> CAT5 = new SimpleAttribute<ProductInfo2, String>("cat5") {

		public String getValue(ProductInfo2 productInfo) {
			return productInfo.cat5;
		}
	};
	public static final Attribute<ProductInfo2, String> CAT6 = new SimpleAttribute<ProductInfo2, String>("cat6") {

		public String getValue(ProductInfo2 productInfo) {
			return productInfo.cat6;
		}
	};

}
