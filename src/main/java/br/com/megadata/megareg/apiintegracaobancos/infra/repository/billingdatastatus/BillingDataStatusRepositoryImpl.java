package br.com.megadata.megareg.apiintegracaobancos.infra.repository.billingdatastatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BillingDataStatusRepositoryImpl implements BillingDataStatusRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

}
