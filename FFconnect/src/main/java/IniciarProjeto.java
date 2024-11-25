import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class IniciarProjeto {
    public static void main(String[] args) {
        try {
            // Caminho absoluto do arquivo HTML
            URI uri = IniciarProjeto.class.getClassLoader().getResource("Pagina Inicial.html").toURI();
            File htmlFile = new File(uri);

            // Abre o arquivo HTML no navegador padrão
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(htmlFile);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}






