package br.com.megadata.megareg.apiintegracaobancos.infra.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class HttpClient {

	public ResponseEntity<String> post(String url, HttpHeaders headers, String body) {
		
		headers.setContentType(MediaType.APPLICATION_JSON);
			
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> requestData = new HttpEntity<String>(body, headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestData, String.class);

	}
	
	public ResponseEntity<String> get(String url, HttpHeaders headers) {
		
		headers.setContentType(MediaType.APPLICATION_JSON);
			
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> requestData = new HttpEntity<String>("", headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestData, String.class);

	}
}
