# Guia do NetBeans — do download ao teste verde

Tudo pela interface, sem terminal e sem configurar biblioteca na mão.

> **Qual NetBeans?** *Apache NetBeans* 17 ou mais novo. Ele já vem com Maven embutido e roda JUnit 5.
> **Qual Java?** 17 ou superior. Veja em `Tools > Java Platforms`.

---

## 1. Baixar o projeto

Cada branch do repositório vira um projeto separado. Baixe o ZIP da branch que você precisa:

| Projeto | Link direto do ZIP |
|---|---|
| Exemplo — ponto de partida em branco | [exemplo-inicio.zip](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/tags/exemplo-inicio.zip) |
| Exemplo — completo | [exemplo.zip](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exemplo.zip) |
| Exercício 1 — Calculadora de Frete | [exercicio-1.zip](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-1.zip) |
| Exercício 2 — Carrinho de Compras | [exercicio-2.zip](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-2.zip) |
| Exercício 3 — Conta Bancária | [exercicio-3.zip](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/heads/exercicio-3.zip) |

Descompacte o ZIP (botão direito → *Extrair tudo*).

*(Sem o link na mão: no GitHub, escolha a branch no botão de branches e clique em `Code > Download ZIP`.)*

## 2. Abrir no NetBeans

O NetBeans abre projeto Maven direto — **não tem importação**.

1. `File > Open Project...` (**Ctrl+Shift+O**)
2. Navegue até a pasta descompactada. A pasta que tem o `pom.xml` aparece com o **ícone de projeto Maven**
3. Selecione essa pasta → **Open Project**
4. Na primeira vez, clique com o botão direito no projeto → **Clean and Build** (**Shift+F11**) e espere terminar. É o Maven baixando o JUnit e os plugins — precisa de internet e demora um pouco só na primeira vez

**Como saber se deu certo:** na aba *Projects*, o projeto aparece com o nome `Aula de TDD - Exercicio 1` (ou do exemplo) e com os nós **Source Packages**, **Test Packages** e **Test Dependencies** — dentro deste último, os `junit-jupiter`. Na aba *Output* aparece `BUILD SUCCESS`.

## 3. Criar a classe de teste

1. Em **Test Packages**, botão direito no pacote (por exemplo `br.edu.tdd.exemplo`) → `New > Java Class...`
2. **Class Name:** o nome da classe + `Test`, por exemplo `ValidadorDeSenhaTest`
3. **Finish** e escreva o teste

Use `Java Class` e não o assistente *JUnit Test*: ele pode alterar o `pom.xml` e acrescentar dependências que o projeto já tem.

## 4. Deixar o teste criar a classe de produção (Alt+Enter)

Este é o jeito mais TDD de usar o NetBeans: escreva o teste usando uma classe que **ainda não existe**.

1. O nome da classe fica sublinhado de vermelho, com uma lâmpada na margem — **isso é o RED**
2. Clique no nome sublinhado e aperte **Alt+Enter** → escolha `Create class "ValidadorDeSenha" in package br.edu.tdd.exemplo` **(Source Packages)**
3. ⚠️ Confira que é a opção **Source Packages**, e não *Test Packages*. Se só aparecer a de *Test Packages*, crie à mão: em **Source Packages**, botão direito no pacote → `New > Java Class...`
4. Volte ao teste, clique no método sublinhado (`ehValida`) → **Alt+Enter** → `Create method "ehValida(java.lang.String)"`
5. O NetBeans cria o método com `throw new UnsupportedOperationException("Not supported yet.");` — **troque essa linha** pelo retorno mais simples possível (`return false;`, `return 0;`), que é o *fake it* do TDD

## 5. Rodar os testes

| O que | Como |
|---|---|
| Rodar uma classe de teste | Botão direito no arquivo de teste → **Test File** (**Ctrl+F6**) |
| Rodar um método só | Botão direito dentro do método → **Run Focused Test Method** |
| Rodar todos os testes do projeto | Botão direito no projeto → **Test** (**Alt+F6**) |
| Rodar de novo | Botão **Rerun** na janela *Test Results* |

A janela **Test Results** abre sozinha e mostra a barra: **verde** passou tudo, **vermelha** algo falhou, com a porcentagem de testes que passaram. Clique no teste que falhou para ver a mensagem — dê duplo clique para ir direto à linha.

*(Janela sumiu? `Window > IDE Tools > Test Results`.)*

## 6. Atalhos que valem ouro na aula

| Atalho | O que faz |
|---|---|
| **Alt+Enter** | Dicas e correções: cria classe, método, variável, import |
| **Ctrl+Space** | Autocompletar |
| **Ctrl+Shift+I** | Corrige os imports |
| **Alt+Shift+F** | Formata o código |
| **Ctrl+S** | Salva |
| **Ctrl+F6** | Roda os testes do arquivo aberto |

**Fonte grande para projetar:** `Tools > Options > Fonts & Colors` → botão `...` ao lado de *Font* → aumente o tamanho.

### `assertEquals` não é reconhecido (`cannot find symbol`)?

Os asserts são *imports estáticos*. Coloque no topo da classe de teste:

```java
import static org.junit.jupiter.api.Assertions.*;
```

---

## Problemas comuns

| Sintoma | Solução |
|---|---|
| Projeto com ícone de alerta / `package org.junit.jupiter.api does not exist` | Botão direito no projeto → **Clean and Build** com internet. Se aparecer *Resolve Project Problems...*, use essa opção. Sem internet: **Plano B** abaixo |
| `Could not resolve dependencies` / `Plugin ... could not be resolved` na aba Output | O Maven não conseguiu baixar da internet. Confira a rede e rode **Clean and Build** de novo, ou use o **Plano B** |
| A pasta não aparece como projeto no *Open Project* | Você está na pasta de fora. Entre na pasta que contém o `pom.xml` |
| `invalid target release: 17` / `release version 17 not supported` | O NetBeans está usando um Java mais antigo. Em **Project Files**, abra o `pom.xml`, troque os dois `17` por `11`, salve e rode **Clean and Build** |
| `No tests executed` | A classe de teste precisa estar em **Test Packages** e o nome precisa terminar em `Test` |
| A classe de produção apareceu em **Test Packages** | Funciona, mas está no lugar errado. Arraste para o mesmo pacote em **Source Packages** e confirme o *Move* |
| O método criado pelo Alt+Enter lança `UnsupportedOperationException` | É o padrão do NetBeans. Troque o `throw` por um `return` |
💡 **Prevenção:** abra o projeto e rode **Test** numa máquina do laboratório **antes da aula**. Se funcionar, o JUnit fica guardado nessa máquina.
