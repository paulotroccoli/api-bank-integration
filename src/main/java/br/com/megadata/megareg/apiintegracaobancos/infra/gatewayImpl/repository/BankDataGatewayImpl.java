package br.com.megadata.megareg.apiintegracaobancos.infra.gatewayImpl.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BankData;
import br.com.megadata.megareg.apiintegracaobancos.core.exception.GatewayException;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository.BankDataGateway;
import br.com.megadata.megareg.apiintegracaobancos.infra.repository.detrantaxacontratobanco.DetranTaxaContratoBancoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankDataGatewayImpl implements BankDataGateway{

	private final DetranTaxaContratoBancoRepository detranTaxaContratoBancoRepository;
	
	@Override
	public Optional<BankData> getActiveDataBank(){
		try {
			return detranTaxaContratoBancoRepository.findByAtivo(true).map(x -> x.toDadosBanco());
			
		} catch (Exception e) {
        	throw new GatewayException("Uodate Megareg billing", e);
        }
	}

	@Override
	public BigInteger getNextNumber() {
		
		try {
			return detranTaxaContratoBancoRepository.getProximoNumero();
		
		} catch (Exception e) {
        	throw new GatewayException("Uodate Megareg billing", e);
        }
	}
}
