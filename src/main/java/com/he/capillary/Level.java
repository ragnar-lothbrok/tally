package com.he.capillary;

import java.util.ArrayList;
import java.util.List;

public class Level {

	private String label;
	private String imageUrl = "";
	private List<Level> attributes = new ArrayList<Level>();
	private String pageUrl = "";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Level> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Level> attributes) {
		this.attributes = attributes;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Level other = (Level) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Level [label=" + label + ", imageUrl=" + imageUrl + ", attributes=" + attributes + ", pageUrl="
				+ pageUrl + "]";
	}

}
