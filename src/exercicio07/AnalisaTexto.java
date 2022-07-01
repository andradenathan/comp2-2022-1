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
    
    public AnalisaTexto(String caminho) {
        this.caminho = caminho;

        ArrayList<String> conteudos = this.pegarConteudos();

        for (int index = 0; index < conteudos.size(); index++) {
            String conteudo = conteudos.get(index);
            conteudos.set(index, conteudo.toUpperCase());
        }
        
        adicionarConteudos(conteudos);
    }
    
    public Set pegarPalavrasUnicas() {
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
        ArrayList<String> conteudos = this.pegarConteudos();

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

    public ArrayList<String> pegarConteudos() {
        ArrayList<String> conteudos = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(this.caminho);
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

    public void adicionarConteudos(ArrayList<String> contents) {
        try {
            FileWriter fileWriter = new FileWriter(this.caminho);
            PrintWriter writer = new PrintWriter(fileWriter);
            
            for (String content : contents) {
                writer.println(content);
            }
            
            writer.close();
        } catch(IOException ioException) {
            System.out.println("Error ao salvar o conteúdo: " + ioException.getMessage());
        }
    }
}