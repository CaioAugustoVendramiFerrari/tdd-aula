# Gabarito comentado — correção dos exercícios

> Uso sugerido: projete a tela, abra o exercício e **peça para a turma ditar o próximo teste** antes de mostrar o código. A correção rende muito mais como conversa do que como leitura.

---

## Exercício 1 — Calculadora de Frete

### Como a implementação evolui, ciclo a ciclo

**Depois da regra 1** (o mais simples que passa — mostre que isso é aceitável):

```java
public double calcular(double pesoEmKg) {
    return 10.0;
}
```

**Depois da regra 2** (o segundo teste derruba a constante):

```java
public double calcular(double pesoEmKg) {
    if (pesoEmKg <= 1) {
        return 10.0;
    }
    return 18.0;
}
```

**Depois da regra 3:**

```java
public double calcular(double pesoEmKg) {
    if (pesoEmKg <= 1) {
        return 10.0;
    }
    if (pesoEmKg <= 5) {
        return 18.0;
    }
    return 18.0 + (pesoEmKg - 5) * 2.50;
}
```

**Depois da regra 4 — e já refatorado:**

```java
package br.edu.tdd.exercicio1;

public class CalculadoraDeFrete {

    private static final double PESO_MINIMO_FAIXA_MEDIA = 1.0;
    private static final double PESO_MAXIMO_FAIXA_MEDIA = 5.0;
    private static final double FRETE_FAIXA_LEVE = 10.0;
    private static final double FRETE_FAIXA_MEDIA = 18.0;
    private static final double TAXA_POR_KG_EXCEDENTE = 2.50;

    public double calcular(double pesoEmKg) {
        validar(pesoEmKg);

        if (pesoEmKg <= PESO_MINIMO_FAIXA_MEDIA) {
            return FRETE_FAIXA_LEVE;
        }
        if (pesoEmKg <= PESO_MAXIMO_FAIXA_MEDIA) {
            return FRETE_FAIXA_MEDIA;
        }
        return FRETE_FAIXA_MEDIA + excedente(pesoEmKg);
    }

    private double excedente(double pesoEmKg) {
        return (pesoEmKg - PESO_MAXIMO_FAIXA_MEDIA) * TAXA_POR_KG_EXCEDENTE;
    }

    private void validar(double pesoEmKg) {
        if (pesoEmKg <= 0) {
            throw new IllegalArgumentException("Peso invalido");
        }
    }
}
```

### Testes completos

```java
package br.edu.tdd.exercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraDeFreteTest {

    private CalculadoraDeFrete calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraDeFrete();
    }

    @Test
    @DisplayName("Encomenda de ate 1 kg custa R$ 10,00")
    void encomendaDeAteUmKgCustaDezReais() {
        assertEquals(10.0, calculadora.calcular(1.0), 0.001);
    }

    @Test
    @DisplayName("Encomenda entre 1 kg e 5 kg custa R$ 18,00")
    void encomendaAteCincoKgCustaDezoitoReais() {
        assertEquals(18.0, calculadora.calcular(3.0), 0.001);
    }

    @Test
    @DisplayName("Acima de 5 kg cobra R$ 2,50 por kg excedente")
    void acimaDeCincoKgCobraPorKgExcedente() {
        assertEquals(23.0, calculadora.calcular(7.0), 0.001);
    }

    @Test
    @DisplayName("Peso zero ou negativo e rejeitado")
    void pesoInvalidoLancaExcecao() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(0));

        assertEquals("Peso invalido", erro.getMessage());
    }
}
```

### 🎯 Pontos para puxar na correção

- **Quem começou com `return 10.0` e se sentiu culpado?** Levante a mão. Isso é TDD correto, não preguiça. O código só generaliza quando um teste exige.
- **O `@BeforeEach` apareceu no refactor.** Repare: no começo cada teste criava a calculadora. A duplicação incomodou, extraímos. **Teste também se refatora.**
- **Faltou alguém testar 5 kg exatos?** É o limite entre as faixas. Se a pessoa escreveu `< 5` em vez de `<= 5`, nenhum teste pega. Vale acrescentar o caso ali na hora e ver o efeito.
- **Ninguém precisou usar o debugger.** Quando o ciclo é curto, o erro está sempre nas últimas 5 linhas que você escreveu.
