package br.edu.tdd.exercicio1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * EXERCICIO 1 - Calculadora de Frete
 *
 * COMECE POR AQUI.
 *
 * Faca UMA regra por vez, sempre nesta ordem:
 *   1. Escreva o teste          -> rode -> tem que FALHAR  (RED)
 *   2. Implemente o minimo      -> rode -> tem que PASSAR  (GREEN)
 *   3. Melhore o codigo         -> rode -> continua verde  (REFACTOR)
 *
 * Nao pule para a regra seguinte antes de ver o verde da regra atual.
 */
class CalculadoraDeFreteTest {

    // ---------------------------------------------------------------
    // REGRA 1: encomenda de ate 1 kg custa R$ 10,00
    // ---------------------------------------------------------------
    @Test
    @DisplayName("Encomenda de ate 1 kg custa R$ 10,00")
    void encomendaDeAteUmKgCustaDezReais() {
        CalculadoraDeFrete calculadora = new CalculadoraDeFrete();

        double frete = calculadora.calcular(1.0);

        assertEquals(10.0, frete, 0.001);
    }

    // ---------------------------------------------------------------
    // REGRA 2: acima de 1 kg e ate 5 kg custa R$ 18,00
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra e rode. Ele deve falhar primeiro.


    // ---------------------------------------------------------------
    // REGRA 3: acima de 5 kg custa R$ 18,00 + R$ 2,50 por kg acima de 5
    //          (ex: 7 kg  ->  18 + 2 * 2,50 = R$ 23,00)
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra


    // ---------------------------------------------------------------
    // REGRA 4: peso zero ou negativo lanca IllegalArgumentException
    //          com a mensagem "Peso invalido"
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra.
    //       Dica de como testar excecao com JUnit 5:
    //
    //       IllegalArgumentException erro = assertThrows(
    //               IllegalArgumentException.class,
    //               () -> calculadora.calcular(0));
    //       assertEquals("Peso invalido", erro.getMessage());
}
