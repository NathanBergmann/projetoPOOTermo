package projetoPOOTermo;
import java.util.List;
import java.util.Random;


public class PalavraSecreta {

    private String palavra;

    public String escolherPalavraAleatoria() {

        RequestApiList requestApiList = new RequestApiList();
        List<String> listaRetorno = requestApiList.consultarAPI();
        Random random = new Random();
        int indice = random.nextInt(listaRetorno.size());
        palavra = listaRetorno.get(indice).toUpperCase();
        System.out.println("palavra chave é:"+ palavra);
        return palavra;
    }

    public String getPalavra()
    {
        return palavra;
    }

    public char getLetra(int indice) {
        return palavra.charAt(indice);
    }
}