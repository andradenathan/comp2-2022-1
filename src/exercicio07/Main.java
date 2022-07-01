import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String path = "/home/n/ufrj/comp2-2022-1/src/exercicio07/output.txt";
        
        AnalisaTexto texto = new AnalisaTexto(path);
        Map<String, Integer> palavras = texto.computarFrequencia();
        Set<String> palavrasUnicas = texto.pegarPalavrasUnicas();
        
        System.out.println("------");
        System.out.println(palavrasUnicas);
        System.out.println("------");
        System.out.println(palavras);
    }
}
