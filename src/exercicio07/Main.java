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

        if(path.equals(".")) 
            path = System.getProperty("user.dir") + "/src/exercicio07/output.txt";
        
        sc.close();
        
        AnalisaTexto texto = new AnalisaTexto(path);
        Map<String, Integer> palavras = texto.computarFrequencia();
        Set<String> palavrasUnicas = texto.pegarPalavrasUnicas();
        
        // System.out.println("------");
        // System.out.println(palavrasUnicas);
        // System.out.println("------");
        // System.out.println(palavras);
    }
}
