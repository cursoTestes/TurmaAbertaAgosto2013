package br.scrumban;

public class CalculadoraComissao {

	public static double calcula(double valorVenda) {
		double valorComissao;
		if(valorVenda > 10000)
			valorComissao = (valorVenda * 6) / 100;
		else{
			valorComissao = (valorVenda * 5) / 100;
		}
		valorComissao = Math.floor(valorComissao*100.0)/100.0;
		
		return valorComissao;
		
	}
	

}
