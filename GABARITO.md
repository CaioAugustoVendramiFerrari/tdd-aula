# Gabarito comentado

## Exercício 3 — Conta Bancária (desafio)

### Solução

```java
package br.edu.tdd.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

    private double saldo = 0;
    private final List<String> extrato = new ArrayList<>();

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato() {
        return List.copyOf(extrato);
    }

    public void depositar(double valor) {
        validar(valor);
        saldo += valor;
        registrar("DEPOSITO", valor);
    }

    public void sacar(double valor) {
        validar(valor);
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= valor;
        registrar("SAQUE", valor);
    }

    private void validar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    private void registrar(String operacao, double valor) {
        extrato.add(operacao + ": " + valor);
    }
}
```

### Um teste que merece destaque

```java
    @Test
    @DisplayName("Saque negado nao altera o saldo nem o extrato")
    void saqueNegadoNaoAlteraEstado() {
        conta.depositar(100.0);

        assertThrows(IllegalStateException.class, () -> conta.sacar(500.0));

        assertEquals(100.0, conta.getSaldo(), 0.001);
        assertEquals(1, conta.getExtrato().size());
    }
```

### 🎯 Pontos de atenção

- **A ordem das validações importa.** Se você checar saldo antes de checar valor negativo, `sacar(-50)` passa direto (−50 não é maior que o saldo) e **aumenta** o saldo. Um teste pega isso; leitura de código, quase nunca.
- **`List.copyOf` no getter** aparece porque devolver a lista interna deixaria qualquer um adulterar o extrato. Esse é um refactor guiado por uma **pergunta**, não por um teste — e mostra que TDD não substitui pensar em design.
- **`IllegalStateException` vs `IllegalArgumentException`:** o argumento (100,00) é válido; o que está errado é o **estado** da conta. Escolher a exceção certa é uma decisão de design que o teste te obriga a tomar cedo.

---

## Para refletir

1. **Você precisou usar o debugger?** Provavelmente não. Com ciclos curtos, o erro está sempre no que você acabou de escrever.
2. **Mudou de ideia sobre alguma regra depois de escrever o teste?** É comum. O teste força a especificar antes de codar — é aí que a ambiguidade aparece.
3. **Teria coragem de trocar o `ArrayList` por outra estrutura agora?** Sim, porque é só apertar **Ctrl+F6** e olhar a barra. **Isso** é o produto final do TDD.
