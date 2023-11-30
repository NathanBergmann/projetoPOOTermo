package projetoPOOTermo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JogoAdivinhacao {

    private PalavraSecreta palavraSecreta;
    private StringBuilder palavraAdivinhada;
    private int tentativasRestantes;
    List<String> letrasCorretas = new ArrayList<>(Arrays.asList(" _ ", "_ ", "_ ", "_ ", "_ "));
   // ArrayList<String> letraPosicaoErrada = new ArrayList<>();


    public JogoAdivinhacao(List<String> palavras) {
        this.palavraSecreta = new PalavraSecreta(palavras);
        this.palavraAdivinhada = new StringBuilder();
        this.tentativasRestantes = 5; // Número de tentativas permitidas
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        boolean acertou = false;

        while (tentativasRestantes > 0 && !palavraAdivinhada.toString().equals(palavraSecreta.getPalavra())) {
            exibirStatusJogo();
            System.out.print("Digite uma palavra: ");
            String palpite = scanner.next().toUpperCase();
            if (!tentativaValida(palpite)){
                System.out.println("Por favor, digite uma palavra com 5 letras!");
                continue;
            }
             if (palpite.toUpperCase().equals(palavraSecreta.getPalavra().toUpperCase())) {
                 System.out.println("Parabéns! Você adivinhou a palavra correta: " + palavraSecreta.getPalavra());
                 acertou = true;
                 break;
            } else if (!palpite.equals(palavraSecreta.getPalavra())) {
                verificarPalpite(palpite);
            }
        }
        scanner.close();

        if (!acertou){
            System.out.println("Você perdeu! A palavra correta era: " + palavraSecreta.getPalavra());
        }
}

    private void exibirStatusJogo() {

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Palavra a ser adivinhada: " + letrasCorretas);
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    private void verificarPalpite(String palpite) {
        for (int i = 0; i < 5; i++) {
            char letra = palpite.charAt(i);
            for (int j = 0; j < 5; j++){
                if (String.valueOf(letra).toUpperCase().equals(String.valueOf(palavraSecreta.getLetra(j)).toUpperCase())){
                    letrasCorretas.set(j, String.valueOf(letra));
                    //break;
                }
            }
        }
        tentativasRestantes--;
    }

    private boolean tentativaValida(String palavraDigitada){
        if (palavraDigitada.length() == 5){
            return true;
        }
        return false;
    }
}
