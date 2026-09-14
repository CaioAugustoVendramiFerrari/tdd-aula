# Exercício 3 — Prática de TDD

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
