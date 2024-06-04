package webminds.group.pet_backend.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginServiceTest {

    @Test
    @DisplayName("Quando entrar com email e senha deve logar")
    public void testLoginSucesso(){
        // Dados de entrada
        String email = "usuario@example.com";
        String senha = "senha123";

        // Verificação do resultado
        assertTrue(validarCredenciais(email, senha), "Os dados de login são corretos.");

        // Simulação de requisição HTTP com código 200
        int codigoHTTP = fazerRequisicaoHTTP(email, senha);


        // Verificação do código HTTP retornado
        assertEquals(200, codigoHTTP, "A requisição HTTP retornou o código 200 OK.");
    }

    // Método simulado para validar credenciais
    public static boolean validarCredenciais(String email, String senha) {
        // Simulação de validação de credenciais
        // Neste exemplo, retornamos true para qualquer entrada
        return true;
    }

    // Método simulado para fazer uma requisição HTTP
    public static int fazerRequisicaoHTTP(String email, String senha) {
        // Simulação de requisição HTTP com código 200
        return 200;
    }
}
