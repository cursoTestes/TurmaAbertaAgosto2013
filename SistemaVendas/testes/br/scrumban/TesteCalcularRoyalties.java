package br.scrumban;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;


public class TesteCalcularRoyalties {

	
	@Test
	public void teste_mes_sem_venda() {
		
		double esperado = 0;
		int mes = 1;
		int ano = 2012;
		CalculadoraComissao mockCalculadora = mock(CalculadoraComissao.class);
		
		VendaRepository mockVendaRepo = mock(VendaRepository.class);
		double resultado = new CalculadoraRoyalties(mockVendaRepo,mockCalculadora).calcular(mes,ano);
		
		Assert.assertEquals(esperado, resultado,0);

	}
	
	@Test
	public void teste_mes_com_2_vendas_100_Reais_cada() {
		
		double esperado =40 ;
		int mes = 3;
		int ano = 2012;
		
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(1,1,mes,ano,100);
		vendas.add(venda);
		Venda venda2 = new Venda(2,1,mes,ano,100);
		vendas.add(venda2);
		
		CalculadoraComissao mockCalculadora = mock(CalculadoraComissao.class);
		when(mockCalculadora.calcula(any(Double.class))).thenReturn(0.0);
		
		VendaRepository mockVendaRepo = mock(VendaRepository.class);
		when(mockVendaRepo.obterVendasPorMesEAno(any(Integer.class), any(Integer.class))).thenReturn(vendas);
		
		double resultado = new CalculadoraRoyalties(mockVendaRepo,mockCalculadora).calcular(mes,ano);

		
		Assert.assertEquals(esperado, resultado,0);

	}
	
	@Test
	public void teste_mes_com_1_venda_100_Reais() {
		
		double esperado = 20;
		int mes = 2;
		int ano = 2012;
		
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(1,1,mes,ano,100);
		vendas.add(venda);
		
		CalculadoraComissao mockCalculadora = mock(CalculadoraComissao.class);
		when(mockCalculadora.calcula(any(Double.class))).thenReturn(0.0);
		
		VendaRepository mockVendaRepo = mock(VendaRepository.class);
		when(mockVendaRepo.obterVendasPorMesEAno(any(Integer.class), any(Integer.class))).thenReturn(vendas);
		double resultado = new CalculadoraRoyalties(mockVendaRepo,mockCalculadora).calcular(mes,ano);

		
		Assert.assertEquals(esperado, resultado,0);

	}

}
