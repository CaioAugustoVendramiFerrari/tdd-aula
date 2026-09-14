# Exemplo passo a passo — Validador de Senha

O objetivo é construir, com TDD, uma classe que valida senhas. As regras são implementadas **uma por ciclo**:

1. Senha com menos de 8 caracteres é inválida
2. Senha com 8 ou mais caracteres é válida
3. Senha sem nenhum número é inválida
4. Senha sem letra maiúscula é inválida

---

## Antes de começar — preparar o NetBeans

1. Baixe o [ponto de partida em branco](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/archive/refs/tags/exemplo-inicio.zip) e descompacte
2. `File > Open Project...` → selecione a pasta que tem o `pom.xml` → **Open Project**
3. Botão direito no projeto `Aula de TDD - Exemplo` → **Clean and Build** → espere o `BUILD SUCCESS` (baixa o JUnit na primeira vez)

Detalhes e problemas comuns no `GUIA-NETBEANS.md` da branch `main`.

---

## Ciclo 1 — Tamanho mínimo

### 🔴 RED — escreva só o teste

No NetBeans: em **Test Packages**, botão direito no pacote `br.edu.tdd.exemplo` → `New > Java Class...` → **Class Name:** `ValidadorDeSenhaTest` → **Finish**.

Apague o que o NetBeans gerou e digite:

```java
package br.edu.tdd.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidadorDeSenhaTest {

    @Test
    void senhaComMenosDeOitoCaracteresEhInvalida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertFalse(validador.ehValida("Abc123"));
    }
}
```


### 🟢 GREEN — o mínimo para passar

Deixe o próprio teste criar a classe:

1. Clique em `ValidadorDeSenha` (sublinhado) → **Alt+Enter** → `Create class "ValidadorDeSenha" in package br.edu.tdd.exemplo` **(Source Packages)**
2. ⚠️ Confira que é a opção **Source Packages**, não *Test Packages*. Se só aparecer *Test Packages*: em **Source Packages**, botão direito no pacote → `New > Java Class...`
3. Volte ao teste, clique em `ehValida` (sublinhado) → **Alt+Enter** → `Create method "ehValida(java.lang.String)"`
4. O NetBeans cria o método com `throw new UnsupportedOperationException("Not supported yet.");` — troque por `return false;` e renomeie o parâmetro para `senha`
5. **Ctrl+S** nos dois arquivos

Fica assim:

```java
package br.edu.tdd.exemplo;

public class ValidadorDeSenha {

    public boolean ehValida(String senha) {
        return false;
    }
}
```

Rode: botão direito no arquivo de teste → **Test File** (**Ctrl+F6**). **Barra verde** na janela *Test Results*.


---

## Ciclo 2 — Senha longa é válida (aqui o `return false` cai)

### 🔴 RED

```java
    @Test
    void senhaComOitoOuMaisCaracteresEhValida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertTrue(validador.ehValida("Abcd1234"));
    }
```

(adicione `import static org.junit.jupiter.api.Assertions.assertTrue;` no topo — sem ele o NetBeans acusa `cannot find symbol`)

Rode: o teste novo falha. **O `return false` foi desmascarado pelo segundo teste.**

### 🟢 GREEN

```java
    public boolean ehValida(String senha) {
        return senha.length() >= 8;
    }
```

Rode: **os dois** testes passam.

---

## Ciclo 3 — Precisa ter número

### 🔴 RED

```java
    @Test
    void senhaSemNumeroEhInvalida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertFalse(validador.ehValida("Abcdefgh"));
    }
```

Falha: hoje `"Abcdefgh"` tem 8 caracteres, então passa pela validação atual.

### 🟢 GREEN

```java
    public boolean ehValida(String senha) {
        if (senha.length() < 8) {
            return false;
        }
        boolean temNumero = false;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                temNumero = true;
            }
        }
        return temNumero;
    }
```

---

## Ciclo 4 — Precisa ter letra maiúscula

### 🔴 RED

```java
    @Test
    void senhaSemLetraMaiusculaEhInvalida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertFalse(validador.ehValida("abcd1234"));
    }
```

### 🟢 GREEN

```java
    public boolean ehValida(String senha) {
        if (senha.length() < 8) {
            return false;
        }
        boolean temNumero = false;
        boolean temMaiuscula = false;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                temNumero = true;
            }
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }
        }
        return temNumero && temMaiuscula;
    }
```

Quatro testes verdes. **Mas olhe para esse método.** Ele está feio: faz três coisas ao mesmo tempo, tem flags soltas, e para entender a regra você precisa ler o laço inteiro.

---

## 🔵 REFACTOR — a etapa que todo mundo pula

Agora, **sem escrever nenhum teste novo**, melhore o código:

```java
package br.edu.tdd.exemplo;

public class ValidadorDeSenha {

    private static final int TAMANHO_MINIMO = 8;

    public boolean ehValida(String senha) {
        return temTamanhoMinimo(senha)
                && temNumero(senha)
                && temLetraMaiuscula(senha);
    }

    private boolean temTamanhoMinimo(String senha) {
        return senha.length() >= TAMANHO_MINIMO;
    }

    private boolean temNumero(String senha) {
        return senha.chars().anyMatch(Character::isDigit);
    }

    private boolean temLetraMaiuscula(String senha) {
        return senha.chars().anyMatch(Character::isUpperCase);
    }
}
```

**Rode os testes de novo** (botão **Rerun** na janela *Test Results*). **Continuam verdes.**

**Por que isso importa:** o método inteiro foi reescrito e a forma de percorrer a String mudou. Como saber que nada quebrou? Os quatro testes continuam passando. **Sem os testes, essa refatoração seria um chute.** É isso que o TDD garante.

Repare também que o método `ehValida` agora **se lê como a regra de negócio**, quase em português.

---

## O histórico conta a história

No [histórico de commits da branch `exemplo`](https://github.com/CaioAugustoVendramiFerrari/tdd-aula/commits/exemplo), cada ciclo virou um commit — dá para abrir qualquer um e ver o código exatamente como estava naquela etapa:

```
refactor: extrai metodos, remove flags e nomeia a constante
ciclo 4: exige maiuscula
ciclo 3: exige numero
ciclo 2: triangulacao derruba o return false
ciclo 1: senha curta e invalida (fake it com return false)
```

O histórico do projeto virou a documentação de como a regra foi construída. E os testes são a especificação viva: qualquer pessoa que abrir `ValidadorDeSenhaTest` entende o que uma senha válida precisa ter, sem ler uma linha de implementação.

---

## Experimente — o teste que salva

1. Introduza um bug de propósito: troque `>=` por `>` em `temTamanhoMinimo`.
2. **Ctrl+S** e rode os testes. **Barra vermelha na hora** — clique no teste que falhou na janela *Test Results*: ele aponta exatamente qual regra quebrou.
3. Desfaça. Verde de novo.
