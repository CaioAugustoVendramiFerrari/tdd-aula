# Gabarito comentado — correção dos exercícios

> Uso sugerido: projete a tela, abra o exercício e **peça para a turma ditar o próximo teste** antes de mostrar o código. A correção rende muito mais como conversa do que como leitura.

---

## Exercício 2 — Carrinho de Compras

### Solução

```java
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
```

### Testes das regras 3 a 6

```java
    @Test
    @DisplayName("Total e a soma de preco vezes quantidade")
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
```

### 🎯 Pontos para puxar na correção

- **A regra 5 é a estrela da aula.** Pergunte: *quem escreveu `>=` no primeiro impulso?* O teste de borda pegou. Sem TDD, esse bug iria para produção e só apareceria com um cliente reclamando de um desconto indevido.
- **`getTotalComDesconto` chama `getTotal`.** Um método reaproveitando o outro só é seguro porque `getTotal` já tem teste próprio.
- **`temDireitoADesconto` é um método privado que ninguém testa diretamente** — e está tudo bem. Testamos o comportamento público, não a estrutura interna. Se testássemos cada método privado, não poderíamos mais refatorar.
- **Aparece aqui o conceito de *test double*?** Não, e vale dizer isso: nesses exercícios não precisamos de mock porque não há dependência externa (banco, API). Mock entra quando existe uma dependência lenta ou imprevisível.
