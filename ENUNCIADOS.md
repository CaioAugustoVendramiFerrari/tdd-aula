# Exercícios — Prática de TDD

## A única regra da atividade

> **Nenhuma linha de código de produção pode ser escrita antes de existir um teste falhando que a exija.**

Para cada regra, o ciclo é sempre:

| | |
|---|---|
| 🔴 **RED** | Escreva o teste. Rode. **Veja falhar.** Se passou de primeira, o teste está errado. |
| 🟢 **GREEN** | Escreva o **mínimo** para passar. Pode ser feio. Pode ser `return 10;`. |
| 🔵 **REFACTOR** | Limpe o código. Rode de novo. Continua verde? Ótimo. |

Só depois disso vá para a regra seguinte.

**Como rodar os testes:** `mvn test` no terminal, ou o botão ▶ ao lado da classe na sua IDE.

---

## Exercício 1 — Calculadora de Frete ⏱️ ~10 min

**Arquivos:** `exercicio1/CalculadoraDeFrete.java` e `CalculadoraDeFreteTest.java`
O primeiro teste já está escrito para servir de modelo. Os outros são com você.

Implemente `double calcular(double pesoEmKg)`:

| # | Regra | Exemplo |
|---|---|---|
| 1 | Até 1 kg (inclusive) → **R$ 10,00** | `calcular(1.0)` → `10.0` |
| 2 | Acima de 1 kg até 5 kg (inclusive) → **R$ 18,00** | `calcular(3.0)` → `18.0` |
| 3 | Acima de 5 kg → **R$ 18,00 + R$ 2,50 por kg acima de 5** | `calcular(7.0)` → `23.0` |
| 4 | Peso zero ou negativo → `IllegalArgumentException("Peso invalido")` | `calcular(0)` → 💥 |

⚠️ **Atenção:** ao comparar `double` no JUnit, use a margem de erro:
`assertEquals(23.0, frete, 0.001)`

---

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

## Exercício 3 — Conta Bancária ⏱️ desafio, se sobrar tempo

**Arquivos:** `exercicio3/ContaBancaria.java` e `ContaBancariaTest.java`
Aqui **não há nenhum teste pronto.** Você escreve todos.

| # | Regra |
|---|---|
| 1 | Conta nova começa com saldo 0,00 |
| 2 | `depositar(valor)` aumenta o saldo |
| 3 | `sacar(valor)` diminui o saldo |
| 4 | Sacar mais que o saldo → `IllegalStateException("Saldo insuficiente")` |
| 5 | Depositar ou sacar valor ≤ 0 → `IllegalArgumentException("Valor invalido")` |
| 6 | Cada operação **bem-sucedida** registra uma linha no extrato: `"DEPOSITO: 100.0"` / `"SAQUE: 50.0"`. Operações que falharam **não** entram no extrato, e o saldo não muda. |

---

## Checklist antes de entregar

- [ ] Todos os testes estão verdes (`mvn test`)
- [ ] Cada teste tem um nome que descreve a **regra**, não o método (`senhaCurtaEhInvalida`, não `testeUm`)
- [ ] Você viu cada teste falhar antes de implementar
- [ ] Você passou pelo menos uma vez pela etapa de refactor
