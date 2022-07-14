package exercicio08;

import exercicio07.AnalisaTexto;

public class Main {
    public static void main(String[] args) {
        AnalisaTexto texto, textoClone;
        
        String caminho = "src/exercicio08/in.txt";
        texto = new AnalisaTexto(caminho);
        SerializaAnalisaTexto.serializarAnaliseTexto(caminho, texto);
        textoClone = SerializaAnalisaTexto.desserializarAnalisaTexto(caminho);

        if(textoClone != null) {
            System.out.println("Texto == TextoClone? " + texto.equals(textoClone));
        }
    }
}
