package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(9, 5);		
		Assertions.assertEquals(4, subtracao);		
	}
	
	@DisplayName("Testa a subtração com resultado negativo")
	@Test
	public void testSubtracaoDoisNumerosResultadoNegativo() {
		int subtracao = calc.subtracao(3, 5);		
		Assertions.assertEquals(-2, subtracao);		
	}
	
	@DisplayName("Testa a multiplicação com dois números inteiros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(3, 5);		
		Assertions.assertEquals(15, multiplicacao);		
	}
	
	@DisplayName("Testa a o somatório de números até 0")
	@Test
	public void testSomatoriaCincoNumeros() {
		int somatorio = calc.somatoria(6);		
		Assertions.assertEquals(21, somatorio);		
	}
	
	@DisplayName("Testa se o número informado é positivo")
	@Test
	public void testPositivoFalso() {
		boolean postivo = calc.ehPositivo(-2);		
		Assertions.assertEquals(false, postivo);		
	}
	@DisplayName("Testa se o número informado é positivo")
	@Test
	public void testPositivo() {
		boolean postivo = calc.ehPositivo(2);		
		Assertions.assertEquals(true, postivo);		
	}
	
	@DisplayName("Testa se os números são iguais")
	@Test
	public void testComparacaoDoisNumeros() {
		int igual = calc.compara(2, 2);		
		Assertions.assertEquals(0, igual);		
	}
	
	@DisplayName("Testa se o numero é primeiro número é maior")
	@Test
	public void testComparaDoisNumeros() {
		int maior = calc.compara(3, 2);		
		Assertions.assertEquals(1, maior);		
	}
	
	@DisplayName("Testa se o numero é primeiro número é menor")
	@Test
	public void testComparandoDoisNumeros() {
		int menor = calc.compara(1, 2);		
		Assertions.assertEquals(-1, menor);		
	}
}
