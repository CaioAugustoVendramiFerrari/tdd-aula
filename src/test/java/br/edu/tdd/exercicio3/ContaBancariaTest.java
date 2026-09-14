package br.edu.tdd.exercicio3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * EXERCICIO 3 (DESAFIO) - Conta Bancaria
 *
 * Este arquivo esta vazio de proposito.
 * Escreva voce mesmo cada teste, na ordem das regras do ENUNCIADOS.md,
 * sempre vendo o teste falhar antes de implementar.
 */
class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void criarConta() {
        conta = new ContaBancaria();
    }

    // TODO: REGRA 1 - conta nova comeca com saldo zero


    // TODO: REGRA 2 - depositar aumenta o saldo


    // TODO: REGRA 3 - sacar diminui o saldo


    // TODO: REGRA 4 - sacar mais do que o saldo lanca IllegalStateException
    //                 com a mensagem "Saldo insuficiente"


    // TODO: REGRA 5 - depositar ou sacar valor zero ou negativo lanca
    //                 IllegalArgumentException com a mensagem "Valor invalido"


    // TODO: REGRA 6 - cada operacao bem sucedida registra uma linha no extrato
    //                 no formato "DEPOSITO: 100.0" / "SAQUE: 50.0"
    //                 (operacoes que deram erro NAO entram no extrato)
}
