# Colinha de JUnit 5

Tudo que você precisa para os exercícios. Nada além disso.

## Esqueleto de uma classe de teste

```java
package br.edu.tdd.exercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeFreteTest {

    @Test
    void encomendaLeveCustaDezReais() {
        // 1. ARRANGE — prepara o cenário
        CalculadoraDeFrete calculadora = new CalculadoraDeFrete();

        // 2. ACT — executa a ação
        double frete = calculadora.calcular(1.0);

        // 3. ASSERT — verifica o resultado
        assertEquals(10.0, frete, 0.001);
    }
}
```

Esse padrão de três blocos chama-se **AAA** (Arrange, Act, Assert). Seguir ele deixa qualquer teste legível.

## Anotações

| Anotação | Para que serve |
|---|---|
| `@Test` | Marca o método como um teste. Sem isso ele não roda. |
| `@DisplayName("...")` | Nome bonito no relatório. Pode ter acento e espaço. |
| `@BeforeEach` | Roda antes de **cada** teste. Bom para criar o objeto do zero. |
| `@Disabled("motivo")` | Desliga um teste temporariamente. |

## Verificações (assertions)

| Método | Uso |
|---|---|
| `assertEquals(esperado, real)` | Compara valores. **O esperado vem primeiro.** |
| `assertEquals(esperado, real, 0.001)` | Para `double` — a margem é obrigatória na prática |
| `assertTrue(condicao)` / `assertFalse(condicao)` | Para booleanos |
| `assertNull(obj)` / `assertNotNull(obj)` | Nulidade |
| `assertThrows(Tipo.class, () -> ...)` | Verifica que uma exceção foi lançada |

### Testando exceção

```java
@Test
void pesoNegativoLancaExcecao() {
    CalculadoraDeFrete calculadora = new CalculadoraDeFrete();

    IllegalArgumentException erro = assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.calcular(-1)
    );

    assertEquals("Peso invalido", erro.getMessage());
}
```

O `() -> ...` é uma lambda: significa "esse trecho de código, para o JUnit executar e observar".

## ⚠️ As três pegadinhas que mais aparecem

**1. `double` não se compara com igualdade exata**
`assertEquals(0.3, 0.1 + 0.2)` **falha** — em ponto flutuante isso dá `0.30000000000000004`.
Sempre passe a margem: `assertEquals(0.3, 0.1 + 0.2, 0.001)`.

**2. A ordem dos argumentos é (esperado, real)**
Inverter não quebra o teste, mas a mensagem de erro sai invertida e te faz perder 10 minutos.

**3. A classe e os métodos de teste não precisam ser `public`**
No JUnit 5, *package-private* (sem modificador) é o padrão.

**4. `assertEquals` sublinhado de vermelho? Falta o import estático**
Confira se a linha `import static org.junit.jupiter.api.Assertions.*;` está no topo. Sem ela, o NetBeans acusa `cannot find symbol`.

## Rodando no NetBeans

| O que | Como |
|---|---|
| Rodar a classe de teste | Botão direito no arquivo de teste → **Test File** (**Ctrl+F6**) |
| Rodar um teste só | Botão direito dentro do método → **Run Focused Test Method** |
| Rodar todos os testes | Botão direito no projeto → **Test** (**Alt+F6**) |
| Rodar de novo | Botão **Rerun** na janela *Test Results* |
| Criar a classe que o teste pede | Clique no nome sublinhado → **Alt+Enter** → `Create class ... (Source Packages)` |
| Criar o método que o teste pede | Clique no método sublinhado → **Alt+Enter** → `Create method` — e troque o `throw new UnsupportedOperationException` por um `return` |

Barra **vermelha** na janela *Test Results*: falhou. Barra **verde**: passou. Mais detalhes no `GUIA-NETBEANS.md`.
