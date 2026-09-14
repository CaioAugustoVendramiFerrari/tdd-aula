package br.edu.tdd.exemplo;

public class ValidadorDeSenha {

    public boolean ehValida(String senha) {
        return senha.length() >= 8;
    }
}
