# Aula de TDD — Test Driven Development

Repositório de apoio da aula sobre TDD (disciplina de Teste de Software).

Esta branch (`main`) tem só o **conteúdo** da aula. O exemplo e os exercícios ficam cada um na sua branch.

## Conteúdo

| Arquivo | Para quem |
|---|---|
| [`GUIA-DE-ESTUDO.md`](GUIA-DE-ESTUDO.md) | **Alunos** — TDD em 20 minutos de leitura |
| [`CHEATSHEET-JUNIT.md`](CHEATSHEET-JUNIT.md) | **Alunos** — colinha de JUnit 5 |
| [`ROTEIRO-DA-AULA.md`](ROTEIRO-DA-AULA.md) | Apresentadores — cronometragem e falas |

## Branches

| Branch | O que tem |
|---|---|
| `main` | Conteúdo da aula (você está aqui) |
| `exemplo` | Exemplo ao vivo do Validador de Senha — um commit por ciclo + `PASSO-A-PASSO-EXEMPLO.md` |
| `exercicio-1` | Calculadora de Frete — enunciado, resolução e gabarito |
| `exercicio-2` | Carrinho de Compras — enunciado, resolução e gabarito |
| `exercicio-3` | Conta Bancária (desafio) — enunciado, resolução e gabarito |

> ⚠️ **As branches `exercicio-*` já trazem a resolução.**
> Leia o `ENUNCIADO.md` e tente fazer **antes** de abrir o `GABARITO.md` e o código. Olhar a resposta antes tira justamente o que a aula quer treinar: escrever o teste primeiro e deixar ele guiar o código.

```bash
git checkout exercicio-1    # troca para o exercício 1
git checkout main           # volta para o conteúdo
```

### O exemplo, ciclo a ciclo

```
refactor: extrai metodos, remove flags e nomeia a constante
ciclo 4: exige maiuscula
ciclo 3: exige numero
ciclo 2: triangulacao derruba o return false
ciclo 1: senha curta e invalida (fake it com return false)
exemplo: ponto de partida          <- tag exemplo-inicio
```

```bash
git checkout exemplo-inicio   # ponto de partida em branco, para digitar ao vivo
git checkout exemplo          # exemplo completo
git log --oneline exemplo     # ver os ciclos
```

Se travar durante a apresentação, faça `git checkout` no commit do ciclo em que parou. Depois da aula, a branch também serve para os alunos revisarem.

## Pré-requisitos

- **Java 17 ou superior** — confira com `java -version`
- **Maven** — confira com `mvn -version`
  *(quem usa IntelliJ ou Eclipse já tem Maven embutido, não precisa instalar nada)*

## Como começar

```bash
git clone https://github.com/CaioAugustoVendramiFerrari/tdd-aula.git
cd tdd-aula
git checkout exercicio-1
mvn test
```

Na primeira vez o Maven baixa o JUnit — pode levar um minutinho.

### Abrindo na IDE

- **IntelliJ IDEA:** `File > Open` → selecione a pasta → ele detecta o `pom.xml` sozinho
- **VS Code:** instale a extensão *Extension Pack for Java* → abra a pasta
- **Eclipse:** `File > Import > Existing Maven Projects`

Ao trocar de branch, recarregue o projeto Maven na IDE (ícone 🔄 na aba Maven).

## Estrutura de uma branch de exercício

```
ENUNCIADO.md                      <- as regras do exercício
GABARITO.md                       <- correção comentada
pom.xml
src/main/java/br/edu/tdd/...      <- código de produção
src/test/java/br/edu/tdd/...      <- os testes
```

Por convenção do Maven, o teste de `CalculadoraDeFrete` fica em `CalculadoraDeFreteTest`, no **mesmo pacote**, mas dentro de `src/test`. É isso que permite ao teste enxergar a classe sem import.

## Problemas comuns

| Sintoma | Solução |
|---|---|
| `mvn: command not found` | Rode pela IDE (botão ▶) — ela tem Maven próprio |
| `no POM in this directory` | Você está na `main`, que só tem conteúdo. Faça `git checkout exercicio-1` |
| Testes não aparecem na IDE | Recarregue o projeto Maven (ícone 🔄 na aba Maven) |
| `package org.junit.jupiter does not exist` | Falta baixar as dependências: `mvn clean test` com internet |
| `invalid target release: 17` | Seu Java é mais antigo. Troque `17` por `11` no `pom.xml` |
