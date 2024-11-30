import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@PostMapping("/saveUserData")
@ResponseBody
public ResponseEntity<String> saveUserData(@RequestBody UserDataRequest userData) {
    // Salvar os dados no banco de dados ou realizar outra lógica
    System.out.println("Dados recebidos: " + userData);

    return ResponseEntity.ok("Dados salvos com sucesso!");
}

// Classe para mapear os dados recebidos
public static class UserDataRequest {
    private String username;
    private String userId;
    private String securityCode;
    private List<Post> posts;

    // Getters e setters

    public static class Post {
        private String username;
        private String description;

        // Getters e setters
    }
}
