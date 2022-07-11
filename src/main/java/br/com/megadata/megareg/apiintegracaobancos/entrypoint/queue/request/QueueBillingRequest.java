package br.com.megadata.megareg.apiintegracaobancos.entrypoint.queue.request;

import java.math.BigDecimal;

import br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing.SubmitBillingRequest;

/** campos esperados na chamada para realizar a emissão, onde dados é o json esperado pelo Banco
* @author Edson Cicero
* @since 15/04/2022
*/

import lombok.Data;

@Data
public class QueueBillingRequest {

	private String codigoBarras;
	private Integer dataPagamento;
	private BigDecimal valorPagamento;
	private Long numeroDocumentoDebito;
	private String codigoSeuDocumento;
	private String descricaoPagamento;
	
	public SubmitBillingRequest toSendBillingToBankRequest() {
		return SubmitBillingRequest.builder()
				.codigoBarras(codigoBarras)
				.codigoSeuDocumento(codigoSeuDocumento)
				.dataPagamento(dataPagamento)
				.descricaoPagamento(descricaoPagamento)
				.numeroDocumentoDebito(numeroDocumentoDebito)
				.valorPagamento(valorPagamento)
				.build();
	}
}
