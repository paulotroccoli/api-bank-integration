package br.com.megadata.megareg.apiintegracaobancos.infra.repository.detrantaxacontratobanco;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.megadata.megareg.apiintegracaobancos.infra.repository.entity.DetranTaxaContratoBanco;


@Repository
public interface DetranTaxaContratoBancoRepository extends JpaRepository<DetranTaxaContratoBanco, Long>, DetranTaxaContratoBancoRepositoryQueries {

	public Optional<DetranTaxaContratoBanco> findByAtivo(Boolean ativo);
	
}
