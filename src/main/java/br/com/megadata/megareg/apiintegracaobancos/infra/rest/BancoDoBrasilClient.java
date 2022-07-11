package br.com.megadata.megareg.apiintegracaobancos.infra.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.BillingDataBancoDoBrasilResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingBancoDoBrasilResponse;
import br.com.megadata.megareg.apiintegracaobancos.infra.exception.BancoDoBrasilClientException;
import br.com.megadata.megareg.apiintegracaobancos.infra.rest.response.AccessTokenResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BancoDoBrasilClient extends HttpClient{

	@Value("${megareg.bancos.bco001.url-token}")
	private String url_token;
	
	@Value("${megareg.bancos.bco001.contenttype}")
	private String contenttype;
	
	@Value("${megareg.bancos.bco001.granttype}")
	private String granttype;
	
	@Value("${megareg.bancos.bco001.authorization}")
	private String authorization;
	
	@Value("${megareg.bancos.bco001.clientid}")
	private String clientid;
	
	@Value("${megareg.bancos.bco001.secretid}")
	private String secretid;
	
	@Value("${megareg.bancos.bco001.developerapplicationkey}")
	private String developerapplicationkey;
	
	@Value("${megareg.bancos.bco001.url-server}")
	private String url_server;
	
	//---
	public String getToken() {
		try {
			
			Map<Object, Object> params = new HashMap<>();
			params.put("grant_type", "client_credentials");
			
            String requestBody = new Gson().toJson(params);
            
            HttpHeaders headersWithAdminToken = new HttpHeaders();
            headersWithAdminToken.add("Authorization", authorization);
            headersWithAdminToken.add("Content-Type", contenttype);
            
            ResponseEntity<String> objectResponseEntity = post(url_server, headersWithAdminToken, requestBody);

            AccessTokenResponse acesso = new Gson().fromJson(objectResponseEntity.getBody(), AccessTokenResponse.class);
            
            return acesso.getAccess_token();
	        
        } catch (Exception e) {
        	throw new BancoDoBrasilClientException("Error get token from client", e);
        }
	}

	public Optional<BillingDataBancoDoBrasilResponse> submitBilling(String token, IBankBilling dadosBancoTaxaContratoRequest){

		try {
			//---
			final String URL = url_server + "/lotes-guias-codigo-barras";
			
			final String requestBody = new Gson().toJson(dadosBancoTaxaContratoRequest);
			
			final HttpHeaders headersWithAdminToken = new HttpHeaders();
            headersWithAdminToken.add("accept", "application/json");
            headersWithAdminToken.add("Content-Type", "application/json");
            headersWithAdminToken.add("X-Developer-Application-Key", developerapplicationkey);
            headersWithAdminToken.add("Authorization", "Bearer "+ token);
            
            ResponseEntity<String> objectResponseEntity = post(URL, headersWithAdminToken, requestBody);
            
            return Optional.ofNullable(new Gson().fromJson(objectResponseEntity.getBody(), BillingDataBancoDoBrasilResponse.class));
            
        } catch (Exception e) {
            throw new BancoDoBrasilClientException("Error submit billing to client", e);
        }
	}

	
	public Optional<ConsultBillingBancoDoBrasilResponse> consultBilling(String token, String id){
		try {
			//---
		    final String URL =  url_server + "/pagamentos-codigo-barras/" + id;
			
			final HttpHeaders headersWithAdminToken = new HttpHeaders();
            headersWithAdminToken.add("Authorization", "Bearer "+ token);
            
            ResponseEntity<String> objectResponseEntity = get(URL, headersWithAdminToken);
            
            return Optional.ofNullable(new Gson().fromJson(objectResponseEntity.getBody(), ConsultBillingBancoDoBrasilResponse.class));
            
        } catch (Exception e) {
        	throw new BancoDoBrasilClientException("Error consult billing client", e);
        }
	}
}
