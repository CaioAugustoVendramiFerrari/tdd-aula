# Exercício 1 — Prática de TDD

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
