package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.BarCodeDataResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingDataBancoSantanderResponse {

	private Long numeroRequisicao;
	private Integer codigoEstado;
	private Integer quantidadeLancamentos;
	private BigDecimal valorLancamentos;
	private Integer quantidadeLancamentosValidos;
	private BigDecimal valorLancamentosValidos;
	private List<BarCodeDataBancoDoBrasilResponse> lancamentos;
	
	public SubmitBillingResponse toDadosBancoTaxaContratoResponse() {
		
		List<BarCodeDataResponse> lancamentosTaxaContratoResponse = new ArrayList<BarCodeDataResponse>();
		
		for (BarCodeDataBancoDoBrasilResponse lancamentosTaxaContratoBrasilResponse : lancamentos) {
			lancamentosTaxaContratoResponse.add(BarCodeDataResponse.builder()
						.codigoBarras(lancamentosTaxaContratoBrasilResponse.getCodigoBarras())
						.codigoSeuDocumento(lancamentosTaxaContratoBrasilResponse.getCodigoSeuDocumento())
						.dataPagamento(lancamentosTaxaContratoBrasilResponse.getDataPagamento())
						.descricaoPagamento(lancamentosTaxaContratoBrasilResponse.getDescricaoPagamento())
						.numeroDocumentoDebito(lancamentosTaxaContratoBrasilResponse.getNumeroDocumentoDebito())
						.valorPagamento(lancamentosTaxaContratoBrasilResponse.getValorPagamento())
						.errors(lancamentosTaxaContratoBrasilResponse.getErrors())
						.build()
					);
		}
		
		return SubmitBillingResponse.builder()
				.codigoEstado(codigoEstado)
				.lancamentos(lancamentosTaxaContratoResponse)
				.numeroRequisicao(numeroRequisicao)
				.quantidadeLancamentos(quantidadeLancamentos)
				.quantidadeLancamentosValidos(quantidadeLancamentosValidos)
				.valorLancamentos(valorLancamentos)
				.valorLancamentosValidos(valorLancamentosValidos)
				.build();
	}
}
