//Ainda não utilizado
package projetoPOOTermo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class RequestApiList {

    public  List<String> consultarAPI() {
        String apiUrl = "https://www.ime.usp.br/~pf/dicios/br-sem-acentos.txt";
        try {
            String response = obterConteudoDaURL(apiUrl);
            List<String> palavrasComCincoLetras = filtrarPalavrasComCincoLetras(response);
            return palavrasComCincoLetras;
        } catch (IOException e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }
        return null;
    }

    private String obterConteudoDaURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();

        return content.toString();
    }

    private  List<String> filtrarPalavrasComCincoLetras(String texto) {
        return List.of(texto.split("\\s+"))
                .stream()
                .filter(palavra -> palavra.length() == 5)
                .collect(Collectors.toList());
    }
}
