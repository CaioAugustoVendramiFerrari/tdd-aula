# Exemplo ao vivo — Validador de Senha

> Este é o roteiro do **Parte 5: Exemplos**. A ideia é digitar o código na frente da turma, um ciclo por vez, projetando a tela. Cada ciclo tem um commit sugerido, então o histórico do Git conta a história do TDD.

**Tempo estimado:** 15 a 20 minutos.
**O que a turma precisa ver:** a barra vermelha aparecendo antes de cada implementação.

**Problema:** implementar uma classe que valida se uma senha é aceitável.

Regras (não mostre todas de uma vez — revele uma por ciclo):

1. Senha com menos de 8 caracteres é inválida
2. Senha com 8 ou mais caracteres é válida
3. Senha sem nenhum número é inválida
4. Senha sem letra maiúscula é inválida

---

## Ciclo 1 — Tamanho mínimo

### 🔴 RED — escreva só o teste

Crie `src/test/java/br/edu/tdd/exemplo/ValidadorDeSenhaTest.java`:

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

**Fale para a turma:** repare que a classe `ValidadorDeSenha` ainda não existe. O projeto nem compila. Isso **já é o vermelho** — o teste está dizendo o que falta construir.

### 🟢 GREEN — o mínimo para passar

Crie `src/main/java/br/edu/tdd/exemplo/ValidadorDeSenha.java`:

```java
package br.edu.tdd.exemplo;

public class ValidadorDeSenha {

    public boolean ehValida(String senha) {
        return false;
    }
}
```

**Fale para a turma:** sim, `return false` é trapaça. E está certo. No TDD isso tem nome: *fake it till you make it*. Escrevemos a coisa mais boba que faz o teste passar; é o **próximo teste** que vai nos obrigar a escrever o código de verdade. Isso garante que nenhuma linha de código exista sem um teste que a justifique.

> 💾 `git commit -m "ciclo 1: senha curta e invalida"`

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

(adicione `import static org.junit.jupiter.api.Assertions.assertTrue;`)

Rode: o teste novo falha. **O `return false` foi desmascarado pelo segundo teste.**

### 🟢 GREEN

```java
    public boolean ehValida(String senha) {
        return senha.length() >= 8;
    }
```

Rode: **os dois** testes passam.

**Fale para a turma:** essa técnica de escrever um segundo caso para forçar a generalização se chama **triangulação**. Um ponto não define uma reta; dois definem.

> 💾 `git commit -m "ciclo 2: valida tamanho minimo"`

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

> 💾 `git commit -m "ciclo 3: exige numero"`

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

> 💾 `git commit -m "ciclo 4: exige maiuscula"`

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

**Rode os testes de novo. Continuam verdes.**

**Fale para a turma — esta é a frase mais importante da aula:**

> Eu acabei de reescrever o método inteiro e mudei a forma de percorrer a String. Como eu sei que não quebrei nada? Porque os quatro testes continuam passando. **Sem os testes, essa refatoração seria um chute.** É isso que o TDD compra pra você.

Repare também que o método `ehValida` agora **se lê como a regra de negócio**, quase em português.

> 💾 `git commit -m "refactor: extrai metodos e remove flags"`

---

## Fechamento do exemplo (30 segundos)

Mostre o `git log`:

```
refactor: extrai metodos e remove flags
ciclo 4: exige maiuscula
ciclo 3: exige numero
ciclo 2: valida tamanho minimo
ciclo 1: senha curta e invalida
```

> O histórico do projeto virou a documentação de como a regra foi construída. E os testes são a especificação viva: qualquer pessoa que abrir `ValidadorDeSenhaTest` entende o que uma senha válida precisa ter, sem ler uma linha de implementação.

---

## Se sobrar tempo — demonstração do "teste que salva"

Vale muito fazer, é o momento em que a ficha cai:

1. Peça um voluntário para sugerir uma "otimização" no código.
2. Ou você mesmo introduza um bug de propósito: troque `>=` por `>` em `temTamanhoMinimo`.
3. Rode os testes. **Vermelho na hora**, apontando exatamente qual regra quebrou.
4. Desfaça. Verde de novo.
