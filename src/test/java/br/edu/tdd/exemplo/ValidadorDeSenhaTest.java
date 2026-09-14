package br.edu.tdd.exemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorDeSenhaTest {

    private ValidadorDeSenha validador;

    @BeforeEach
    void setUp() {
        validador = new ValidadorDeSenha();
    }

    @Test
    @DisplayName("Senha com menos de 8 caracteres e invalida")
    void senhaComMenosDeOitoCaracteresEhInvalida() {
        assertFalse(validador.ehValida("Abc123"));
    }

    @Test
    @DisplayName("Senha com 8 ou mais caracteres, numero e maiuscula e valida")
    void senhaComOitoOuMaisCaracteresEhValida() {
        assertTrue(validador.ehValida("Abcd1234"));
    }

    @Test
    @DisplayName("Senha sem numero e invalida")
    void senhaSemNumeroEhInvalida() {
        assertFalse(validador.ehValida("Abcdefgh"));
    }

    @Test
    @DisplayName("Senha sem letra maiuscula e invalida")
    void senhaSemLetraMaiusculaEhInvalida() {
        assertFalse(validador.ehValida("abcd1234"));
    }
}
