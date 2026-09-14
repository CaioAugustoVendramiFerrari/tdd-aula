package br.edu.tdd.exemplo;

public class ValidadorDeSenha {

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
}
