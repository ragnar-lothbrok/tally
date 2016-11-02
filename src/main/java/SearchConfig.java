import java.util.ArrayList;
import java.util.List;

public class SearchConfig {

	private static final long serialVersionUID = -2121237660316682055L;
	
	private List<String> requestedAdTypes = new ArrayList<String>();
	private List<String> pageTypes = new ArrayList<String>();
	private List<PlatformProductCountMapping> platformProductCountMappings = new ArrayList<PlatformProductCountMapping>();
	private Boolean enableSolrSearch;
	private Boolean enableFallBack;
	
	public List<String> getRequestedAdTypes() {
		return requestedAdTypes;
	}

	public void setRequestedAdTypes(List<String> requestedAdTypes) {
		this.requestedAdTypes = requestedAdTypes;
	}

	public List<String> getPageTypes() {
		return pageTypes;
	}

	public void setPageTypes(List<String> pageTypes) {
		this.pageTypes = pageTypes;
	}

	public List<PlatformProductCountMapping> getPlatformProductCountMappings() {
		return platformProductCountMappings;
	}

	public void setPlatformProductCountMappings(List<PlatformProductCountMapping> platformProductCountMappings) {
		this.platformProductCountMappings = platformProductCountMappings;
	}

	public Boolean getEnableSolrSearch() {
		return enableSolrSearch;
	}

	public void setEnableSolrSearch(Boolean enableSolrSearch) {
		this.enableSolrSearch = enableSolrSearch;
	}

	public Boolean getEnableFallBack() {
		return enableFallBack;
	}

	public void setEnableFallBack(Boolean enableFallBack) {
		this.enableFallBack = enableFallBack;
	}

	@Override
	public String toString() {
		return "SearchConfig{" + "requestedAdTypes=" + requestedAdTypes + ", pageTypes=" + pageTypes + ", platformProductCountMapping ="
				+ platformProductCountMappings + ", enableSolrSearch=" + enableSolrSearch + ", enableFallBack=" + enableFallBack + '}';
	}

	static class PlatformProductCountMapping {
		private String platformType;
		private Integer maxSearchProductCount;

		public String getPlatformType() {
			return platformType;
		}

		public void setPlatformType(String platformType) {
			this.platformType = platformType;
		}

		public Integer getMaxSearchProductCount() {
			return maxSearchProductCount;
		}

		public void setMaxSearchProductCount(Integer maxSearchProductCount) {
			this.maxSearchProductCount = maxSearchProductCount;
		}

		public PlatformProductCountMapping(String platformType, Integer maxSearchProductCount) {
			super();
			this.platformType = platformType;
			this.maxSearchProductCount = maxSearchProductCount;
		}
		
		public PlatformProductCountMapping() {
			
		}
	}
}
