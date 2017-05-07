package com.home.geeks;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ProductEntity {

	private String productCode;
	private String campaignid;
	private Double productScore = 0.0;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCampaignid() {
		return campaignid;
	}

	public void setCampaignid(String campaignid) {
		this.campaignid = campaignid;
	}

	public Double getProductScore() {
		return productScore;
	}

	public void setProductScore(Double productScore) {
		this.productScore = productScore;
	}

	public ProductEntity(String productCode, String campaignid, Double productScore) {
		super();
		this.productCode = productCode;
		this.campaignid = campaignid;
		this.productScore = productScore;
	}

	public static void main(String[] args) {
		wrongApproach();
	}

	private static void wrongApproach() {
		FirstComparator fc = new FirstComparator();
		Set<ProductEntity> sortedSet = new TreeSet<ProductEntity>(new SecondComparator());
		sortedSet.add(new ProductEntity("PO001", "C001", 1.2));
		sortedSet.add(new ProductEntity("PO001", "C002", 1.2));
		sortedSet.add(new ProductEntity("PO001", "C003", 1.2));

		System.out.println(sortedSet);
	}

	static class FirstComparator implements Comparator<ProductEntity> {
		@Override
		public int compare(ProductEntity o1, ProductEntity o2) {
			return o1.getProductScore().compareTo(o2.getProductScore());
		}
	}

	static class SecondComparator implements Comparator<ProductEntity> {
		@Override
		public int compare(ProductEntity o1, ProductEntity o2) {
			int score = o1.getProductScore().compareTo(o2.getProductScore());
			if (score == 0) {
				score = o1.getCampaignid().compareTo(o2.getCampaignid());
				if (score == 0) {
					score = o1.getProductCode().compareTo(o2.getProductCode());
				}
			}
			return score;
		}

	}

	@Override
	public String toString() {
		return "ProductEntity [productCode=" + productCode + ", campaignid=" + campaignid + ", productScore=" + productScore + "]";
	}

}
