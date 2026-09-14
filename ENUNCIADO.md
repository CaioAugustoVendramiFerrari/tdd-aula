# Exercício 2 — Prática de TDD

## Exercício 2 — Carrinho de Compras ⏱️ ~15 min

**Arquivos:** `exercicio2/CarrinhoDeCompras.java` e `CarrinhoDeComprasTest.java`
A classe `Item` já vem pronta — você não precisa mexer nela.

| # | Regra | Exemplo |
|---|---|---|
| 1 | Carrinho novo: 0 itens e total 0,00 | ✅ teste já escrito |
| 2 | Adicionar item aumenta a quantidade de itens | ✅ teste já escrito |
| 3 | Total = soma de `preço × quantidade` de cada item | 2 canetas de 5,00 + 1 caderno de 30,00 → **40,00** |
| 4 | Compra **acima** de R$ 200,00 tem 10% de desconto | total 250,00 → **225,00** |
| 5 | Compra de **exatamente** R$ 200,00 **não** tem desconto | total 200,00 → **200,00** |
| 6 | Item com preço negativo → `IllegalArgumentException("Preco invalido")` | 💥 |

💡 A regra 5 é o **teste de borda**. É nesse tipo de caso que mora a maioria dos bugs reais (`>` vs `>=`). Repare que escrever o teste te obriga a decidir a regra antes de codar.

---

## A única regra da atividade

> **Nenhuma linha de código de produção pode ser escrita antes de existir um teste falhando que a exija.**

Para cada regra, o ciclo é sempre:

| | |
|---|---|
| 🔴 **RED** | Escreva o teste. Rode. **Veja falhar.** Se passou de primeira, o teste está errado. |
| 🟢 **GREEN** | Escreva o **mínimo** para passar. Pode ser feio. Pode ser `return 10;`. |
| 🔵 **REFACTOR** | Limpe o código. Rode de novo. Continua verde? Ótimo. |

Só depois disso vá para a regra seguinte.

**Como rodar os testes no NetBeans:** botão direito no arquivo de teste → **Test File** (**Ctrl+F6**). Barra vermelha na janela *Test Results* = falhou; verde = passou.

**Classe ou método ainda não existe?** Clique no nome sublinhado de vermelho e aperte **Alt+Enter** → `Create class` (escolha a opção **Source Packages**) / `Create method`. O método criado vem com `throw new UnsupportedOperationException(...)` — troque por um `return` simples.

---

## Checklist antes de entregar

- [ ] Todos os testes estão verdes (botão direito no projeto → **Test**)
- [ ] Cada teste tem um nome que descreve a **regra**, não o método (`senhaCurtaEhInvalida`, não `testeUm`)
- [ ] Você viu cada teste falhar antes de implementar
- [ ] Você passou pelo menos uma vez pela etapa de refactor
