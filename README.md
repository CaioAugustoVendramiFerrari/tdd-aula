# Aula de TDD — Test Driven Development

Repositório de apoio da aula sobre TDD (disciplina de Teste de Software).

## O que tem aqui

| Arquivo | Para quem |
|---|---|
| [`ENUNCIADOS.md`](ENUNCIADOS.md) | **Alunos** — os exercícios da prática |
| [`CHEATSHEET-JUNIT.md`](CHEATSHEET-JUNIT.md) | **Alunos** — colinha de JUnit 5 |
| [`PASSO-A-PASSO-EXEMPLO.md`](PASSO-A-PASSO-EXEMPLO.md) | Apresentadores — roteiro do exemplo ao vivo |
| [`ROTEIRO-DA-AULA.md`](ROTEIRO-DA-AULA.md) | Apresentadores — cronometragem e falas |
| `GABARITO.md` | Apresentadores — correção comentada (fica nas branches `gabarito-exercicio-*`) |

## Pré-requisitos

- **Java 17 ou superior** — confira com `java -version`
- **Maven** — confira com `mvn -version`
  *(quem usa IntelliJ ou Eclipse já tem Maven embutido, não precisa instalar nada)*

## Como começar

```bash
git clone <URL-DO-REPOSITORIO>
cd tdd-aula
mvn test
```

Na primeira vez o Maven baixa o JUnit — pode levar um minutinho.

**O resultado esperado logo de cara é VERMELHO.** Os testes de exemplo falham de propósito: é o ponto de partida do TDD. Se der tudo verde, tem algo errado.

### Abrindo na IDE

- **IntelliJ IDEA:** `File > Open` → selecione a pasta → ele detecta o `pom.xml` sozinho
- **VS Code:** instale a extensão *Extension Pack for Java* → abra a pasta
- **Eclipse:** `File > Import > Existing Maven Projects`

## Estrutura

```
src/main/java/br/edu/tdd/     <- código de produção
   exemplo/                      (preenchido ao vivo na aula)
   exercicio1/  CalculadoraDeFrete
   exercicio2/  CarrinhoDeCompras, Item
   exercicio3/  ContaBancaria  (desafio)

src/test/java/br/edu/tdd/     <- os testes (é POR AQUI que se começa)
```

Por convenção do Maven, o teste de `CalculadoraDeFrete` fica em `CalculadoraDeFreteTest`, no **mesmo pacote**, mas dentro de `src/test`. É isso que permite ao teste enxergar a classe sem import.

## Branches

| Branch | Conteúdo |
|---|---|
| `main` | Exercícios em branco — é aqui que os alunos trabalham |
| `exemplo-passo-a-passo` | Um commit por ciclo do exemplo da aula (rede de segurança do apresentador) |
| `gabarito-exercicio-1` | Solução comentada do Exercício 1 — Calculadora de Frete |
| `gabarito-exercicio-2` | Solução comentada do Exercício 2 — Carrinho de Compras |
| `gabarito-exercicio-3` | Solução comentada do Exercício 3 — Conta Bancária + encerramento |

> ⚠️ **Não abra as branches `gabarito-exercicio-*` antes da correção.**
> Elas estão aqui para você revisar **depois** de tentar. Olhar a resposta antes tira justamente o que a aula quer treinar: escrever o teste primeiro e deixar ele guiar o código.

```bash
git checkout gabarito-exercicio-1    # só depois da correção do exercício 1
git checkout main                    # voltar
```

A branch `exemplo-passo-a-passo` tem o histórico do exemplo construído ao vivo, um commit por etapa:

```
refactor: extrai metodos, remove flags e nomeia a constante
ciclo 4: exige maiuscula
ciclo 3: exige numero
ciclo 2: triangulacao derruba o return false
ciclo 1: senha curta e invalida (fake it com return false)
```

Se travar durante a apresentação, `git checkout exemplo-passo-a-passo` e caminhe pelos commits. Depois da aula, ela também serve para os alunos revisarem.

## Problemas comuns

| Sintoma | Solução |
|---|---|
| `mvn: command not found` | Rode pela IDE (botão ▶) — ela tem Maven próprio |
| Testes não aparecem na IDE | Recarregue o projeto Maven (ícone 🔄 na aba Maven) |
| `package org.junit.jupiter does not exist` | Falta baixar as dependências: `mvn clean test` com internet |
| `invalid target release: 17` | Seu Java é mais antigo. Troque `17` por `11` no `pom.xml` |
