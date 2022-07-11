package br.com.megadata.megareg.apiintegracaobancos.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankData {

	private final Integer id;
	private final Integer codigoBanco;
	private final Integer codigoContrato;
    private final Integer agenciaNumero;
    private final String agenciaDV;
    private final String contaCorrenteNumero;
    private final String contaCorrenteDV;
    private final Boolean operacional;
}
