# Guia do Eclipse — do download ao teste verde

Tudo pela interface, sem terminal e sem configurar biblioteca na mão.

> **Qual Eclipse?** *Eclipse IDE for Java Developers* (ou *Enterprise Java*), versão 2021-09 ou mais nova. Ele já vem com Maven e JUnit 5.
> **Qual Java?** 17 ou superior. Veja em `Window > Preferences > Java > Installed JREs`.

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

## 2. Importar no Eclipse

1. `File > Import...`
2. `Maven > Existing Maven Projects` → **Next**
3. **Root Directory:** `Browse...` → escolha a pasta descompactada
4. Confirme que o `pom.xml` aparece marcado → **Finish**
5. Espere a barra de progresso no canto inferior direito terminar — é o Maven baixando o JUnit (precisa de internet, só na primeira vez)

**Como saber se deu certo:** no *Package Explorer*, o projeto aparece com as pastas `src/main/java` e `src/test/java` e um item **Maven Dependencies** contendo `junit-jupiter`.

⚠️ Use **Existing Maven Projects**, e não *Existing Projects into Workspace*. Pelo caminho errado o Eclipse não reconhece o JUnit.

## 3. Criar a classe de teste

1. Botão direito em `src/test/java` → `New > JUnit Test Case`
   *(se não aparecer no menu: `New > Other... > Java > JUnit > JUnit Test Case`)*
2. Marque **New JUnit Jupiter test**
3. **Package:** o pacote do exercício, por exemplo `br.edu.tdd.exemplo`
4. **Name:** o nome da classe + `Test`, por exemplo `ValidadorDeSenhaTest`
5. **Finish**

O Eclipse gera um método `test()` com `fail("Not yet implemented")` — apague e escreva o seu teste.

## 4. Deixar o teste criar a classe de produção (Ctrl+1)

Este é o jeito mais TDD de usar o Eclipse: escreva o teste usando uma classe que **ainda não existe**.

1. O nome da classe fica sublinhado de vermelho — **isso é o RED**
2. Clique no nome sublinhado e aperte **Ctrl+1** → `Create class 'ValidadorDeSenha'`
3. ⚠️ Na janela que abre, troque **Source folder** para `.../src/main/java` — o Eclipse sugere `src/test/java`, que é o lugar errado
4. **Finish**
5. Volte ao teste, clique no método sublinhado (`ehValida`) → **Ctrl+1** → `Create method 'ehValida(String)'`

O Eclipse cria o método já com um `return` padrão (`false`, `0`, `null`) — exatamente o *fake it* do TDD.

## 5. Rodar os testes

| O que | Como |
|---|---|
| Rodar uma classe de teste | Botão direito na classe → `Run As > JUnit Test` |
| Mesmo atalho pelo teclado | **Alt+Shift+X**, solte, depois **T** |
| Rodar um método só | Clique no nome do método e use o mesmo atalho |
| Rodar todos os testes do projeto | Botão direito no projeto → `Run As > JUnit Test` |
| Rodar de novo | Botão **Rerun Test** (▶ verde) na aba JUnit |

A aba **JUnit** mostra a barra: **verde** passou tudo, **vermelha** algo falhou. Clique no teste que falhou e veja o *Failure Trace* — dê duplo clique na linha para ir direto ao código.

*(Aba sumiu? `Window > Show View > Other... > Java > JUnit`.)*

## 6. Atalhos que valem ouro na aula

| Atalho | O que faz |
|---|---|
| **Ctrl+1** | Quick fix: cria classe, método, variável, import |
| **Ctrl+Space** | Autocompletar |
| **Ctrl+Shift+O** | Organiza os imports |
| **Ctrl+Shift+F** | Formata o código |
| **Ctrl+S** | Salva (o Eclipse só compila o que foi salvo) |
| **Ctrl+=** / **Ctrl+-** | Aumenta / diminui a fonte — use ao projetar |

### `assertEquals` não é reconhecido?

Os asserts são *imports estáticos*, e o Eclipse não os sugere sozinho. Duas saídas:

- **Rápida:** coloque no topo da classe de teste
  `import static org.junit.jupiter.api.Assertions.*;`
- **Definitiva:** `Window > Preferences > Java > Editor > Content Assist > Favorites > New Type...` → digite `org.junit.jupiter.api.Assertions` → **OK**. A partir daí o Ctrl+Space e o Ctrl+1 encontram `assertEquals`, `assertTrue` etc.

---

## Problemas comuns

| Sintoma | Solução |
|---|---|
| `The import org.junit cannot be resolved` / sem **Maven Dependencies** | Botão direito no projeto → `Maven > Update Project...` (**Alt+F5**) → marque *Force Update of Snapshots/Releases* → OK. Precisa de internet. Sem internet: **Plano B** abaixo |
| Projeto sem `src/main/java` e `src/test/java` | Foi importado pelo caminho errado. Apague do workspace (sem apagar do disco) e importe de novo por `Existing Maven Projects` |
| `No tests found with test runner 'JUnit 4'` | `Run > Run Configurations...` → selecione a configuração → **Test runner: JUnit 5** → Run |
| `Errors exist in required project... Proceed with launch?` | Há erro de compilação. No TDD, se é a classe que ainda não existe, é o vermelho esperado: clique **Cancel** e use o **Ctrl+1** |
| Aviso sobre `JavaSE-17` | O Eclipse não tem Java 17. Abra o `pom.xml`, troque os dois `17` por `11`, salve e rode `Maven > Update Project` |
| `Project ... already exists` | Esse projeto já está no workspace. Use o que já está lá, ou apague-o do workspace antes |
| A classe de produção apareceu dentro de `src/test/java` | Funciona, mas está no lugar errado. Arraste para o mesmo pacote dentro de `src/main/java` |

## Plano B — sem internet no laboratório

Se o Maven não conseguir baixar o JUnit, dá para rodar sem Maven usando o JUnit 5 que já vem no Eclipse:

1. `File > New > Java Project`
2. Dê um nome, **desmarque** *Create module-info.java file* → **Finish**
3. No Windows Explorer, abra a pasta descompactada e copie a pasta `br` de dentro de `src/main/java` **e** de `src/test/java` para a pasta `src` do projeto novo (aceite mesclar as pastas)
4. No Eclipse, botão direito no projeto → **Refresh** (F5)
5. Botão direito no projeto → `Build Path > Add Libraries...` → **JUnit** → **JUnit 5** → **Finish**
6. Rode normalmente com `Run As > JUnit Test`

💡 **Prevenção:** importe o projeto uma vez numa máquina do laboratório **antes da aula**. Se funcionar, o JUnit fica guardado nessa máquina e não precisa baixar de novo.
