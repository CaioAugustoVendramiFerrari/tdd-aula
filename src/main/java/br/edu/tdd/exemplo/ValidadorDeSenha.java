package br.edu.tdd.exemplo;

public class ValidadorDeSenha {

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
}
