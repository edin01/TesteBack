package principal;

import java.sql.SQLException;

import dados.Dados;
import dados.Gerar;
import dao.DadosDAO;

public class Principal {

	public static void main(String[] args) throws SQLException {
		
		/* Objetos necess�rios para pegar os dados */
		
		Dados d = new Dados();
		Gerar g = new Gerar();
		DadosDAO dd = new DadosDAO();
		
		/* la�o para gerar todos os dados */
		
		int i;
		for (i = 0; i < 4000; i++) {
			d.setNm_customer(g.criarNomes());
			d.setCpf_cnpj(g.criarcpfcnpj());
			d.setIs_active(g.status());
			d.setVl_total(g.valor());
			
			
	   /* colocando no banco */
			
			dd.inserir(d);
		}
			
		/* m�todos para imprimir os dados e a m�dia */
			
			dd.select(d);
			dd.media(d);
			dd.limpar(d); /* um m�todo para limpar a tabela, para todas as vezes que for executado permanecer os 4 mil dados */
		
	}
}
		
