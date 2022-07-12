/**
    Autor: Nathan Andrade dos Santos Lobo
    DRE: 120082390
 */

import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String stopwords = "src/exercicio07/stopwords.txt";

        if(path.equals(".")) 
            path = System.getProperty("user.dir") + "/src/exercicio07/in.txt";
        
        sc.close();

        AnalisaTexto texto = new AnalisaTexto(path, stopwords);
        Map<String, Integer> palavras = texto.computarFrequencia();
        Set<String> palavrasUnicas = texto.pegarPalavrasUnicas();
        
        System.out.println("------");
        System.out.println(palavrasUnicas);
        System.out.println("------");
        System.out.println(palavras);
    }
}
