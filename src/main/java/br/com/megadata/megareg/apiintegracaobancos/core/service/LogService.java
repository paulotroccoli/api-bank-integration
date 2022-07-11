package br.com.megadata.megareg.apiintegracaobancos.core.service;

/** Ajuda para manipular String
* @author Edson Cicero
* @since 16/04/2022
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogService {
	
	@Value("${megareg.diretorio-base-log}")
	private String diretorioBase;
	
	@Value("${megareg.aplicacao-nome}")
	private String aplicacao_nome;

	public void escreverArquivo(String sMensagem) {
		try {
			//---
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String nomeCompletoArquivoLog = String.format("%s%s%s%s%s.log", diretorioBase, File.separator.toString(), "logs", File.separator.toString() , sdf.format(new Date()));

			FileOutputStream os = new FileOutputStream(nomeCompletoArquivoLog, true);
            //OutputStreamWriter ow = new OutputStreamWriter(os, "ISO-8859-1");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "ISO-8859-1"));

            bw.write(String.format("%s - %s", sdf2.format(new Date()), sMensagem));
            bw.newLine();

            bw.flush();
            bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void info(String mensagem) {
		escreverArquivo("["+aplicacao_nome+"]"+"--INFO-- " + mensagem);
	}
	
	public void warning(String mensagem) {
		escreverArquivo("["+aplicacao_nome+"]"+"--WARNING-- " + mensagem);
	}
	
	public void error(String mensagem) {
		escreverArquivo("["+aplicacao_nome+"]"+"--ERROR-- " + mensagem);
	}
}
