package br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;

/** campos esperados na chamada para realizar a emissão, onde dados é o json esperado pelo Banco
* @author Edson Cicero
* @since 15/04/2022
*/

import lombok.Data;

@Data
@Builder
public class BarCodeDataResponse {

	private String codigoIdentificadorPagamento;
	private String nomeBeneficiario;
	private String codigoBarras;
	private Integer dataPagamento;
	private BigDecimal valorPagamento;
	private Long numeroDocumentoDebito;
	private String codigoSeuDocumento;
	private String descricaoPagamento;
	private String indicadorAceite;
	private List<Integer> errors;
}
