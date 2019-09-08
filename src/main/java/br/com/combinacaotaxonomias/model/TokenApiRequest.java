package br.com.combinacaotaxonomias.model;

public class TokenApiRequest {
	private String apiTokenId;
	private String apiKey;
	
	public TokenApiRequest() {
		
	}
	
	public TokenApiRequest(String apiTokenId, String apiKey) {
		this.apiTokenId = apiTokenId;
		this.apiKey = apiKey;
	}	
	public String getApiTokenId() {
		return apiTokenId;
	}
	public void setApiTokenId(String apiTokenId) {
		this.apiTokenId = apiTokenId;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
