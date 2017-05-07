package com.he.capillary;

public class LevelDetail {

	private String superCat;
	private String partCat;
	private String cat;
	private String subCat;
	private String label;

	public LevelDetail(String superCat, String partCat, String cat, String subCat, String label) {
		super();
		this.superCat = superCat;
		this.partCat = partCat;
		this.cat = cat;
		this.subCat = subCat;
		this.label = label;
	}

	public String getSuperCat() {
		return superCat;
	}

	public void setSuperCat(String superCat) {
		this.superCat = superCat;
	}

	public String getPartCat() {
		return partCat;
	}

	public void setPartCat(String partCat) {
		this.partCat = partCat;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getSubCat() {
		return subCat;
	}

	public void setSubCat(String subCat) {
		this.subCat = subCat;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((partCat == null) ? 0 : partCat.hashCode());
		result = prime * result + ((subCat == null) ? 0 : subCat.hashCode());
		result = prime * result + ((superCat == null) ? 0 : superCat.hashCode());
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
		LevelDetail other = (LevelDetail) obj;
		if (cat == null) {
			if (other.cat != null)
				return false;
		} else if (!cat.equals(other.cat))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (partCat == null) {
			if (other.partCat != null)
				return false;
		} else if (!partCat.equals(other.partCat))
			return false;
		if (subCat == null) {
			if (other.subCat != null)
				return false;
		} else if (!subCat.equals(other.subCat))
			return false;
		if (superCat == null) {
			if (other.superCat != null)
				return false;
		} else if (!superCat.equals(other.superCat))
			return false;
		return true;
	}

}
