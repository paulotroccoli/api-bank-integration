package br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing;

import java.math.BigDecimal;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BarCodeDataRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubmitBillingRequest {

	private String codigoBarras;
	private Integer dataPagamento;
	private BigDecimal valorPagamento;
	private Long numeroDocumentoDebito;
	private String codigoSeuDocumento;
	private String descricaoPagamento;
	
	public BarCodeDataRequest toBarCodeDataRequest() {
		return BarCodeDataRequest.builder()
				.codigoBarras(codigoBarras)
				.codigoSeuDocumento(codigoSeuDocumento)
				.codigoSeuDocumento(codigoSeuDocumento)
				.dataPagamento(dataPagamento)
				.descricaoPagamento(descricaoPagamento)
				.numeroDocumentoDebito(numeroDocumentoDebito)
				.valorPagamento(valorPagamento)
				.build();
	}
}
