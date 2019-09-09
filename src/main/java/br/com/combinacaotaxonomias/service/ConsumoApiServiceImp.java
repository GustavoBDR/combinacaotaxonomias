package br.com.combinacaotaxonomias.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.TokenApiRequest;
import br.com.combinacaotaxonomias.model.TokenApiResponse;

@Service("consumoApiService")
public class ConsumoApiServiceImp implements ConsumoApiService{
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public String getAutenticacao(Plataforma marketplace) {
		TokenApiRequest tokenApiRequest = new TokenApiRequest(marketplace.getApiTokenId(),marketplace.getApiTokenKey());

		ResponseEntity<TokenApiResponse> response = restTemplate.postForEntity(marketplace.getUrlApiPostAutenticacao(), tokenApiRequest, TokenApiResponse.class);
		
		TokenApiResponse token = response.getBody();
		
		return "Bearer "+ token.getAccess_token();
	}


	@Override
	public List<Categoria> getCategorias(Plataforma marketplace){
				
	    String accessToken = getAutenticacao(marketplace);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);
        
        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(marketplace.getUrlAPIGetCategorias()));
        
        
        ResponseEntity<Categoria[]> response = restTemplate.exchange(request, Categoria[].class);


        return Arrays.asList(response.getBody());

	} 

}
