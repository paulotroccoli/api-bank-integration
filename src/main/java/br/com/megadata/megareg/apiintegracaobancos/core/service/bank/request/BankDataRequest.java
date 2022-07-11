package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankDataRequest {

	private Long numeroRequisicao;
	private Integer codigoContrato;
	private Integer numeroAgenciaDebito;
	private String numeroContaCorrenteDebito;
	private String digitoVerificadorContaCorrenteDebito;
	private List<BarCodeDataRequest> lancamentos;
}
