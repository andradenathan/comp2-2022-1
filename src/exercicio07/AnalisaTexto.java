/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class AnalisaTexto {
    private ArrayList<String> palavras;

    public AnalisaTexto(String caminho) {
        this.palavras = this.lerArquivo(caminho);
    }

    public AnalisaTexto(String caminho, String caminhoStopWords) {
        this(caminho);
        ArrayList<String> stopwords = this.lerArquivo(caminhoStopWords);
        this.filtrarStopWords(stopwords);
    }
    
    public ArrayList<String> lerArquivo(String caminho) {
        try {
            FileReader fileReader = new FileReader(caminho);
            BufferedReader reader = new BufferedReader(fileReader);
            String linhas = "", linha;
            while((linha = reader.readLine()) != null) {
                linhas += " " + linha;
            }
            reader.close();

            linhas = linhas.toUpperCase(Locale.ROOT);
            linhas = linhas.replaceAll("\\p{Punct}", "");

            String[] palavrasFormatadas = linhas.split(" ");
            System.out.println(Arrays.toString(palavrasFormatadas));
            ArrayList<String> resultado = new ArrayList<String>();

            for(int index = 0; index < palavrasFormatadas.length; ++index) {
                resultado.add(palavrasFormatadas[index]);   
            }

            System.out.println("Sucesso ao ler arquivo");
            return resultado;
        } catch (IOException ioe) {
            System.out.println("Erro ao ler arquivo" + ioe.getMessage());
        }

        return null;
    }

    public Set<String> pegarPalavrasUnicas() {
        Set<String> palavrasUnicas = new HashSet<String>();
        palavrasUnicas.addAll(this.palavras);
        return palavrasUnicas;
    }
    
    public Map<String, Integer> computarFrequencia() {
        Map<String, Integer> frequenciasDasPalavras = new HashMap<String, Integer>();
        for (String palavra : palavras) {
            int frequencia = 1;

            if(frequenciasDasPalavras.containsKey(palavra)) {
                frequenciasDasPalavras.put(
                    palavra, 
                    frequenciasDasPalavras.get(palavra) + 1
                );
            } else {
                frequenciasDasPalavras.put(palavra, frequencia);
            }
        }

        return frequenciasDasPalavras;
    }

    private void filtrarStopWords(ArrayList<String> stopwords) {
        ArrayList<String> palavrasFiltradas = new ArrayList<String>();
        for(String palavra : palavras) {
            if(!stopwords.contains(palavra)) {
                palavrasFiltradas.add(palavra);
            }
        }

        this.palavras = palavrasFiltradas;
    }
}