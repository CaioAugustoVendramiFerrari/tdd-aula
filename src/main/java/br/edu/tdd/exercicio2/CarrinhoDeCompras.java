package br.edu.tdd.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private static final double VALOR_MINIMO_PARA_DESCONTO = 200.0;
    private static final double PERCENTUAL_DE_DESCONTO = 0.10;

    private final List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        if (item.getPreco() < 0) {
            throw new IllegalArgumentException("Preco invalido");
        }
        itens.add(item);
    }

    public int quantidadeDeItens() {
        return itens.size();
    }

    public double getTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public double getTotalComDesconto() {
        double total = getTotal();
        if (temDireitoADesconto(total)) {
            return total * (1 - PERCENTUAL_DE_DESCONTO);
        }
        return total;
    }

    private boolean temDireitoADesconto(double total) {
        return total > VALOR_MINIMO_PARA_DESCONTO;
    }
}
