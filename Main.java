package projetoPOOTermo;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("sagaz", "amago");

        JogoAdivinhacao jogo = new JogoAdivinhacao(palavras);
        jogo.iniciarJogo();
    }
}
