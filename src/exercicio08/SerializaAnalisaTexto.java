package exercicio08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import exercicio07.AnalisaTexto;
import java.io.IOException;

public class SerializaAnalisaTexto {
    public static boolean serializarAnaliseTexto(String caminho, AnalisaTexto texto) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(caminho);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(texto);
            objectOutputStream.close();
            return true;
        } catch (IOException ioe) {
            System.out.println("Erro ao serializar: " + ioe.getMessage());
            return false;
        }
    }

    public static AnalisaTexto desserializarAnalisaTexto(String caminho) {
        try {
            FileInputStream fileIn = new FileInputStream(caminho);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            AnalisaTexto texto = (AnalisaTexto) objectIn.readObject();
            objectIn.close();
            return texto;
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar: " + e.getMessage());
            return null;
        }
    }
}    
