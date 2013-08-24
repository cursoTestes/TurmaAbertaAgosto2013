package br.scrumban;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void test_venda_de_100_reais_retornar_5_reais() {
		/** arrange **/
		double valorVenda = 100;
		double comissaoEsperada = 5;
		
		/** act **/
		double retorno = new CalculadoraComissao().calcula(valorVenda);
		
		/** assert **/
		assertEquals(comissaoEsperada, retorno , 0);
	}
	
	@Test
	public void test_venda_de_10000_reais_retornar_500_reais() {
		/** arrange **/
		double valorVenda = 10000;
		double comissaoEsperada = 500;
		
		/** act **/
		double retorno = new CalculadoraComissao().calcula(valorVenda);
		
		/** assert **/
		assertEquals(comissaoEsperada, retorno , 0 );
	}
	
	@Test
	public void test_venda_de_1000_reais_retornar_50_reais() {
		/** arrange **/
		double valorVenda = 1000;
		double comissaoEsperada = 50;
		
		/** act **/
		double retorno = new CalculadoraComissao().calcula(valorVenda);
		
		/** assert **/
		assertEquals(comissaoEsperada, retorno, 0 );
	}

	@Test
	public void test_venda_de_1_real_retorna_5_centavos() {
		/** arrange **/
		double valorVenda = 1;
		double comissaoEsperada = 0.05;
		
		/** act **/
		double retorno = new CalculadoraComissao().calcula(valorVenda);
		
		/** assert **/
		assertEquals(comissaoEsperada, retorno, 0);
	}
	@Test
	public void test_venda_de_100000_reais_retornar_6000_reais() {
		/** arrange **/
		double valorVenda = 100000;
		double comissaoEsperada = 6000;
		
		/** act **/
		double retorno = new CalculadoraComissao().calcula(valorVenda);
		
		/** assert **/
		assertEquals(comissaoEsperada, retorno, 0);
	}
	@Test
	public void test_venda_de_55_reais_59_centavos_retornar_2_reais_77_centavos() {
		/** arrange **/
		double valorVenda = 55.59;
		double comissaoEsperada = 2.77;
		
		/** act **/
		double retorno = new CalculadoraComissao().calcula(valorVenda);
		
		/** assert **/
		assertEquals(comissaoEsperada, retorno, 0);
	}
}