package br.com.megadata.megareg.apiintegracaobancos.infra.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.infra.exception.MegaregClientException;

@Service
public class MegaregClient extends HttpClient{
	
	@Value("${megareg.api.url}")
    private String megareURL;
	
	public void updateMegaRegBilling(UpdateMegaRegBillingResponse updateMegaRegBillingResponse) {
        String URL = megareURL.concat("/taxacontratodetran/atualizar-taxa"); 

        try {
        	Date timeStamp = new Date();
        	String autorization = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNjU5NDc3NzM0LCJhdXRob3JpdGllcyI6WyJST0xFX0NMSUVOVCJdLCJqdGkiOiJjMGMxZGRiNS0yNzRiLTQ2ZTgtYTA5NS1mY2JhOTc0MmJhOTgiLCJjbGllbnRfaWQiOiI0RkM4MTNFMUY4QTEyMkQ3RUU4MTJERjczMDY1QTczQzJFQjY1QzU1RjFCMkQ1NjhBODg1RkFDMzlFMjBDODdDOTUyMzYyRkEifQ.WpfgpcHLvs5wiSJNYXL1suqHyY-9r03T2BNx5qvUqAtBOQLKfwEfsnw6cFecAY0MCClniBZhTqzNxukKHuQbg8aeQj-uWCdGagsYV6mZbIcpVUCwpAGrCoIsWw6c5oxSKi41LFIf5Yt7ZR5FsQBsybvSXNlxSGUM17IuqL304qZhZiWNTOajWRK2OU4uY_lnONlJ-Oq-WAFTKvw2m2qQv5-Qz4Hig2Vh-AUqKH8KbAOD0dKZJZG0qCT7kh1UDXerCaDb8QWEpqMLbcDMivbtdc66xIx2q821-6WZyC7yMnkgx0f7urcqvO_D1i7-Fz_YxwNQqi19Hj_O-YvqfuKfiw";
        	
            String requestBody = new Gson().toJson(updateMegaRegBillingResponse);
            
            HttpHeaders headersWithAdminToken = new HttpHeaders();
            headersWithAdminToken.add("Timestamp", timeStamp.toString());
            headersWithAdminToken.add("Authorization", autorization);
            headersWithAdminToken.add("URL", URL);
            
            post(URL, headersWithAdminToken, requestBody);

        } catch (Exception e) {
        	throw new MegaregClientException("Error update megareg billing", e);
        }

    }
}
