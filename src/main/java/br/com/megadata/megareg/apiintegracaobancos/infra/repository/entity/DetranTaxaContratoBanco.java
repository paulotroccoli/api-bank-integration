package br.com.megadata.megareg.apiintegracaobancos.infra.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BankData;
import lombok.Data;


@Where(clause = "bo_ativo=true")
@Entity
@Table(name="tb_detrantaxacontratobanco", schema = "sis_contrato")
@SequenceGenerator(name = "sis_contrato.tb_detrantaxacontratobanco_id_detrantaxacontratobanco_seq", sequenceName = "sis_contrato.tb_detrantaxacontratobanco_id_detrantaxacontratobanco_seq", allocationSize = 1)
@Data
public class DetranTaxaContratoBanco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sis_contrato.tb_detrantaxacontratobanco_id_detrantaxacontratobanco_seq")
	@Column(name="id_detrantaxacontratobanco", nullable = false)
	private Integer detranTaxaContratoBancoID;
	
	@Column(name="cd_codigobanco", nullable = false)
	private Integer codigoBanco;
	
	@Column(name="cd_codigocontrato", nullable = false)
	private Integer codigoContrato;
	
	@Column(name="cd_agencianumero", nullable = false)
    private Integer agenciaNumero;
	
	@Column(name="cd_agenciadv", length = 1, nullable = false)
    private String agenciaDV;
    
	@Column(name="cd_contacorrentenumero", length = 10, nullable = false)
    private String contaCorrenteNumero;
	
	@Column(name="cd_contacorrentedv", length = 1, nullable = false)
    private String contaCorrenteDV;
	
	@Column(name="bo_operacional", nullable = false)
    private Boolean operacional;
	
	@Column(name="bo_ativo", nullable = false)
	private Boolean ativo;
	
	@Column(name = "cd_codigooperador", nullable = false)
	private Integer codigoOperador;
	
	@Column(name = "dt_datainclusao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;
	
	@Column(name = "dt_dataalteracao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	public BankData toDadosBanco() {
		return BankData.builder()
				.agenciaDV(agenciaDV)
				.agenciaNumero(agenciaNumero)
				.codigoBanco(codigoBanco)
				.codigoContrato(codigoContrato)
				.contaCorrenteDV(contaCorrenteDV)
				.contaCorrenteNumero(contaCorrenteNumero)
				.id(detranTaxaContratoBancoID)
				.operacional(operacional)
				.build();
		
	}
}
