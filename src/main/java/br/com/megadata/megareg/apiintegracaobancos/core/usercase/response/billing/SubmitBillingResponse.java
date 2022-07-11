package br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubmitBillingResponse {

	private Long numeroRequisicao;
	private Integer codigoEstado;
	private Integer quantidadeLancamentos;
	private BigDecimal valorLancamentos;
	private Integer quantidadeLancamentosValidos;
	private BigDecimal valorLancamentosValidos;
	private List<BarCodeDataResponse> lancamentos;
}
