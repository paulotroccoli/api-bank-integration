package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request;

import java.util.ArrayList;
import java.util.List;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingDataBancoDoBrasilRequest implements IBankBilling{

	private Long numeroRequisicao;
	private Integer codigoContrato;
	private Integer numeroAgenciaDebito;
	private String numeroContaCorrenteDebito;
	private String digitoVerificadorContaCorrenteDebito;
	private List<BarCodeDataBancoDoBrasilRequest> lancamentos;
	
	
	@Override
	public IBankBilling converteBankData(BankDataRequest bankDataRequest) {
		final List<BarCodeDataBancoDoBrasilRequest> lancamentosTaxaContratoBancoDoBrasilRequests = new ArrayList<BarCodeDataBancoDoBrasilRequest>();
		
		for (BarCodeDataRequest barCodeDataRequest : bankDataRequest.getLancamentos()) {
			lancamentosTaxaContratoBancoDoBrasilRequests.add(BarCodeDataBancoDoBrasilRequest.builder()
						.codigoBarras(barCodeDataRequest.getCodigoBarras())
						.codigoSeuDocumento(barCodeDataRequest.getCodigoSeuDocumento())
						.dataPagamento(barCodeDataRequest.getDataPagamento())
						.descricaoPagamento(barCodeDataRequest.getDescricaoPagamento())
						.numeroDocumentoDebito(barCodeDataRequest.getNumeroDocumentoDebito())
						.valorPagamento(barCodeDataRequest.getValorPagamento())
						.build()
					);
		}
		
		return BillingDataBancoDoBrasilRequest.builder()
				.codigoContrato(bankDataRequest.getCodigoContrato())
				.digitoVerificadorContaCorrenteDebito(bankDataRequest.getDigitoVerificadorContaCorrenteDebito())
				.lancamentos(lancamentosTaxaContratoBancoDoBrasilRequests)
				.numeroAgenciaDebito(bankDataRequest.getNumeroAgenciaDebito())
				.numeroContaCorrenteDebito(bankDataRequest.getNumeroContaCorrenteDebito())
				.numeroRequisicao(bankDataRequest.getNumeroRequisicao())
				.build();
	}
}
