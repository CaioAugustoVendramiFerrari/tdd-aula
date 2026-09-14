package br.edu.tdd.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorDeSenhaTest {

    @Test
    void senhaComMenosDeOitoCaracteresEhInvalida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertFalse(validador.ehValida("Abc123"));
    }

    @Test
    void senhaComOitoOuMaisCaracteresEhValida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertTrue(validador.ehValida("Abcd1234"));
    }
}
