package br.edu.tdd.exercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoDeComprasTest {

    private CarrinhoDeCompras carrinho;

    @BeforeEach
    void criarCarrinhoVazio() {
        carrinho = new CarrinhoDeCompras();
    }

    @Test
    @DisplayName("Carrinho novo comeca vazio e com total zero")
    void carrinhoNovoComecaVazio() {
        assertEquals(0, carrinho.quantidadeDeItens());
        assertEquals(0.0, carrinho.getTotal(), 0.001);
    }

    @Test
    @DisplayName("Adicionar um item aumenta a quantidade de itens")
    void adicionarUmItemAumentaQuantidade() {
        carrinho.adicionar(new Item("Caneta", 5.0, 1));

        assertEquals(1, carrinho.quantidadeDeItens());
    }

    @Test
    @DisplayName("Total e a soma de preco vezes quantidade de cada item")
    void totalSomaSubtotaisDosItens() {
        carrinho.adicionar(new Item("Caneta", 5.0, 2));
        carrinho.adicionar(new Item("Caderno", 30.0, 1));

        assertEquals(40.0, carrinho.getTotal(), 0.001);
    }

    @Test
    @DisplayName("Compra acima de R$ 200 ganha 10% de desconto")
    void compraAcimaDeDuzentosGanhaDesconto() {
        carrinho.adicionar(new Item("Teclado", 250.0, 1));

        assertEquals(225.0, carrinho.getTotalComDesconto(), 0.001);
    }

    @Test
    @DisplayName("Compra de exatamente R$ 200 nao ganha desconto")
    void compraDeExatamenteDuzentosNaoGanhaDesconto() {
        carrinho.adicionar(new Item("Monitor", 200.0, 1));

        assertEquals(200.0, carrinho.getTotalComDesconto(), 0.001);
    }

    @Test
    @DisplayName("Item com preco negativo e rejeitado")
    void itemComPrecoNegativoLancaExcecao() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> carrinho.adicionar(new Item("Invalido", -1.0, 1)));

        assertEquals("Preco invalido", erro.getMessage());
    }
}
