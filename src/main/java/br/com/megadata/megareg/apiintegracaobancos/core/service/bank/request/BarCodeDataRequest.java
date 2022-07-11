package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request;

import java.math.BigDecimal;

import lombok.Builder;

/** campos esperados na chamada para realizar a emissão, onde dados é o json esperado pelo Banco
* @author Edson Cicero
* @since 15/04/2022
*/

import lombok.Data;

@Data
@Builder
public class BarCodeDataRequest {

	private String codigoBarras;
	private Integer dataPagamento;
	private BigDecimal valorPagamento;
	private Long numeroDocumentoDebito;
	private String codigoSeuDocumento;
	private String descricaoPagamento;
	
}
