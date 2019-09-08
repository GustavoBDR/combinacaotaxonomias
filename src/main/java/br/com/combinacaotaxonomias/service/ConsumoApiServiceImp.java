package br.com.combinacaotaxonomias.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.TokenApiRequest;
import br.com.combinacaotaxonomias.model.TokenApiResponse;

@Service("consumoApiService")
public class ConsumoApiServiceImp implements ConsumoApiService{
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public TokenApiResponse getAutenticacao(String url, String id, String key) {
		TokenApiRequest tokenApiRequest = new TokenApiRequest(id,key);
		
		url = "https://api.marketplace.colombo.com.br/v1/authentication";
		
		ResponseEntity<TokenApiResponse> response = restTemplate.postForEntity(url, tokenApiRequest, TokenApiResponse.class);
		
		TokenApiResponse token = response.getBody();
		
		return token;
	}


	@Override
	public List<Categoria> getCategorias(String url){
		
		url = "https://api.marketplace/v1/category"; 
	    String accessToken = "Bearer 123asd"; 

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);
        
        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));
        
        
        ResponseEntity<Categoria[]> response = restTemplate.exchange(request, Categoria[].class);


        return Arrays.asList(response.getBody());

	} 

}
