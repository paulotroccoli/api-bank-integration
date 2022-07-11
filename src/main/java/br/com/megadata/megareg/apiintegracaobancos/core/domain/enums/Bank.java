package br.com.megadata.megareg.apiintegracaobancos.core.domain.enums;

/** relacao dos bancos que poderemos realizar transacos financeiras
* @author Edson Cicero
* @since 16/04/2022
*/

public enum Bank {
	BB			(  1, "Banco do Brasil"),
	SANTANDER	( 33, "Santander"),
	BRADESCO	(237, "Bradesco");
	
	private Integer code;
	private String description;
	
	Bank(Integer code, String description) {
		this.code = code;
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}
	public Integer getCode() {
		return code;
	}
	
	public static Bank getByCode(Integer code){
		if (code == null)
			return null;
		for (Bank e : Bank.values()){
			if (e.code.equals(code))
				return e;
		}
		return null;
	}
}
