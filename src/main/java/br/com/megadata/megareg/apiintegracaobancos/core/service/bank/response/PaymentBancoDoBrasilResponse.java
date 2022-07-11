package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentBancoDoBrasilResponse {

	private List<String> error;
}
