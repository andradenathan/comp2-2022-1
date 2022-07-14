/**
    Autor: Nathan Andrade dos Santos Lobo
    DRE: 120082390
 */

package exercicio06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> contents = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Insira algum conteúdo para salvar no arquivo: ");

            String content = sc.nextLine();
            contents.add(content);
            System.out.println("Conteúdo salvo com sucesso!");
            
            System.out.println("Deseja continuar inserindo? [S/FIM]");
            if(sc.nextLine().equals("FIM")) break;
        }

        System.out.println("Digite o caminho do arquivo: ");
        String path = sc.nextLine();

        if(path.equals(".")) 
            path = System.getProperty("user.dir") + "/src/exercicio06/output.txt";
        

        sc.close();

        writeFile(path, contents);

        System.out.println("Arquivo salvo com sucesso!");

        readFile(path);
    }

    public static void writeFile(String path, ArrayList<String> contents) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter writer = new PrintWriter(fileWriter);
            
            for (String content : contents) {
                writer.println(content);
            }
            
            writer.close();
        } catch(IOException ioException) {
            System.out.println("Error ao salvar o conteúdo: " + ioException.getMessage());
        }
    }
    

    public static void readFile(String path) {
        try {
            int line = 1;
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);

            for(String lineContent = reader.readLine(); lineContent != null; lineContent = reader.readLine()) {
                System.out.println("Conteúdo lido na linha " + line + ": " + lineContent);
                line++;
            }   
            
            reader.close();

        } catch(IOException ioException) {
            System.out.println("Error ao ler o conteúdo: " + ioException.getMessage());
        }
    }
}