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

public class Service {

	public static void main(String[] args) {
		Gson gson = new Gson();
		File folder = new File("/tmp/overall-data");
		int totalJsonCounter = 0;
		File[] allFiles = folder.listFiles();
		IndexedCollection<ProductInfo> productInfo = CQEngine.newInstance();
		productInfo.clear();
		for (File file : allFiles) {
			try (InputStream inputStream = new FileInputStream(file)) {
				JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
				jsonReader.setLenient(true);
				while (jsonReader.hasNext()) {
					totalJsonCounter++;
					try {
						ProductInfo productInfoBuilder = gson.fromJson(jsonReader, ProductInfo.class);
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

	public static final Attribute<ProductInfo, String> SUPC = new SimpleAttribute<ProductInfo, String>("supc") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.supc;
	    }
	};

	/*public static final Attribute<ProductInfo, String> NAME = new SimpleAttribute<ProductInfo, String>("name") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.name;
	    }
	};*/

	public static final Attribute<ProductInfo, String> SELLER_CODE = new SimpleAttribute<ProductInfo, String>("seller_code") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.seller_code;
	    }
	};

	/*public static final Attribute<ProductInfo, String> SELLER_NAME = new SimpleAttribute<ProductInfo, String>("seller_name") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.seller_name;
	    }
	};*/

	/*public static final Attribute<ProductInfo, Integer> OFFER_PRICE = new SimpleAttribute<ProductInfo, Integer>("offer_price") {
	    public Integer getValue(ProductInfo productInfo) {
	        return productInfo.offer_price;
	    }
	};*/

	/*public static final Attribute<ProductInfo, Double> RATING = new SimpleAttribute<ProductInfo, Double>("rating") {
	    public Double getValue(ProductInfo productInfo) {
	        return productInfo.rating;
	    }
	};*/

	/*public static final Attribute<ProductInfo, String> NODE_PATH = new SimpleAttribute<ProductInfo, String>("node_path") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.node_path;
	    }
	};*/

	/*public static final Attribute<ProductInfo, Integer> DISCOUNT = new SimpleAttribute<ProductInfo, Integer>("discount") {
	    public Integer getValue(ProductInfo productInfo) {
	        return productInfo.discount;
	    }
	};
*/
	/*public static final Attribute<ProductInfo, Integer> INVENTORY = new SimpleAttribute<ProductInfo, Integer>("inventory") {
	    public Integer getValue(ProductInfo productInfo) {
	        return productInfo.inventory;
	    }
	};*/

	/*public static final Attribute<ProductInfo, Boolean> SOLD_OUT = new SimpleAttribute<ProductInfo, Boolean>("sold_out") {
	    public Boolean getValue(ProductInfo productInfo) {
	        return productInfo.sold_out;
	    }
	};
*/
	/*public static final Attribute<ProductInfo, String> PRODUCT_DESC = new SimpleAttribute<ProductInfo, String>("product_desc") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.product_desc;
	    }
	};
*/
	/*public static final Attribute<ProductInfo, Integer> PRICE = new SimpleAttribute<ProductInfo, Integer>("price") {
	    public Integer getValue(ProductInfo productInfo) {
	        return productInfo.price;
	    }
	};

	public static final Attribute<ProductInfo, Boolean> SD_PLUS = new SimpleAttribute<ProductInfo, Boolean>("sdplus") {
	    public Boolean getValue(ProductInfo productInfo) {
	        return productInfo.sdplus;
	    }
	};

	public static final Attribute<ProductInfo, Integer> NO_OF_RATING = new SimpleAttribute<ProductInfo, Integer>("no_of_rating") {
	    public Integer getValue(ProductInfo productInfo) {
	        return productInfo.no_of_rating;
	    }
	};

	public static final Attribute<ProductInfo, String> IS_SELECTED = new SimpleAttribute<ProductInfo, String>("is_selected") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.is_selected;
	    }
	};

	public static final Attribute<ProductInfo, String> PAGE_URL = new SimpleAttribute<ProductInfo, String>("page_url") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.page_url;
	    }
	};

	public static final Attribute<ProductInfo, String> CATEGORY = new SimpleAttribute<ProductInfo, String>("category") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.category;
	    }
	};*/

	public static final Attribute<ProductInfo, Long> POG_ID = new SimpleAttribute<ProductInfo, Long>("pog_id") {
	    public Long getValue(ProductInfo productInfo) {
	        return productInfo.pog_id;
	    }
	};

/*	public static final Attribute<ProductInfo, Integer> SHIPPING_DAYS = new SimpleAttribute<ProductInfo, Integer>("shipping_days") {
	    public Integer getValue(ProductInfo productInfo) {
	        return productInfo.shipping_days;
	    }
	};

	public static final Attribute<ProductInfo, String> BRAND = new SimpleAttribute<ProductInfo, String>("brand") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.brand;
	    }
	};

	public static final Attribute<ProductInfo, Boolean> LIVE = new SimpleAttribute<ProductInfo, Boolean>("live") {
	    public Boolean getValue(ProductInfo productInfo) {
	        return productInfo.live;
	    }
	};*/

	public static final Attribute<ProductInfo, String> CAT1 = new SimpleAttribute<ProductInfo, String>("cat1") {
	    public String getValue(ProductInfo productInfo) {
	        return productInfo.cat1;
	    }
	};
	public static final Attribute<ProductInfo, String> CAT2 = new SimpleAttribute<ProductInfo, String>("cat2") {

	    public String getValue(ProductInfo productInfo) {
	        return productInfo.cat2;
	    }
	};
	public static final Attribute<ProductInfo, String> CAT3 = new SimpleAttribute<ProductInfo, String>("cat3") {

	    public String getValue(ProductInfo productInfo) {
	        return productInfo.cat3;
	    }
	};
	public static final Attribute<ProductInfo, String> CAT4 = new SimpleAttribute<ProductInfo, String>("cat4") {

	    public String getValue(ProductInfo productInfo) {
	        return productInfo.cat4;
	    }
	};
	public static final Attribute<ProductInfo, String> CAT5 = new SimpleAttribute<ProductInfo, String>("cat5") {

	    public String getValue(ProductInfo productInfo) {
	        return productInfo.cat5;
	    }
	};
	public static final Attribute<ProductInfo, String> CAT6 = new SimpleAttribute<ProductInfo, String>("cat6") {

	    public String getValue(ProductInfo productInfo) {
	        return productInfo.cat6;
	    }
	};
}
