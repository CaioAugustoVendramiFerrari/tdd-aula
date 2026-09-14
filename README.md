# Aula de TDD — Test Driven Development

Repositório de apoio da aula sobre TDD (disciplina de Teste de Software).

Esta branch (`main`) tem só o **conteúdo** da aula. O exemplo e os exercícios ficam cada um na sua branch.

## Conteúdo

| Arquivo | Para quem |
|---|---|
| [`GUIA-NETBEANS.md`](GUIA-NETBEANS.md) | **Todos** — baixar, abrir, criar e rodar testes no NetBeans |
| [`GUIA-DE-ESTUDO.md`](GUIA-DE-ESTUDO.md) | **Alunos** — TDD em 20 minutos de leitura |
| [`CHEATSHEET-JUNIT.md`](CHEATSHEET-JUNIT.md) | **Alunos** — colinha de JUnit 5 |

## Branches

| Branch | O que tem | Baixar |
|---|---|---|
| `main` | Conteúdo da aula (você está aqui) | — |
| `exemplo` | Exemplo do Validador de Senha — um commit por ciclo + `PASSO-A-PASSO-EXEMPLO.md` | [início em branco](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/tags/exemplo-inicio.zip) · [completo](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exemplo.zip) |
| `exercicio-1` | Calculadora de Frete — enunciado, resolução e gabarito | [ZIP](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-1.zip) |
| `exercicio-2` | Carrinho de Compras — enunciado, resolução e gabarito | [ZIP](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-2.zip) |
| `exercicio-3` | Conta Bancária (desafio) — enunciado, resolução e gabarito | [ZIP](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-3.zip) |

> ⚠️ **As branches `exercicio-*` já trazem a resolução.**
> Leia o `ENUNCIADO.md` e tente fazer **antes** de abrir o `GABARITO.md` e o código. Olhar a resposta antes tira justamente o que a aula quer treinar: escrever o teste primeiro e deixar ele guiar o código.

## Como começar (NetBeans)

1. Baixe o ZIP da branch na tabela acima e descompacte
2. No NetBeans: `File > Open Project...` → selecione a pasta que tem o `pom.xml` → **Open Project**
3. Botão direito no projeto → **Clean and Build** e espere o Maven baixar o JUnit (só na primeira vez, precisa de internet)
4. Botão direito na classe de teste → **Test File** (**Ctrl+F6**)

Cada branch vira um projeto próprio no NetBeans (`Aula de TDD - Exemplo`, `Aula de TDD - Exercicio 1`...), então dá para ter todos abertos ao mesmo tempo.

O passo a passo completo, com os caminhos de menu, atalhos e o **plano B sem internet**, está no [`GUIA-NETBEANS.md`](GUIA-NETBEANS.md).

## Pré-requisitos

- **Apache NetBeans** 17 ou mais novo — já vem com Maven e roda JUnit 5, não precisa instalar biblioteca
- **Java 17 ou superior** — confira em `Tools > Java Platforms`
- **Internet na primeira importação**, para o Maven baixar o JUnit

## O exemplo, ciclo a ciclo

A branch `exemplo` tem um commit por etapa. Veja no GitHub em [commits da branch `exemplo`](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/commits/exemplo):

```
refactor: extrai metodos, remove flags e nomeia a constante
ciclo 4: exige maiuscula
ciclo 3: exige numero
ciclo 2: triangulacao derruba o return false
ciclo 1: senha curta e invalida (fake it com return false)
exemplo: ponto de partida          <- tag exemplo-inicio
```

Abra qualquer commit para ver o código exatamente como estava naquele ciclo.

## Estrutura de uma branch de exercício

```
ENUNCIADO.md                      <- as regras do exercício
GABARITO.md                       <- correção comentada
pom.xml
src/main/java/br/edu/tdd/...      <- código de produção
src/test/java/br/edu/tdd/...      <- os testes
```

Por convenção do Maven, o teste de `CalculadoraDeFrete` fica em `CalculadoraDeFreteTest`, no **mesmo pacote**, mas dentro de `src/test/java` — no NetBeans, `src/main/java` aparece como **Source Packages** e `src/test/java` como **Test Packages**. É isso que permite ao teste enxergar a classe sem import.

## Quem prefere git

```bash
git clone https://github.com/CaioAugustoVendramiFerrari/tdd-aula.git
cd tdd-aula
git checkout exercicio-1      # ou exemplo, exemplo-inicio, exercicio-2...
```

Depois abra a pasta no NetBeans com `File > Open Project...`. Ao trocar de branch, rode **Clean and Build**.

## Problemas comuns

Os problemas do NetBeans e as soluções estão no final do [`GUIA-NETBEANS.md`](GUIA-NETBEANS.md#problemas-comuns).
