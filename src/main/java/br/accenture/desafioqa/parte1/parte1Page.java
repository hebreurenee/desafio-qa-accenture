package br.accenture.desafioqa.parte1;
import java.util.UUID;
public class parte1Page {
    public String gerarNomeUsuario() {
        // Gera um nome de usuário aleatório usando UUID
        return "Usuario" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Método para criar um payload de usuário
    public String criarPayload() {
        String userName = gerarNomeUsuario(); // Gera um nome de usuário aleatório
        String Senha_FIXA = "Senha1234@";
        return "{\n" +
                "    \"userName\": \"" + userName + "\",\n" +
                "    \"password\": \"" + Senha_FIXA + "\"\n" +
                "}";
    }

    public String Payloadjaexistente() {
        String userName = "Usuario4470cd08"; // Gera um nome de usuário aleatório
        String Senha_FIXA = "Senha1234@";
        return "{\n" +
                "    \"userName\": \"" + userName + "\",\n" +
                "    \"password\": \"" + Senha_FIXA + "\"\n" +
                "}";
    }
}
