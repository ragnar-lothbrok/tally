import java.util.ArrayList;
import java.util.List;

public class CampaignCreationRequest {

	private Long bucketId;
	private Double budgetAmount;
	private Integer recordCount;

	private List<MatchTypeLength> matchTypeLengthList = new ArrayList<MatchTypeLength>();

	public Long getBucketId() {
		return bucketId;
	}

	public void setBucketId(Long bucketId) {
		this.bucketId = bucketId;
	}

	public Double getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(Double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public List<MatchTypeLength> getMatchTypeLengthList() {
		return matchTypeLengthList;
	}

	public void setMatchTypeLengthList(List<MatchTypeLength> matchTypeLengthList) {
		this.matchTypeLengthList = matchTypeLengthList;
	}

	public static class MatchTypeLength {

		private String matchType;
		private String lengthType;
		private Integer recordCount;

		public String getMatchType() {
			return matchType;
		}

		public void setMatchType(String matchType) {
			this.matchType = matchType;
		}

		public String getLengthType() {
			return lengthType;
		}

		public void setLengthType(String lengthType) {
			this.lengthType = lengthType;
		}

		public Integer getRecordCount() {
			return recordCount;
		}

		public void setRecordCount(Integer recordCount) {
			this.recordCount = recordCount;
		}

	}
	
	public static void main(String[] args) {
		CampaignCreationRequest campaignCreationRequest = new CampaignCreationRequest();
		
	}
}
