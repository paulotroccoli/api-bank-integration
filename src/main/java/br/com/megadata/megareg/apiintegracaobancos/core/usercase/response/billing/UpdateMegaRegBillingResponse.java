package br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing;

import lombok.Builder;

/** campos esperados na chamada para realizar a emissão, onde dados é o json esperado pelo Banco
* @author Edson Cicero
* @since 15/04/2022
*/

import lombok.Data;

@Data
@Builder
public class UpdateMegaRegBillingResponse {

	private String codigoBarras;
	private String dataEnvio;
	private String dataPagamento;
	private String errors;
}
