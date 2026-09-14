package br.edu.tdd.exercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * EXERCICIO 2 - Carrinho de Compras
 *
 * Mesma regra do exercicio 1: um teste por vez, sempre vendo o vermelho antes
 * do verde.
 */
class CarrinhoDeComprasTest {

    private CarrinhoDeCompras carrinho;

    // @BeforeEach roda antes de CADA teste, deixando o cenario sempre limpo.
    @BeforeEach
    void criarCarrinhoVazio() {
        carrinho = new CarrinhoDeCompras();
    }

    // ---------------------------------------------------------------
    // REGRA 1: carrinho novo tem total zero e nenhum item
    // ---------------------------------------------------------------
    @Test
    @DisplayName("Carrinho novo comeca vazio e com total zero")
    void carrinhoNovoComecaVazio() {
        assertEquals(0, carrinho.quantidadeDeItens());
        assertEquals(0.0, carrinho.getTotal(), 0.001);
    }

    // ---------------------------------------------------------------
    // REGRA 2: ao adicionar um item, a quantidade de itens aumenta
    // ---------------------------------------------------------------
    @Test
    @DisplayName("Adicionar um item aumenta a quantidade de itens")
    void adicionarUmItemAumentaQuantidade() {
        carrinho.adicionar(new Item("Caneta", 5.0, 1));

        assertEquals(1, carrinho.quantidadeDeItens());
    }

    // ---------------------------------------------------------------
    // REGRA 3: o total e a soma de preco * quantidade de cada item
    //          (ex: 2 canetas de 5,00 + 1 caderno de 30,00 = 40,00)
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra


    // ---------------------------------------------------------------
    // REGRA 4: compras acima de R$ 200,00 ganham 10% de desconto
    //          getTotalComDesconto() deve devolver o total ja com o desconto
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra


    // ---------------------------------------------------------------
    // REGRA 5: compras de exatamente R$ 200,00 NAO ganham desconto
    //          (teste de borda - muito importante!)
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra


    // ---------------------------------------------------------------
    // REGRA 6: adicionar item com preco negativo lanca
    //          IllegalArgumentException com a mensagem "Preco invalido"
    // ---------------------------------------------------------------
    // TODO: escreva o teste desta regra
}
