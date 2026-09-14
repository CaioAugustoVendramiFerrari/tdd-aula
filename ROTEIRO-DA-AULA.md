# Roteiro da aula — TDD

> Cronometragem para **60 minutos**. Se o slot for de 50, corte o Exercício 3 (já está marcado como desafio) e reduza a prática para 20 min.

## Antes de começar (faça hoje, antes da aula)

- [ ] **Numa máquina do laboratório**, baixar o `exemplo.zip`, abrir no NetBeans (`File > Open Project`), rodar **Clean and Build** e depois **Test** — tem que dar `BUILD SUCCESS` e barra verde. É o teste de que a rede da faculdade deixa o Maven baixar. Se não deixar, prepare o **Plano B** do `GUIA-NETBEANS.md` (pendrive com a pasta `.m2`)
- [ ] Conferir se o NetBeans do laboratório tem Java 17 (`Tools > Java Platforms`)
- [ ] Ensaiar o **Alt+Enter** → `Create class ... (Source Packages)` no NetBeans do laboratório, para confirmar o nome exato da opção
- [ ] Subir o repositório no GitHub e deixar o link curto pronto para projetar
- [ ] Mandar para a turma os links dos ZIPs (tabela do `README.md`) e pedir para **baixar e importar antes da aula** — nada mata mais tempo do que 30 pessoas baixando o JUnit ao mesmo tempo no wi-fi da faculdade
- [ ] Deixar o NetBeans aberto com fonte grande (`Tools > Options > Fonts & Colors`) e a janela **Test Results** visível (`Window > IDE Tools > Test Results`)
- [ ] Ter um plano B: se a internet cair, você ainda consegue fazer o exemplo ao vivo, porque suas dependências já estarão baixadas

---

## Cronograma

| Tempo | Bloco | Slides | O que fazer |
|---|---|---|---|
| 0–3 min | Abertura | 1–2 | Apresentar o time e os tópicos |
| 3–8 min | Introdução | 3–5 | Definição e objetivo |
| 8–16 min | O ciclo | 6–10 | Red, Green, Refactor + o diagrama |
| 16–22 min | Quando usar | 11–13 | Vantagens |
| 22–27 min | Quando não usar | 14–16 | Desvantagens — dá credibilidade, não pule |
| **27–45 min** | **Exemplo ao vivo** | 17 | branch `exemplo` → `PASSO-A-PASSO-EXEMPLO.md` |
| **45–75 min** | **Prática** | 18 | branches `exercicio-*` → `ENUNCIADO.md` |
| **75–85 min** | **Correção** | — | branches `exercicio-*` → `GABARITO.md` |
| 85–90 min | Fechamento | — | Recado final |

*(Se o slot for de 60 min: teoria em 20, exemplo em 15, prática em 18, correção em 7.)*

---

## Falas-chave por bloco

### Abertura — quebre o gelo com a pergunta certa

> "Quem aqui já escreveu um teste automatizado?"
> *(poucas mãos)*
> "E quem já quebrou alguma coisa mexendo em código que funcionava?"
> *(todas as mãos)*
> "É exatamente sobre isso que a gente vai falar."

### No bloco do ciclo (slides 7–10)

Enquanto explica o Red, **antecipe a objeção que sempre vem**:

> "Escrever teste antes parece perda de tempo. A gente também achava. Só que repare: o teste não é burocracia, é a especificação executável do que você vai construir. Você está escrevendo o requisito numa linguagem que o computador consegue conferir."

No Green, a frase que gruda:

> "Aqui vale trapacear. Sério. Escreva `return 10` se isso fizer o teste passar. O próximo teste é que vai te obrigar a escrever o código de verdade."

No Refactor:

> "Essa é a etapa que 90% das pessoas pula — e é a que dá o retorno. Sem ela, TDD vira só 'escrever teste antes'."

### No bloco de desvantagens (slide 15–16)

Não venda TDD como bala de prata; o professor vai gostar disso:

> "TDD não é obrigatório e não serve para tudo. Em protótipo descartável, em código muito acoplado a UI, ou quando você ainda não sabe qual é o problema, ele atrapalha mais do que ajuda."

### Transição para a prática

> "Agora vocês. Só uma regra: **nenhuma linha de implementação antes de um teste vermelho.** Se der vontade de adiantar, segura."

---

## Durante a prática — como circular pela sala

Os três travamentos previsíveis e a resposta de cada um:

| Travamento | O que dizer |
|---|---|
| "Meu teste passou de primeira" | "Então ele não está testando nada novo. Ou a regra já estava implementada, ou o assert está errado. Quebre o código de propósito e veja se ele acusa." |
| "Não sei o que testar primeiro" | "O caso mais simples que você conseguir imaginar. Se for boba demais, melhor ainda." |
| "Posso implementar as 4 regras de uma vez?" | "Pode, mas aí não é TDD e você perde o ponto da aula. Faz uma, roda, faz a próxima." |
| Erro de compilação no teste | Lembre que **isso é o vermelho**. A classe não existir já é feedback válido. Mostre o **Alt+Enter** → `Create class`. |
| `assertEquals` sublinhado de vermelho | Falta `import static org.junit.jupiter.api.Assertions.*;` no topo da classe. |
| Classe criada pelo Alt+Enter foi parar em **Test Packages** | Funciona, mas está no lugar errado: arrastar para **Source Packages**. Na próxima, escolher a opção *(Source Packages)*. |
| Método novo lança `UnsupportedOperationException` | É o padrão do NetBeans: trocar o `throw` por um `return` simples. |
| Projeto sem o JUnit (`package org.junit.jupiter.api does not exist`) | Botão direito no projeto → **Clean and Build** com internet. Sem internet: Plano B do `GUIA-NETBEANS.md`. |

⚠️ **Combine entre vocês quem apresenta e quem circula pela sala.** Enquanto uma pessoa está no slide/código, a outra atende dúvidas individuais. Prática sem ninguém circulando trava.

---

## Fechamento (2 min)

Abra no GitHub o histórico de commits da branch `exemplo` (um commit por ciclo) e diga:

> "O que a gente entregou hoje não foi só o código que funciona. Foi o código que funciona **mais a prova de que funciona**. Amanhã, quando alguém precisar mudar essa regra, vai ter os testes dizendo se quebrou alguma coisa. Isso é o que TDD compra."

---

## Perguntas que a turma (ou o professor) pode fazer

**"TDD não deixa o desenvolvimento mais lento?"**
Mais lento para escrever, mais rápido para terminar. O tempo que você não gasta escrevendo o teste, você gasta depois no debugger e em retrabalho. Estudos sobre TDD (o mais citado é o da IBM/Microsoft, de 2008) mediram 15–35% mais tempo de desenvolvimento inicial e 40–90% menos defeitos em produção. Vale citar que os resultados variam bastante por contexto e que a literatura não é unânime.

**"Qual a diferença entre TDD e teste unitário?"**
Teste unitário é o *artefato*; TDD é o *processo*. Dá para escrever teste unitário sem TDD (escrevendo depois). O contrário não existe.

**"E o TDD cobre teste de integração?"**
O ciclo é o mesmo, mas TDD clássico trabalha com testes rápidos e isolados. Testes de integração entram em outro momento, porque são lentos demais para rodar a cada 30 segundos.

**"Preciso de 100% de cobertura?"**
Não. Cobertura mede linhas executadas, não comportamento verificado. Dá para ter 100% de cobertura com testes que não verificam nada. O alvo é cobrir as **regras de negócio** e os **casos de borda**.

**"O que é BDD? É a mesma coisa?"**
Parente próximo. BDD (Behavior Driven Development) é TDD com o vocabulário voltado para o comportamento do usuário e uma linguagem que o pessoal de negócio consegue ler (*Dado / Quando / Então*). A mecânica do ciclo é a mesma.

**"Quem inventou isso?"**
Kent Beck popularizou no fim dos anos 1990 dentro do Extreme Programming, e publicou *Test-Driven Development: By Example* em 2002. É a referência se alguém pedir bibliografia.
