package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;

@Getter
public class BarCodeDataBancoSantanderResponse {

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
