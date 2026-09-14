package br.edu.tdd.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidadorDeSenhaTest {

    @Test
    void senhaComMenosDeOitoCaracteresEhInvalida() {
        ValidadorDeSenha validador = new ValidadorDeSenha();

        assertFalse(validador.ehValida("Abc123"));
    }
}
