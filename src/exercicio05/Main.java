package exercicio05;

import java.util.Scanner;

import exercicio05.Veiculo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a marca do veiculo: ");
        String marca = sc.nextLine();
        
        System.out.println("Digite o modelo do veiculo: ");
        String modelo = sc.nextLine();
        
        System.out.println("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a capacidade do tanque atual: ");
        double capacidade_tanque = sc.nextDouble();

        System.out.println("Digite a quantidade de km rodados do carro: ");
        double km_rodados = sc.nextDouble();

        Veiculo veiculo = new Veiculo(
            marca,
            modelo,
            nome,
            capacidade_tanque,
            km_rodados
        );

        System.out.println("----------");
        System.out.println("Veiculo de " + nome);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidade do tanque: " + capacidade_tanque);
        System.out.println("Quilometros rodados: " + km_rodados);
        System.out.println("----------");
    }    
}
