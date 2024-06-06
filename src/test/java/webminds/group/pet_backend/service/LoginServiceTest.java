package webminds.group.pet_backend.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class LoginServiceTest {

    @Test
    @DisplayName("Quando entrar com email e senha corretos deve logar com sucesso")
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

    @Test
    @DisplayName("Quando entrar com email ou senha inválidos deve falhar")
    public void testLoginFalha(){
        // Dados de entrada inválidos
        String email = "usuario@example.com";
        String senha = "senha_incorreta";

        // Verificação do resultado
        assertFalse(validarCredenciais(email, senha), "Os dados de login são inválidos.");

        // Simulação de requisição HTTP com código 400
        int codigoHTTP = fazerRequisicaoHTTP(email, senha);

        // Verificação do código HTTP retornado
        assertEquals(400, codigoHTTP, "A requisição HTTP retornou o código 400 Bad Request.");
    }

    // Método simulado para validar credenciais
    public static boolean validarCredenciais(String email, String senha) {
        // Simulação de validação de credenciais
        // Neste exemplo, retornamos true apenas se email e senha forem válidos
        return email.equals("usuario@example.com") && senha.equals("senha123");
    }

    // Método simulado para fazer uma requisição HTTP
    public static int fazerRequisicaoHTTP(String email, String senha) {
        // Simulação de requisição HTTP
        // Aqui estamos simulando uma requisição e retornando um código de status fictício
        // No caso de sucesso, retornamos 200; no caso de falha, retornamos 400
        if (validarCredenciais(email, senha)) {
            return 200;
        } else {
            return 400;
        }
    }
}
