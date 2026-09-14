package br.edu.tdd.exercicio3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void criarConta() {
        conta = new ContaBancaria();
    }

    @Test
    @DisplayName("Conta nova comeca com saldo zero")
    void contaNovaComecaComSaldoZero() {
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    @DisplayName("Deposito aumenta o saldo")
    void depositoAumentaSaldo() {
        conta.depositar(100.0);

        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    @DisplayName("Saque diminui o saldo")
    void saqueDiminuiSaldo() {
        conta.depositar(100.0);

        conta.sacar(30.0);

        assertEquals(70.0, conta.getSaldo(), 0.001);
    }

    @Test
    @DisplayName("Saque maior que o saldo e recusado")
    void saqueMaiorQueSaldoLancaExcecao() {
        conta.depositar(100.0);

        IllegalStateException erro = assertThrows(
                IllegalStateException.class,
                () -> conta.sacar(500.0));

        assertEquals("Saldo insuficiente", erro.getMessage());
    }

    @Test
    @DisplayName("Deposito de valor nao positivo e recusado")
    void depositoDeValorInvalidoLancaExcecao() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(-5.0));

        assertEquals("Valor invalido", erro.getMessage());
    }

    @Test
    @DisplayName("Saque de valor nao positivo e recusado")
    void saqueDeValorInvalidoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(0.0));
    }

    @Test
    @DisplayName("Operacoes bem sucedidas sao registradas no extrato")
    void operacoesSaoRegistradasNoExtrato() {
        conta.depositar(100.0);
        conta.sacar(30.0);

        assertEquals(2, conta.getExtrato().size());
        assertEquals("DEPOSITO: 100.0", conta.getExtrato().get(0));
        assertEquals("SAQUE: 30.0", conta.getExtrato().get(1));
    }

    @Test
    @DisplayName("Saque negado nao altera o saldo nem o extrato")
    void saqueNegadoNaoAlteraEstado() {
        conta.depositar(100.0);

        assertThrows(IllegalStateException.class, () -> conta.sacar(500.0));

        assertEquals(100.0, conta.getSaldo(), 0.001);
        assertEquals(1, conta.getExtrato().size());
    }

    @Test
    @DisplayName("Extrato devolvido nao pode ser alterado por fora")
    void extratoEhImutavel() {
        conta.depositar(100.0);

        assertThrows(UnsupportedOperationException.class,
                () -> conta.getExtrato().add("FRAUDE: 999.0"));
    }
}
