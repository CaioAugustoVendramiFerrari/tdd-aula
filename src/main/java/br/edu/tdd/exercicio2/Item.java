package br.edu.tdd.exercicio2;

/**
 * EXERCICIO 2 - Carrinho de Compras
 *
 * Esta classe ja vem pronta de proposito, para voces focarem o TDD
 * no CarrinhoDeCompras. E so um objeto simples com nome, preco e quantidade.
 */
public class Item {

    private final String nome;
    private final double preco;
    private final int quantidade;

    public Item(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }
}
