/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnalisaTexto {
    public String caminho;
    public ArrayList<String> conteudos = new ArrayList<String>();

    public AnalisaTexto(String caminho) {
        this.caminho = caminho;

        ArrayList<String> conteudosNaoFormatado = this.pegarConteudos(caminho);

        for (int index = 0; index < conteudosNaoFormatado.size(); index++) {
            String conteudo = conteudosNaoFormatado.get(index);
            String[] conteudoSeparado = conteudo.split(" ");
            for (String palavra : conteudoSeparado) {
                this.conteudos.add(palavra.toUpperCase());
            }
        }

        this.adicionarConteudos(this.conteudos);
    }

    public AnalisaTexto(String caminho, String caminhoStopWords) {
        this.caminho = caminho;

        ArrayList<String> conteudosFiltrados = this.pegarConteudos(caminho);
        ArrayList<String> palavras = this.pegarConteudos(caminhoStopWords);

        for (int index = 0; index < conteudosFiltrados.size(); index++) {
            String conteudo = conteudosFiltrados.get(index);
            String[] conteudoSeparado = conteudo.split(" ");
            for (String palavra : conteudoSeparado) {
                palavra = this.removePontuacoes(palavra);
                this.conteudos.add(palavra.toUpperCase());
            }
        }

        this.adicionarConteudos(this.conteudos);

        for(int index = 0; index < palavras.size(); index++) {
            String palavra = palavras.get(index);
            if(conteudosFiltrados.contains(palavra.toUpperCase())) {
                palavra = this.removePontuacoes(palavra);
                while(conteudosFiltrados.remove(palavra.toUpperCase()));
            }
        }

        this.conteudos = conteudosFiltrados;
        System.out.println(conteudos);
    }
    
    public Set<String> pegarPalavrasUnicas() {
        Set<String> palavrasUnicas = new HashSet<String>();
        try {
            FileReader fileReader = new FileReader(this.caminho);
            BufferedReader reader = new BufferedReader(fileReader);

            for(
                String palavra = reader.readLine(); 
                palavra != null; 
                palavra = reader.readLine()
            ) 
            {
                palavrasUnicas.add(palavra);
            }
            
            reader.close();
        } catch(IOException ioException) {
            System.out.println("Error ao ler o arquivo: " + ioException.getMessage());
        }

        return palavrasUnicas;
    }
    
    public Map<String, Integer> computarFrequencia() {
        Map<String, Integer> frequenciasDasPalavras = new HashMap<String, Integer>();
        ArrayList<String> conteudos = this.pegarConteudos(this.caminho);

        for (String conteudo : conteudos) {
            int frequencia = 1;

            if(frequenciasDasPalavras.containsKey(conteudo)) {
                frequenciasDasPalavras.put(
                    conteudo, 
                    frequenciasDasPalavras.get(conteudo) + 1
                );
            } else {
                frequenciasDasPalavras.put(conteudo, frequencia);
            }
        }

        return frequenciasDasPalavras;
    }

    public ArrayList<String> pegarConteudos(String caminho) {
        ArrayList<String> conteudos = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(caminho);
            BufferedReader reader = new BufferedReader(fileReader);
            
            for(
                String conteudo = reader.readLine(); 
                conteudo != null; 
                conteudo = reader.readLine()
            ) {
                conteudos.add(conteudo);
            }
            
            reader.close();
        } catch(IOException ioException) {
            System.out.println("Error ao ler o arquivo: " + ioException.getMessage());
        }

        return conteudos;
    }

    public void adicionarConteudos(ArrayList<String> conteudos) {
        try {
            FileWriter fileWriter = new FileWriter(this.caminho);
            PrintWriter writer = new PrintWriter(fileWriter);
            
            for (String conteudo : conteudos) {
                writer.println(conteudo);
            }
            
            writer.close();
        } catch(IOException ioException) {
            System.out.println("Error ao salvar o conteúdo: " + ioException.getMessage());
        }
    }

    public String removePontuacoes(String palavra) {
        return palavra.replaceAll("\\p{Punct}", "");
    }
}