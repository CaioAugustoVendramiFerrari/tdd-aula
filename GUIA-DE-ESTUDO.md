# Guia de estudo rápido — TDD em 20 minutos

> Um resumo do que vale saber sobre TDD: a ideia central, o ciclo, as confusões mais comuns e as perguntas que sempre aparecem.

---

## 1. A ideia central, em uma frase

**O teste não é uma conferência depois do fato. É a especificação, escrita antes, numa linguagem que o computador consegue verificar.**

Se você entender só isso, já entendeu TDD. Todo o resto é consequência.

A inversão é essa:

| Desenvolvimento tradicional | TDD |
|---|---|
| Penso na solução → escrevo o código → testo se funcionou | Descrevo o comportamento esperado → vejo falhar → escrevo o código |
| O teste responde "funcionou?" | O teste responde "o que é 'funcionar'?" |
| Teste é verificação | Teste é **especificação** |

---

## 2. O ciclo, além do Red / Green / Refactor

O básico é Red → Green → Refactor. O que costuma faltar e vale saber:

### O tamanho do ciclo

Um ciclo completo deveria durar **de 30 segundos a poucos minutos**. Se você ficou 20 minutos no vermelho, o passo era grande demais — volte e divida. Isso é a regra prática mais útil de todas.

### As duas estratégias do Green

Quando o teste está vermelho, você tem duas saídas legítimas:

- **Fake it** — devolva a constante que faz passar (`return 10.0;`). Parece trapaça, é técnica. Você adia a generalização até um teste exigir.
- **Obvious implementation** — quando a solução é óbvia e você tem certeza, escreva ela direto.

A dica do Kent Beck: use *obvious implementation* enquanto estiver confiante; no minuto em que um teste ficar vermelho por surpresa, volte para *fake it* e passos menores.

### Triangulação

Você usa o segundo teste para **forçar** a generalização. Um caso permite uma constante; dois casos obrigam a fórmula. É por isso que o `return false` do exemplo cai no ciclo 2 — foi planejado.

### Por que o Refactor é inegociável

Sem ele, o TDD vira só "escrever teste antes" e o código acumula gambiarra de *fake it*. O refactor é onde o design emerge. E ele só é seguro por causa dos testes — é uma coisa que só existe por causa da outra.

**Regra de ouro do refactor: nunca refatore no vermelho.** Se um teste está falhando, primeiro faça passar, depois limpe.

---

## 3. As quatro coisas que quase sempre confundem

### TDD ≠ teste unitário

Teste unitário é *o que* você escreve. TDD é *quando* e *por quê*. Você pode ter milhares de testes unitários e nenhum TDD (se foram escritos depois). O inverso não existe.

### "Escrever testes antes" ≠ "escrever todos os testes antes"

Não é escrever a suíte inteira e depois implementar tudo. É **um teste por vez**. Essa é a confusão mais comum.

### TDD não garante que o software está correto

Garante que ele faz o que **você especificou**. Se você entendeu a regra errado, o TDD vai te entregar um bug bem testado. Ele reduz defeitos de implementação, não erros de requisito.

### Cobertura não é o objetivo

100% de cobertura é possível com testes que não verificam nada (basta executar o código sem nenhum assert). O que importa é cobrir **comportamento** e **casos de borda**.

---

## 4. Vocabulário

| Termo | O que é |
|---|---|
| **Assert** | A verificação em si — a linha que decide se o teste passa ou falha |
| **AAA** | Arrange, Act, Assert — os três blocos de um teste bem escrito |
| **Caso de borda** | O valor no limite da regra (exatamente 200,00, exatamente 5 kg). É onde moram os bugs |
| **Regressão** | Bug que reaparece em algo que já funcionava. A suíte de testes existe para pegar isso |
| **Suíte** | O conjunto de todos os testes do projeto |
| **Mock / stub** | Objeto falso que substitui uma dependência lenta ou imprevisível (banco, API) |
| **Baby steps** | Passos deliberadamente pequenos |
| **Documentação viva** | Os testes descrevem o comportamento e, diferente de um .doc, **não podem ficar desatualizados** — se mentirem, ficam vermelhos |

---

## 5. Perguntas que sempre aparecem

**"Isso não é overengineering?"**
Pode ser, em protótipo descartável ou script de uso único. Reconheça. Em código que vai ser mantido por mais de algumas semanas, o custo se paga.

**"E se o requisito mudar? Aí tenho que mexer no teste e no código."**
Sim, e isso é o comportamento correto. O teste falhar quando a regra muda é o sistema funcionando. O que você não quer é o teste **continuar passando** depois de uma mudança de regra — isso significa que ele nunca testou a regra.

**"Testes não dão trabalho de manter?"**
Dão. É um custo real, e uma das desvantagens do TDD. O argumento é de balanço: você troca manutenção de testes por horas de debug e bugs em produção.

**"Por que você testou 5 kg exatos se já testou 3 e 7?"**
Porque `< 5` e `<= 5` produzem resultados diferentes exatamente ali, e em nenhum outro ponto. Esse é o conceito de teste de valor limite.

---

## 6. Teste seu entendimento — responda sem olhar

1. Por que o teste **precisa** falhar antes de você implementar?
2. O que é "fake it" e por que não é trapaça?
3. Qual é a diferença entre TDD e teste unitário?
4. Cite duas situações em que TDD **não** compensa.
5. Por que a etapa de refactor é segura?

*(Respostas: 1 — para provar que o teste realmente verifica algo; um teste que nunca falhou pode estar quebrado. 2 — devolver uma constante para passar rápido, deixando a generalização para o próximo teste. 3 — teste unitário é o artefato, TDD é o processo. 4 — protótipo descartável, script de uso único, UI muito complexa, exploração onde o requisito ainda não está claro. 5 — porque a suíte verde avisa na hora se o comportamento mudou.)*

---

## Referências para citar

- Kent Beck, *Test-Driven Development: By Example* (2002) — a fonte original
- Robert C. Martin, *Clean Code*, capítulo sobre testes limpos
- Documentação do JUnit 5: junit.org/junit5
