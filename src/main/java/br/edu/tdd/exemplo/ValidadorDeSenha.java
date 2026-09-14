package br.edu.tdd.exemplo;

/**
 * Resultado do exemplo construido ao vivo na aula.
 * Veja PASSO-A-PASSO-EXEMPLO.md para os ciclos que levaram ate aqui.
 */
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
