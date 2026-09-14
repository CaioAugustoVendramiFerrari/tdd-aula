# Aula de TDD — Test Driven Development

Repositório de apoio da aula sobre TDD (disciplina de Teste de Software).

## O que tem aqui

| Arquivo | Para quem |
|---|---|
| [`ENUNCIADOS.md`](ENUNCIADOS.md) | **Alunos** — os exercícios da prática |
| [`CHEATSHEET-JUNIT.md`](CHEATSHEET-JUNIT.md) | **Alunos** — colinha de JUnit 5 |
| [`PASSO-A-PASSO-EXEMPLO.md`](PASSO-A-PASSO-EXEMPLO.md) | Apresentadores — roteiro do exemplo ao vivo |
| [`ROTEIRO-DA-AULA.md`](ROTEIRO-DA-AULA.md) | Apresentadores — cronometragem e falas |
| [`GABARITO.md`](GABARITO.md) | Apresentadores — correção comentada |

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
| `gabarito` | Exemplo e exercícios resolvidos — usado na correção |

```bash
git checkout gabarito    # ver as soluções
git checkout main        # voltar
```

## Problemas comuns

| Sintoma | Solução |
|---|---|
| `mvn: command not found` | Rode pela IDE (botão ▶) — ela tem Maven próprio |
| Testes não aparecem na IDE | Recarregue o projeto Maven (ícone 🔄 na aba Maven) |
| `package org.junit.jupiter does not exist` | Falta baixar as dependências: `mvn clean test` com internet |
| `invalid target release: 17` | Seu Java é mais antigo. Troque `17` por `11` no `pom.xml` |
