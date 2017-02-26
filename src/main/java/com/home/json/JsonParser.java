package com.home.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class JsonParser {
	
	static int numberOfPairs(final int[] arr, final long sum) {
		java.util.Set<String> pointList = new java.util.HashSet<String>();
		java.util.Arrays.sort(arr);
		int left= 0,right = arr.length-1;
		while (left < right)
	    {
	         if(arr[left] + arr[right] == sum){
	        	 int small = (arr[left] > arr[right]) ? arr[right] : arr[left];
					int big = (arr[left] > arr[right]) ? arr[left] : arr[right];
					if (pointList.size() == 0) {
						pointList.add(small+"-"+big);
					} else {
						if (!pointList.contains(small+"-"+big)) {
							pointList.add(small+"-"+big);
						}
					}
					left++;
					right--;
	         }
	         else if(arr[left] + arr[right] < sum)
	              left++;
	         else 
	              right--;
	    }    
		return pointList.size();
	}
	
	static class Point {
		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	public static void main(String[] args) {
		System.out.println(numberOfPairs(new int[]{6,6,3,9,3,5,1}, 12));
		System.out.println(zombieCluster(new String[] { "1100", "1110", "0110", "0001" }));
		System.out.println(zombieCluster(new String[] { "10000", "01000", "00100", "00010", "00001" }));
	}

	static int zombieCluster(String[] zombies) {
		int countCluster = 0;
		if (zombies != null && zombies.length > 0) {
			boolean visited[][] = new boolean[zombies.length][zombies.length];
			int[][] matrix = new int[zombies.length][zombies.length];
			for (int i = 0; i < zombies.length; i++) {
				for (int j = 0; j < zombies.length; j++) {
					matrix[i][j] = Integer.parseInt(zombies[i].charAt(j) + "");
				}
			}

			for (int i = 0; i < zombies.length; i++) {
				for (int j = 0; j < zombies.length; j++) {
					java.util.Stack<Point> stack = new java.util.Stack<Point>();
					if (!visited[i][j] && matrix[i][j] == 1) {
						Point point = new Point(i, j);
						matrix[i][j] = Integer.parseInt(zombies[i].charAt(j) + "");
						stack.push(point);
						DFS(visited, stack, matrix);
						countCluster++;
					}
				}
			}

		}
		return countCluster;
	}

	private static void DFS(boolean visited[][], java.util.Stack<Point> stack, int[][] matrix) {
		while (!stack.isEmpty()) {
			Point point = stack.pop();
			visited[point.getX()][point.getY()] = true;
			for (int i = 0; i < matrix.length; i++) {
				if (!visited[point.getX()][i] && matrix[point.getX()][i] == 1) {
					stack.push(new Point(point.getX(), i));
					visited[point.getX()][i] = true;
				}
				if (!visited[i][point.getX()] && matrix[i][point.getX()] == 1) {
					stack.push(new Point(i, point.getX()));
					visited[i][point.getX()] = true;
				}
			}
		}
	}

	

	static String[] braces(final String[] values) {
		final String[] toReturn = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			if (isValid(values[i])) {
				toReturn[i] = "YES";
			} else {
				toReturn[i] = "NO";
			}
		}
		return toReturn;
	}

	private static boolean isValid(final String string) {
		final java.util.Map<Character, Character> map = new java.util.HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		final java.util.Stack<Character> stack = new java.util.Stack<>();

		for (int i = 0; i < string.length(); i++) {
			char curr = string.charAt(i);

			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.empty();
	}

	public static void main1(String[] args) throws JsonParseException, JsonMappingException, IOException {

		String jsonString = "[{\n" + "		\"id\": 100,\n" + "		\"key\": \"user.ex.system.applaunch.customerInfo\",\n"
				+ "		\"eventKey\": \"customerInfo\"\n" + "	}, {\n" + "		\"id\": 101,\n"
				+ "		\"key\": \"user.ex.system.applaunch.sessionInfo\",\n" + "		\"eventKey\": \"sessionInfo\"\n" + "	}, {\n"
				+ "		\"id\": 102,\n" + "		\"key\": \"user.ex.system.applaunch.loginStatus\",\n" + "		\"eventKey\": \"loginStatus\"\n"
				+ "	}, {\n" + "		\"id\": 104,\n" + "		\"key\": \"user.ex.system.applaunch.acquisitionInfo\",\n"
				+ "		\"eventKey\": \"acquisitionInfo\"\n" + "	}, {\n" + "		\"id\": 105,\n"
				+ "		\"key\": \"user.ex.system.applaunch.deviceDetails\",\n" + "		\"eventKey\": \"deviceDetails\"\n" + "	}, {\n"
				+ "		\"id\": 106,\n" + "		\"key\": \"user.ex.system.applaunch.appInfo\",\n" + "		\"eventKey\": \"appInfo\"\n"
				+ "	}, {\n" + "		\"id\": 107,\n" + "		\"key\": \"user.ex.system.applaunch.network\",\n" + "		\"eventKey\": \"network\"\n"
				+ "	}, {\n" + "		\"id\": 109,\n" + "		\"key\": \"user.ex.system.applaunch.locationInfo\",\n"
				+ "		\"eventKey\": \"locationInfo\"\n" + "	},\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "	{\n" + "		\"id\": 110,\n"
				+ "		\"key\": \"user.ex.system.listingscreenview.listingInfo\",\n" + "		\"eventKey\": \"listingInfo\"\n" + "	}, {\n"
				+ "		\"id\": 111,\n" + "		\"key\": \"user.ex.system.listingscreenproductsearch.listingProductSearchInfo\",\n"
				+ "		\"eventKey\": \"listingProductSearchInfo\"\n" + "	}, {\n" + "		\"id\": 112,\n"
				+ "		\"key\": \"user.ex.system.listingscreenfloorselect.listingFloorSelectInfo\",\n"
				+ "		\"eventKey\": \"listingFloorSelectInfo\"\n" + "	}, {\n" + "		\"id\": 113,\n"
				+ "		\"key\": \"user.ex.system.listingscreensortselect.listingSortSelectInfo\",\n"
				+ "		\"eventKey\": \"listingSortSelectInfo\"\n" + "	}, {\n" + "		\"id\": 114,\n"
				+ "		\"key\": \"user.ex.system.listingscreenprodclick.listingProdClickInfo\",\n" + "		\"eventKey\": \"listingProdClickInfo\"\n"
				+ "	}, {\n" + "		\"id\": 115,\n" + "		\"key\": \"user.ex.system.listingscreenfilterselect.listingFilterSelectInfo\",\n"
				+ "		\"eventKey\": \"listingFilterSelectInfo\"\n" + "	}, {\n" + "		\"id\": 116,\n"
				+ "		\"key\": \"user.ex.system.listingscreenfiltersearch.listingFilterSearchInfo\",\n"
				+ "		\"eventKey\": \"listingFilterSearchInfo\"\n" + "	}, {\n" + "		\"id\": 117,\n"
				+ "		\"key\": \"user.ex.system.topmenusearch.listingTopMenuSearchInfo\",\n" + "		\"eventKey\": \"listingTopMenuSearchInfo\"\n"
				+ "	}, {\n" + "		\"id\": 118,\n" + "		\"key\": \"user.ex.system.topmenufloorswitch.listingTopMenuFloorSwitchInfo\",\n"
				+ "		\"eventKey\": \"listingTopMenuFloorSwitchInfo\"\n" + "	}\n" + "\n" + "	, {\n" + "		\"id\": 119,\n"
				+ "		\"key\": \"user.ex.views.pdpScreenView\",\n" + "		\"eventKey\": \"pdpScreenView\"\n" + "	}, {\n"
				+ "		\"id\": 120,\n" + "		\"key\": \"user.ex.swipes.pdpScreenImageSwipe\",\n" + "		\"eventKey\": \"pdpScreenImageSwipe\"\n"
				+ "	}, {\n" + "		\"id\": 121,\n" + "		\"key\": \"user.ex.zooms.pdpScreenImageZoom\",\n"
				+ "		\"eventKey\": \"pdpScreenImageZoom\"\n" + "	}, {\n" + "		\"id\": 122,\n"
				+ "		\"key\": \"user.ex.clickstream.pdpScreenSizeSelect\",\n" + "		\"eventKey\": \"pdpScreenSizeSelect\"\n" + "	}, {\n"
				+ "		\"id\": 123,\n" + "		\"key\": \"user.ex.clickstream.pdpScreenSizeGuideClick\",\n"
				+ "		\"eventKey\": \"pdpScreenSizeGuideClick\"\n" + "	}, {\n" + "		\"id\": 124,\n"
				+ "		\"key\": \"user.ex.clickstream.pdpScreenPinCodSelect\",\n" + "		\"eventKey\": \"pdpScreenPinCodSelect\"\n" + "	}, {\n"
				+ "		\"id\": 125,\n" + "		\"key\": \"user.ex.clickstream.pdpScreenShopMoreBrandSelect\",\n"
				+ "		\"eventKey\": \"pdpScreenShopMoreBrandSelect\"\n" + "	}, {\n" + "		\"id\": 126,\n"
				+ "		\"key\": \"user.ex.clickstream.pdpScreenShopMoreCatSelect\",\n" + "		\"eventKey\": \"pdpScreenShopMoreCatSelect\"\n"
				+ "	}, {\n" + "		\"id\": 127,\n" + "		\"key\": \"user.ex.clickstream.pdpScreenShareProductSelect\",\n"
				+ "		\"eventKey\": \"pdpScreenShareProductSelect\"\n" + "	}, {\n" + "		\"id\": 128,\n"
				+ "		\"key\": \"user.ex.clickstream.pdpScreenShareChannelSelect\",\n" + "		\"eventKey\": \"pdpScreenShareChannelSelect\"\n"
				+ "	}, {\n" + "		\"id\": 129,\n" + "		\"key\": \"user.ex.clickstream.pdpScreenFindSimilarProductsSelect\",\n"
				+ "		\"eventKey\": \"pdpScreenFindSimilarProductsSelect\"\n" + "	}, {\n" + "		\"id\": 130,\n"
				+ "		\"key\": \"user.ex.clickstream.pdpScreenBuyNowSelect\",\n" + "		\"eventKey\": \"pdpScreenBuyNowSelect\"\n" + "	}, {\n"
				+ "		\"id\": 131,\n" + "		\"key\": \"user.ex.clickstream.pdpScreenAddToBagSelect\",\n"
				+ "		\"eventKey\": \"pdpScreenAddToBagSelect\"\n" + "	}, {\n" + "		\"id\": 132,\n"
				+ "		\"key\": \"user.ex.clickstream.pdpScreenShortlistSelect\",\n" + "		\"eventKey\": \"pdpScreenShortlistSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.pdpScreenMyBagSelect\",\n"
				+ "		\"eventKey\": \"pdpScreenMyBagSelect\"\n" + "	}\n" + "\n" + "	, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.views.designerFloorView\",\n" + "		\"eventKey\": \"designerFloorView\"\n" + "	}, {\n"
				+ "		\"id\": 133,\n" + "		\"key\": \"user.ex.scroll.designerFloorScroll\",\n" + "		\"eventKey\": \"designerFloorScroll\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.designerFloorPlatinumBannerSelect\",\n"
				+ "		\"eventKey\": \"designerFloorPlatinumBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorHotOfferSelect\",\n" + "		\"eventKey\": \"designerFloorHotOfferSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.designerFloorShopForWomenBannerSelect\",\n"
				+ "		\"eventKey\": \"designerFloorShopForWomenBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorShopForMenBannerSelect\",\n"
				+ "		\"eventKey\": \"designerFloorShopForMenBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorWhatsNewProdSelect\",\n"
				+ "		\"eventKey\": \"designerFloorWhatsNewProdSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorGoldBannerSelect\",\n" + "		\"eventKey\": \"designerFloorGoldBannerSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.designerFloorFashionReelBannerSelect\",\n"
				+ "		\"eventKey\": \"designerFloorFashionReelBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorInThisWeekBannerSelect\",\n"
				+ "		\"eventKey\": \"designerFloorInThisWeekBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorMenWomenTabSelect\",\n"
				+ "		\"eventKey\": \"designerFloorMenWomenTabSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorShopByDesignerSelect\",\n"
				+ "		\"eventKey\": \"designerFloorShopByDesignerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.views.luxuryFloorView\",\n" + "		\"eventKey\": \"luxuryFloorView\"\n" + "	}, {\n"
				+ "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.luxuryFloorPlatinumBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorPlatinumBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorHotOfferSelect\",\n" + "		\"eventKey\": \"luxuryFloorHotOfferSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.luxuryFloorShopforMenBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorShopforMenBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorShopforWomenBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorShopforWomenBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorWhatsnewProductSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorWhatsnewProductSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorGoldBannerSelect\",\n" + "		\"eventKey\": \"luxuryFloorGoldBannerSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.luxuryFloorInthenewsBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorInthenewsBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorIntheweekBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorIntheweekBannerSelect\"\n" + "	},\n" + "\n" + "	{\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorInTrendBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorInTrendBannerSelect\"\n" + "	},\n" + "\n" + "	{\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorInfluencerBannerSelect\",\n"
				+ "		\"eventKey\": \"luxuryFloorInfluencerBannerSelect\"\n" + "	},\n" + "\n" + "	{\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.luxuryFloorMenWomenTabSelect\",\n" + "		\"eventKey\": \"luxuryFloorMenWomenTabSelect\"\n"
				+ "	},\n" + "\n" + "	{\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.designerFloorShopByCategorySelect\",\n"
				+ "		\"eventKey\": \"designerFloorShopByCategorySelect\"\n" + "	},\n" + "\n" + "	{\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.designerFloorShopbyBrandSelect\",\n"
				+ "		\"eventKey\": \"designerFloorShopbyBrandSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.views.premiumFloorView\",\n" + "		\"eventKey\": \"premiumFloorView\"\n" + "	}, {\n"
				+ "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.premiumFloorMainBrandSelect\",\n"
				+ "		\"eventKey\": \"premiumFloorMainBrandSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.premiumFloorGridBrandSelect\",\n" + "		\"eventKey\": \"premiumFloorGridBrandSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.premiumFloorPlatinumBannerSelect\",\n"
				+ "		\"eventKey\": \"premiumFloorPlatinumBannerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.premiumFloorHotOfferSelect\",\n" + "		\"eventKey\": \"premiumFloorHotOfferSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.premiumFloorShopByBrandSelect\",\n"
				+ "		\"eventKey\": \"premiumFloorShopByBrandSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.premiumFloorShopforwomenSelect\",\n"
				+ "		\"eventKey\": \"premiumFloorShopforwomenSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.premiumFloorShopforManSelect\",\n" + "		\"eventKey\": \"premiumFloorShopforManSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.premiumFloorInfluencerSelect\",\n"
				+ "		\"eventKey\": \"premiumFloorInfluencerSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.premiumFloorInthenewsSelect\",\n" + "		\"eventKey\": \"premiumFloorInthenewsSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.premiumFloorIntrendSelect\",\n"
				+ "		\"eventKey\": \"premiumFloorIntrendSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.premiumFloorShopByCategorySelect\",\n"
				+ "		\"eventKey\": \"premiumFloorShopByCategorySelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.views.myFloorView\",\n" + "		\"eventKey\": \"myFloorView\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.myFloorViewPopularfromInterestSelect\",\n"
				+ "		\"eventKey\": \"myFloorViewPopularfromInterestSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.myFloorViewClick\",\n" + "		\"eventKey\": \"myFloorViewClick\"\n" + "	}, {\n"
				+ "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.myFloorViewShopByBrandsSelect\",\n"
				+ "		\"eventKey\": \"myFloorViewShopByBrandsSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.myFloorViewRecomendationSelect\",\n"
				+ "		\"eventKey\": \"myFloorViewRecomendationSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.myFloorViewShoptheLookSelect\",\n" + "		\"eventKey\": \"myFloorViewShoptheLookSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.myFloorViewInTrendSelect\",\n"
				+ "		\"eventKey\": \"myFloorViewInTrendSelect\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.myFloorViewrRebuildYourLookSelect\",\n"
				+ "		\"eventKey\": \"myFloorViewrRebuildYourLookSelect\"\n" + "	}\n" + "\n" + "	, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.views.cartView\",\n" + "		\"eventKey\": \"cartView\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.cartVewPromoApplyClick\",\n" + "		\"eventKey\": \"cartVewPromoApplyClick\"\n" + "	}, {\n"
				+ "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.cartViewGiftApplyclick\",\n"
				+ "		\"eventKey\": \"cartViewGiftApplyclick\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.cartViewRemovefromCartSelect\",\n" + "		\"eventKey\": \"cartViewRemovefromCartSelect\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.clickstream.cartViewShortlistClick\",\n"
				+ "		\"eventKey\": \"cartViewShortlistClick\"\n" + "	}, {\n" + "		\"id\": 133,\n"
				+ "		\"key\": \"user.ex.clickstream.cartViewPlaceOrderClick\",\n" + "		\"eventKey\": \"cartViewPlaceOrderClick\"\n"
				+ "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.views.checkoutView\",\n" + "		\"eventKey\": \"checkoutView\"\n"
				+ "	}\n" + "\n" + "	, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.pageload.app\",\n" + "		\"eventKey\": \"app\"\n"
				+ "	}\n" + "\n" + "	, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.pageload.device\",\n"
				+ "		\"eventKey\": \"device\"\n" + "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.pageload.session\",\n"
				+ "		\"eventKey\": \"session\"\n" + "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.screenload.loginLoad\",\n"
				+ "		\"eventKey\": \"loginLoad\"\n" + "	}, {\n" + "		\"id\": 133,\n" + "		\"key\": \"user.ex.click.login\",\n"
				+ "		\"eventKey\": \"login\"\n" + "	}\n" + "]";

		Test[] testArr = /*
							 * new ObjectMapper().readValue(jsonString,
							 * Test[].class)
							 */null;
		int start = 101;
		List<String> keys = new ArrayList<String>();
		for (Test test : testArr) {
			test.setId(start);
			start++;
			String key[] = test.getKey().split("\\.");
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < key.length; j++) {
				if (j == key.length - 1) {
					sb.append("ex" + ((key[j].charAt(0) + "").toUpperCase()) + key[j].substring(1));
				} else {
					sb.append(key[j] + ".");
				}
			}
			if (keys.contains(test.getEventKey())) {
				System.out.println("###" + test.getEventKey());
			} else {
				keys.add(test.getEventKey());
			}
			test.setKey(sb.toString());
		}
		System.out.println("Total : " + keys.size() + " *** " + testArr.length);
		// System.out.println(new ObjectMapper().writeValueAsString(testArr));
	}

	static class Test {
		private int id;
		private String key;
		private String eventKey;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getEventKey() {
			return eventKey;
		}

		public void setEventKey(String eventKey) {
			this.eventKey = eventKey;
		}

	}
}
