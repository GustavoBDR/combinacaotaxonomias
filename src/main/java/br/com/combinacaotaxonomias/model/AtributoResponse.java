package br.com.combinacaotaxonomias.model;

public class AtributoResponse {
	private Integer attributeId;
	private String name;
	private String attributeUnit;
	private String attributeType;
	private Boolean needed;
	public Integer getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttributeUnit() {
		return attributeUnit;
	}
	public void setAttributeUnit(String attributeUnit) {
		this.attributeUnit = attributeUnit;
	}
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public Boolean getNeeded() {
		return needed;
	}
	public void setNeeded(Boolean needed) {
		this.needed = needed;
	}
}
