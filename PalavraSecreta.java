package projetoPOOTermo;
import java.util.List;
import java.util.Random;


public class PalavraSecreta {

    private String palavra;

    public PalavraSecreta(List<String> palavras) {
        escolherPalavraAleatoria(palavras);
    }

    private void escolherPalavraAleatoria(List<String> palavras) {
//        Random random = new Random();
//        int indice = random.nextInt(palavras.size());
//        palavra = palavras.get(indice).toUpperCase();
        palavra = "Cinco";
    }

    public String getPalavra() {
        return palavra;
    }

//    public int getTamanho() {
//        return palavra.length();
//    }

    public char getLetra(int indice) {
        return palavra.charAt(indice);
    }

    public boolean contains(String valueOf) {
        return false;
    }
}