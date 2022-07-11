package br.com.megadata.megareg.apiintegracaobancos.infra.repository.detrantaxacontratobanco;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DetranTaxaContratoBancoRepositoryImpl implements DetranTaxaContratoBancoRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public BigInteger getProximoNumero() {
		Query query = manager.createNativeQuery("SELECT nextval('sis_contrato.api_integracao_bb')");
		
		return (BigInteger) query.getSingleResult();
	}
	
	
}
