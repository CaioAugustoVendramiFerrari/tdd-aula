package br.edu.tdd.exercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraDeFreteTest {

    private CalculadoraDeFrete calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraDeFrete();
    }

    @Test
    @DisplayName("Encomenda de ate 1 kg custa R$ 10,00")
    void encomendaDeAteUmKgCustaDezReais() {
        assertEquals(10.0, calculadora.calcular(1.0), 0.001);
    }

    @Test
    @DisplayName("Encomenda entre 1 kg e 5 kg custa R$ 18,00")
    void encomendaAteCincoKgCustaDezoitoReais() {
        assertEquals(18.0, calculadora.calcular(3.0), 0.001);
    }

    @Test
    @DisplayName("Peso de exatamente 5 kg ainda esta na faixa media")
    void pesoDeExatamenteCincoKgEstaNaFaixaMedia() {
        assertEquals(18.0, calculadora.calcular(5.0), 0.001);
    }

    @Test
    @DisplayName("Acima de 5 kg cobra R$ 2,50 por kg excedente")
    void acimaDeCincoKgCobraPorKgExcedente() {
        assertEquals(23.0, calculadora.calcular(7.0), 0.001);
    }

    @Test
    @DisplayName("Peso zero e rejeitado")
    void pesoZeroLancaExcecao() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(0));

        assertEquals("Peso invalido", erro.getMessage());
    }

    @Test
    @DisplayName("Peso negativo e rejeitado")
    void pesoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(-2.0));
    }
}
