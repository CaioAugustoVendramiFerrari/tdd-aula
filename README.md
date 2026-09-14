# Aula de TDD — Test Driven Development

Repositório de apoio da aula sobre TDD (disciplina de Teste de Software).

Esta branch (`main`) tem só o **conteúdo** da aula. O exemplo e os exercícios ficam cada um na sua branch.

## Conteúdo

| Arquivo | Para quem |
|---|---|
| [`GUIA-ECLIPSE.md`](GUIA-ECLIPSE.md) | **Todos** — baixar, importar, criar e rodar testes no Eclipse |
| [`GUIA-DE-ESTUDO.md`](GUIA-DE-ESTUDO.md) | **Alunos** — TDD em 20 minutos de leitura |
| [`CHEATSHEET-JUNIT.md`](CHEATSHEET-JUNIT.md) | **Alunos** — colinha de JUnit 5 |
| [`ROTEIRO-DA-AULA.md`](ROTEIRO-DA-AULA.md) | Apresentadores — cronometragem e falas |

## Branches

| Branch | O que tem | Baixar |
|---|---|---|
| `main` | Conteúdo da aula (você está aqui) | — |
| `exemplo` | Exemplo ao vivo do Validador de Senha — um commit por ciclo + `PASSO-A-PASSO-EXEMPLO.md` | [início em branco](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/tags/exemplo-inicio.zip) · [completo](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exemplo.zip) |
| `exercicio-1` | Calculadora de Frete — enunciado, resolução e gabarito | [ZIP](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-1.zip) |
| `exercicio-2` | Carrinho de Compras — enunciado, resolução e gabarito | [ZIP](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-2.zip) |
| `exercicio-3` | Conta Bancária (desafio) — enunciado, resolução e gabarito | [ZIP](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-3.zip) |

> ⚠️ **As branches `exercicio-*` já trazem a resolução.**
> Leia o `ENUNCIADO.md` e tente fazer **antes** de abrir o `GABARITO.md` e o código. Olhar a resposta antes tira justamente o que a aula quer treinar: escrever o teste primeiro e deixar ele guiar o código.

## Como começar (Eclipse)

1. Baixe o ZIP da branch na tabela acima e descompacte
2. No Eclipse: `File > Import... > Maven > Existing Maven Projects` → escolha a pasta → **Finish**
3. Espere o Maven baixar o JUnit (canto inferior direito — só na primeira vez)
4. Botão direito na classe de teste → `Run As > JUnit Test`

Cada branch vira um projeto próprio no Eclipse (`tdd-exemplo`, `tdd-exercicio-1`...), então dá para ter todos abertos no mesmo workspace.

O passo a passo completo, com os caminhos de menu, atalhos e o **plano B sem internet**, está no [`GUIA-ECLIPSE.md`](GUIA-ECLIPSE.md).

## Pré-requisitos

- **Eclipse IDE for Java Developers** 2021-09 ou mais novo — já vem com Maven e JUnit 5, não precisa instalar biblioteca
- **Java 17 ou superior** — confira em `Window > Preferences > Java > Installed JREs`
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

Se travar durante a apresentação, abra o commit do ciclo em que parou e copie o código de lá. Depois da aula, a branch também serve para os alunos revisarem.

## Estrutura de uma branch de exercício

```
ENUNCIADO.md                      <- as regras do exercício
GABARITO.md                       <- correção comentada
pom.xml
src/main/java/br/edu/tdd/...      <- código de produção
src/test/java/br/edu/tdd/...      <- os testes
```

Por convenção do Maven, o teste de `CalculadoraDeFrete` fica em `CalculadoraDeFreteTest`, no **mesmo pacote**, mas dentro de `src/test/java`. É isso que permite ao teste enxergar a classe sem import.

## Quem prefere git

```bash
git clone https://github.com/CaioAugustoVendramiFerrari/tdd-aula.git
cd tdd-aula
git checkout exercicio-1      # ou exemplo, exemplo-inicio, exercicio-2...
```

Depois importe a pasta no Eclipse como `Existing Maven Projects`. Ao trocar de branch, rode `Maven > Update Project` (**Alt+F5**).

## Problemas comuns

Os problemas do Eclipse e as soluções estão no final do [`GUIA-ECLIPSE.md`](GUIA-ECLIPSE.md#problemas-comuns).
