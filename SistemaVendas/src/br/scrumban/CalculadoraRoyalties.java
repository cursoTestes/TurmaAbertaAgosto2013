package br.scrumban;

import java.util.List;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;

public class CalculadoraRoyalties {
	
	private VendaRepository dao;
	private CalculadoraComissao calculadoraComissao;
	
	public CalculadoraRoyalties(VendaRepository repository, CalculadoraComissao paramCalculadora)
	{
		dao = repository;
		calculadoraComissao = paramCalculadora;
		
	}

	public double calcular(int mes, int ano) {
		
		List<Venda> lista = dao.obterVendasPorMesEAno(ano, mes);
		double totalLiquido = 0;
		for(Venda v: lista)
		{
			totalLiquido += v.getValor() - (calculadoraComissao.calcula(v.getValor()));  
		}
		return totalLiquido * 0.2;
	}
	

	
	

}
