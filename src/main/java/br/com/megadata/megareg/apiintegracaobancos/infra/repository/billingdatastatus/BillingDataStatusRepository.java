package br.com.megadata.megareg.apiintegracaobancos.infra.repository.billingdatastatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.megadata.megareg.apiintegracaobancos.infra.repository.entity.BillingDataStatus;


@Repository
public interface BillingDataStatusRepository extends JpaRepository<BillingDataStatus, Long>, BillingDataStatusRepositoryQueries {

	
}
