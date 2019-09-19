package br.com.combinacaotaxonomias.model;

public class CategoriaResponse {
	
	private boolean eanRequired;
	private Integer familyId;
	private String familyName;
	private Integer groupId;
	private String groupName;
	private Integer lineId;
	private String lineName;
	private Integer idCategoriaPai;
		
	public boolean isEanRequired() {
		return eanRequired;
	}
	public void setEanRequired(boolean eanRequired) {
		this.eanRequired = eanRequired;
	}
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getLineId() {
		return lineId;
	}
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public Integer getIdCategoriaPai() {
		return idCategoriaPai;
	}
	public void setIdCategoriaPai(Integer idCategoriaPai) {
		this.idCategoriaPai = idCategoriaPai;
	}
	
}
