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

import br.com.combinacaotaxonomias.common.TokenApi;
import br.com.combinacaotaxonomias.common.UrlApi;
import br.com.combinacaotaxonomias.model.AtributoResponse;
import br.com.combinacaotaxonomias.model.Categoria;
import br.com.combinacaotaxonomias.model.CategoriaResponse;
import br.com.combinacaotaxonomias.model.Plataforma;
import br.com.combinacaotaxonomias.model.TokenApiRequest;
import br.com.combinacaotaxonomias.model.TokenApiResponse;

@Service("consumoApiService")
public class ConsumoApiServiceImp implements ConsumoApiService{
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void getAutenticacao(Plataforma marketplace) {
		TokenApiRequest tokenApiRequest = new TokenApiRequest(marketplace.getApiTokenId(),marketplace.getApiTokenKey());

		ResponseEntity<TokenApiResponse> response = restTemplate.postForEntity(marketplace.getUrlApiPostAutenticacao(), tokenApiRequest, TokenApiResponse.class);
		
		TokenApiResponse token = response.getBody();
		
		TokenApi.TOKEN = "Bearer "+ token.getAccess_token();

	}

	@Override
	public List<CategoriaResponse> getCategorias(Plataforma plataforma){
				
	    getAutenticacao(plataforma);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", TokenApi.TOKEN);
        
        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(plataforma.getUrlAPIGetCategorias()));
        
        
        ResponseEntity<CategoriaResponse[]> response = restTemplate.exchange(request, CategoriaResponse[].class);


        return Arrays.asList(response.getBody());

	}
	
	@Override
	public List<AtributoResponse> getAtributos(Plataforma plataforma, Integer idCategoria){

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", TokenApi.TOKEN);
        
        String url = UrlApi.peparaUrlGetAtributos(plataforma.getUrlAPIGetAtributos(), idCategoria.toString());
        RequestEntity<Object> request = new RequestEntity<>(
        									headers, HttpMethod.GET, URI.create(url));
        
        ResponseEntity<AtributoResponse[]> response = restTemplate.exchange(request, AtributoResponse[].class);
        

        return Arrays.asList(response.getBody());

	} 	

}
