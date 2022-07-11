package br.com.megadata.megareg.apiintegracaobancos.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingData {

	private Integer id;
	private Integer bankCode;
	private String barCode;
}
