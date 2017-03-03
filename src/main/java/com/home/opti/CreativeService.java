package com.home.opti;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;

public class CreativeService {
	public static void main(String[] args) {

		Gson gson = new Gson();
		File folder = new File("/home/raghunandangupta/Documents/overall-data");
		int totalJsonCounter = 0;
		File[] allFiles = folder.listFiles();

		Cache<Long, Creative> tempCreative = CacheBuilder.newBuilder().build();
		Map<Long, Creative> creatives = new HashMap<Long, Creative>();

		for (File file : allFiles) {

			try{
				InputStream inputStream = new FileInputStream(file);
				JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
				jsonReader.setLenient(true);
				while (jsonReader.hasNext()) {
					totalJsonCounter++;
					try {
						Creative productInfoBuilder = gson.fromJson(jsonReader, Creative.class);
						creatives.put(productInfoBuilder.getCreative_id(), productInfoBuilder);
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
		System.out.println(totalJsonCounter + " " + creatives.size());
		float heapUsedMemory = (float) ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024f);
		System.out.println("Before Attributes : " + heapUsedMemory);

		tempCreative.putAll(creatives);

		heapUsedMemory = (float) ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024f);
		System.out.println("Before Attributes : " + heapUsedMemory);

	}

	public static final Attribute<Creative, Long> CREATIVE_ID = new SimpleAttribute<Creative, Long>("creative_id") {
		public Long getValue(Creative creatives) {
			return creatives.creative_id;
		}
	};

	/*
	 * public static final Attribute<Creative, String> TARGET_ADSPACES = new
	 * SimpleAttribute<Creative, String>("target_adspaces") { public String
	 * getValue(Creative creatives) { return creatives.target_adspaces; } };
	 */
	public static final Attribute<Creative, Long> USER_ID = new SimpleAttribute<Creative, Long>("user_id") {
		public Long getValue(Creative creatives) {
			return creatives.user_id;
		}
	};
	public static final Attribute<Creative, Long> USERDETAILS_ID = new SimpleAttribute<Creative, Long>("userdetails_id") {
		public Long getValue(Creative creatives) {
			return creatives.userdetails_id;
		}
	};
	public static final Attribute<Creative, Long> AGENCY_ID = new SimpleAttribute<Creative, Long>("agency_id") {
		public Long getValue(Creative creatives) {
			return creatives.agency_id;
		}
	};
	public static final Attribute<Creative, Long> CAMPAIGN_ID = new SimpleAttribute<Creative, Long>("campaign_id") {
		public Long getValue(Creative creatives) {
			return creatives.campaign_id;
		}
	};

	public static final Attribute<Creative, String> CREATIVE_NAME = new SimpleAttribute<Creative, String>("creative_name") {
		public String getValue(Creative creatives) {
			return creatives.creative_name;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_TYPE = new SimpleAttribute<Creative, String>("creative_type") {
		public String getValue(Creative creatives) {
			return creatives.creative_type;
		}
	};

	public static final Attribute<Creative, Long> POG_ID = new SimpleAttribute<Creative, Long>("pog_id") {
		public Long getValue(Creative creatives) {
			return creatives.pog_id;
		}
	};

	public static final Attribute<Creative, String> BRAND_NAME = new SimpleAttribute<Creative, String>("brand_name") {
		public String getValue(Creative creatives) {
			return creatives.brand_name;
		}
	};
	public static final Attribute<Creative, String> SUPC = new SimpleAttribute<Creative, String>("supc") {
		public String getValue(Creative creatives) {
			return creatives.supc;
		}
	};
	public static final Attribute<Creative, String> CATEGORY = new SimpleAttribute<Creative, String>("category") {
		public String getValue(Creative creatives) {
			return creatives.category;
		}
	};
	public static final Attribute<Creative, String> SUBCATEGORY = new SimpleAttribute<Creative, String>("subcategory") {
		public String getValue(Creative creatives) {
			return creatives.subcategory;
		}
	};

	public static final Attribute<Creative, String> SELLER_CODE = new SimpleAttribute<Creative, String>("seller_code") {
		public String getValue(Creative creatives) {
			return creatives.seller_code;
		}
	};
	public static final Attribute<Creative, String> IMPRESSION_API_TYPE = new SimpleAttribute<Creative, String>("impression_api_type") {
		public String getValue(Creative creatives) {
			return creatives.impression_api_type;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_SIZE = new SimpleAttribute<Creative, String>("creative_size") {
		public String getValue(Creative creatives) {
			return creatives.creative_size;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_PLATFORM_SUPPORT = new SimpleAttribute<Creative, String>("creative_platform_support") {
		public String getValue(Creative creatives) {
			return creatives.creative_platform_support;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_COMPLIANT = new SimpleAttribute<Creative, String>("creative_compliant") {
		public String getValue(Creative creatives) {
			return creatives.creative_compliant;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_BRANDSAFE_GROUP = new SimpleAttribute<Creative, String>("creative_brandsafe_group") {
		public String getValue(Creative creatives) {
			return creatives.creative_brandsafe_group;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_CONTENT = new SimpleAttribute<Creative, String>("creative_content") {
		public String getValue(Creative creatives) {
			return creatives.creative_content;
		}
	};
	public static final Attribute<Creative, String> CREATED_DATE = new SimpleAttribute<Creative, String>("created_date") {
		public String getValue(Creative creatives) {
			return creatives.created_date;
		}
	};
	public static final Attribute<Creative, String> LAST_UPDATED_DATE = new SimpleAttribute<Creative, String>("last_updated_date") {
		public String getValue(Creative creatives) {
			return creatives.last_updated_date;
		}
	};
	public static final Attribute<Creative, String> STATUS = new SimpleAttribute<Creative, String>("status") {
		public String getValue(Creative creatives) {
			return creatives.status;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_URL = new SimpleAttribute<Creative, String>("creative_url") {
		public String getValue(Creative creatives) {
			return creatives.creative_url;
		}
	};
	public static final Attribute<Creative, String> EXTRA_TAGS = new SimpleAttribute<Creative, String>("extra_tags") {
		public String getValue(Creative creatives) {
			return creatives.extra_tags;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_FORMATS = new SimpleAttribute<Creative, String>("creative_formats") {
		public String getValue(Creative creatives) {
			return creatives.creative_formats;
		}
	};
	public static final Attribute<Creative, String> CLICK_THROUGH_URL = new SimpleAttribute<Creative, String>("click_through_url") {
		public String getValue(Creative creatives) {
			return creatives.click_through_url;
		}
	};
	public static final Attribute<Creative, String> ADX_CREATIVE_ATTRIBUTES = new SimpleAttribute<Creative, String>("adx_creative_attributes") {
		public String getValue(Creative creatives) {
			return creatives.adx_creative_attributes;
		}
	};
	public static final MultiValueAttribute<Creative, String> ADX_VENDOR_TYPES = new MultiValueAttribute<Creative, String>("adx_vendor_types") {
		public List<String> getValues(Creative creatives) {
			List<String> vendorTypes = new ArrayList<String>();
			for (String vendorType : creatives.adx_vendor_types.split(",")) {
				vendorTypes.add("," + vendorType + ",");
			}
			return vendorTypes;
		}
	};

	public static final Attribute<Creative, String> OPENRTB_CREATIVE_ATTRIBUTES = new SimpleAttribute<Creative, String>(
			"openrtb_creative_attributes") {
		public String getValue(Creative creatives) {
			return creatives.openrtb_creative_attributes;
		}
	};

	public static final Attribute<Creative, String> OPENRTB_CREATIVE_TYPES = new SimpleAttribute<Creative, String>("openrtb_creative_types") {
		public String getValue(Creative creatives) {
			return creatives.openrtb_creative_types;
		}
	};

	public static final Attribute<Creative, Long> IMPRESSION_PIXEL_ID = new SimpleAttribute<Creative, Long>("impression_pixel_id") {
		public Long getValue(Creative creatives) {
			return creatives.impression_pixel_id;
		}
	};

	public static final Attribute<Creative, Long> CLICK_PIXEL_ID = new SimpleAttribute<Creative, Long>("click_pixel_id") {
		public Long getValue(Creative creatives) {
			return creatives.click_pixel_id;
		}
	};
	public static final Attribute<Creative, Long> CONVERSION_PIXEL_ID = new SimpleAttribute<Creative, Long>("conversion_pixel_id") {
		public Long getValue(Creative creatives) {
			return creatives.conversion_pixel_id;
		}
	};
	public static final Attribute<Creative, String> RUBICON_CREATIVE_ATTRIBUTES = new SimpleAttribute<Creative, String>(
			"rubicon_creative_attributes") {
		public String getValue(Creative creatives) {
			return creatives.rubicon_creative_attributes;
		}
	};

	public static final Attribute<Creative, String> HTML = new SimpleAttribute<Creative, String>("html") {
		public String getValue(Creative creatives) {
			return creatives.html;
		}
	};
	public static final Attribute<Creative, String> EXTRA_HTML = new SimpleAttribute<Creative, String>("extra_html") {
		public String getValue(Creative creatives) {
			return creatives.extra_html;
		}
	};
	public static final Attribute<Creative, Long> APPNEXUS_CREATIVE_ID = new SimpleAttribute<Creative, Long>("appnexus_creative_id") {
		public Long getValue(Creative creatives) {
			return creatives.appnexus_creative_id;
		}
	};
	public static final Attribute<Creative, String> APPNEXUS_APPROVED = new SimpleAttribute<Creative, String>("APPNEXUS_APPROVED") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_approved;
		}
	};

	public static final Attribute<Creative, String> SMAATO_APPROVED = new SimpleAttribute<Creative, String>("SMAATO_APPROVED") {
		public String getValue(Creative creatives) {
			return creatives.smaato_approved;
		}
	};

	public static final Attribute<Creative, String> APPNEXUS_TAG_FORMAT = new SimpleAttribute<Creative, String>("APPNEXUS_TAG_FORMAT") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_tag_format;
		}
	};

	public static final Attribute<Creative, String> APPNEXUS_MEDIA_TYPE = new SimpleAttribute<Creative, String>("APPNEXUS_MEDIA_TYPE") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_media_type;
		}
	};
	public static final Attribute<Creative, String> APPNEXUS_MEDIA_SUBTYPE = new SimpleAttribute<Creative, String>("APPNEXUS_MEDIA_SUBTYPE") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_media_subtype;
		}
	};
	public static final Attribute<Creative, String> APPNEXUS_SUPPLY_TYPE = new SimpleAttribute<Creative, String>("APPNEXUS_SUPPLY_TYPE") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_supply_type;
		}
	};
	public static final Attribute<Creative, String> APPNEXUS_CREATIVE_FORMAT = new SimpleAttribute<Creative, String>("APPNEXUS_CREATIVE_FORMAT") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_creative_format;
		}
	};
	public static final Attribute<Creative, String> APPNEXUS_CREATIVE_ACTION = new SimpleAttribute<Creative, String>("APPNEXUS_CREATIVE_ACTION") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_creative_action;
		}
	};

	public static final Attribute<Creative, Integer> HEIGHT = new SimpleAttribute<Creative, Integer>("HEIGHT") {
		public Integer getValue(Creative creatives) {
			return creatives.height;
		}
	};

	public static final Attribute<Creative, Integer> WIDTH = new SimpleAttribute<Creative, Integer>("WIDTH") {
		public Integer getValue(Creative creatives) {
			return creatives.width;
		}
	};

	public static final Attribute<Creative, String> COMMA_CAMPAIGN_ID = new SimpleAttribute<Creative, String>("COMMA_CAMPAIGN_ID") {
		public String getValue(Creative creatives) {
			return "," + creatives.campaign_id + ",";
		}
	};

	public static final Attribute<Creative, String> APPNEXUS_TAG_IDS = new SimpleAttribute<Creative, String>("APPNEXUS_TAG_IDS") {
		public String getValue(Creative creatives) {
			return creatives.appnexus_tag_ids;
		}
	};

	public static final Attribute<Creative, Boolean> IS_VIDEO = new SimpleAttribute<Creative, Boolean>("IS_VIDEO") {
		public Boolean getValue(Creative creatives) {
			return creatives.is_video;
		}
	};

	public static final Attribute<Creative, Integer> VIDEO_LINEARITY = new SimpleAttribute<Creative, Integer>("VIDEO_LINEARITY") {
		public Integer getValue(Creative creatives) {
			return creatives.video_linearity;
		}
	};

	public static final Attribute<Creative, String> VIDEO_MIME = new SimpleAttribute<Creative, String>("VIDEO_MIMES") {
		public String getValue(Creative creatives) {
			return creatives.video_mime;
		}
	};

	public static final Attribute<Creative, Integer> VIDEO_DURATION = new SimpleAttribute<Creative, Integer>("VIDEO_MIN_DURATION") {
		public Integer getValue(Creative creatives) {
			return creatives.video_duration;
		}
	};

	public static final Attribute<Creative, String> VIDEO_PROTOCOL = new SimpleAttribute<Creative, String>("VIDEO_PROTOCOL") {
		public String getValue(Creative creatives) {
			return creatives.video_protocol;
		}
	};
	public static final Attribute<Creative, String> STATIC_IMAGE_URL = new SimpleAttribute<Creative, String>("STATIC_IMAGE_URL") {
		public String getValue(Creative creatives) {
			return creatives.static_image_url;
		}
	};
	public static final Attribute<Creative, String> CLICK_ASYNC_URL = new SimpleAttribute<Creative, String>("CLICK_ASYNC_URL") {
		public String getValue(Creative creatives) {
			return creatives.click_async_url;
		}
	};
	public static final Attribute<Creative, String> CREATIVE_MIMES_TYPE = new SimpleAttribute<Creative, String>("CREATIVE_MIMES_TYPE") {
		public String getValue(Creative creatives) {
			return creatives.creative_mimes_type;
		}
	};
	public static final Attribute<Creative, String> Third_Party_Imp_Url = new SimpleAttribute<Creative, String>("") {
		public String getValue(Creative creatives) {
			return creatives.thirdparty_imp_pixel;
		}
	};
	public static final Attribute<Creative, String> Third_Party_Click_Url = new SimpleAttribute<Creative, String>("") {
		public String getValue(Creative creatives) {
			return creatives.thirdparty_click_pixel;
		}
	};

}
