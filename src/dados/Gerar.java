package dados;

import java.text.DecimalFormat;
import java.util.Random;

public class Gerar {
	
	Random rd = new Random();
	
	/* Classe criada para gerar dados aleatórios e preencher a tabela para testar o funcionamento */
	
	public String criarNomes(){

		int cont;
		int v;
		int c;
		String n = "";
		String nomefinal = "";
		String vogal[] = {"a","e", "i", "o", "u","ão"};
		String consoante[] = {"b", "c", "ç","d", "f", "g", "h", "j", "k", "l", 
	    "m", "n", "p", "q", "r", "s", "t", "w", "x", "y", "z"};
		for (cont = 0; cont <= 2; cont++) {
			v = rd.nextInt(5);
			c = rd.nextInt(20);
			n = vogal[v] + consoante[c];
			nomefinal += n;
		}
		return nomefinal;
	}
	
	public long criarcpfcnpj(){
		/* primeiro é feito um if else aleatório, para criar uma variedade e não criar apenas CPF's. */
		int tp2 = rd.nextInt(2);
		String tipos[] = {"CPF","CNPJ"};
		if (tipos[tp2]=="CPF") { /* é gerado cpf */
		int cont1;
		int imp;
		int par;
		int ult;
		String num = "";
		String numero = "";
		String impares[] = {"1", "3", "5", "7", "9"};
		String pares[] = {"0","2","4","6","8"};
		String ultimo[] = {"0","1","2","3","4","5","6","7","8","9"};
		for (cont1 = 0; cont1 <= 4; cont1++) {
			imp = rd.nextInt(4);
			par = rd.nextInt(4);
			num = impares[imp] + pares[par];
			numero += num;
		}
		ult = rd.nextInt(9);
		return Long.parseLong(numero + ultimo[ult]);
	} else { 
		/* é gerado CNPJ */
			int cont1;
			int imp;
			int par;
			String num = "";
			String numero = "";
			String impares[] = {"1", "3", "5", "7", "9"};
			String pares[] = {"0","2","4","6","8"};
			for (cont1 = 0; cont1 <= 6; cont1++) {
				imp = rd.nextInt(4);
				par = rd.nextInt(4);
				num = impares[imp] + pares[par];
				numero += num;
			}
			return Long.parseLong(numero);
	}
	}
	
	
	public String status(){
		String ativo = "";
		int i = rd.nextInt(2);
		ativo = (i == 0) ? "Sim" : "Não";
		return ativo;
	}

	public double valor(){
		DecimalFormat dec = new DecimalFormat("0.##");
		double total = 50.00 + (1000 * rd.nextDouble() * 2);
		return Double.parseDouble(dec.format(total).replace(",", "."));
	}




}
