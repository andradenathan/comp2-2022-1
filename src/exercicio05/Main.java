/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */
package exercicio05;

import java.util.Scanner;

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

        sc.close();
        
        Veiculo veiculo = new Veiculo(
            marca,
            modelo,
            nome,
            capacidade_tanque,
            km_rodados
        );

        System.out.println("----------");
        System.out.println("Veiculo de " + veiculo.dono);
        System.out.println("Marca: " + veiculo.marca);
        System.out.println("Modelo: " + veiculo.modelo);
        System.out.println("Capacidade do tanque: " + veiculo.lerTanqueCapacid());
        System.out.println("Quilometros rodados: " + veiculo.lerAutonomia());
        System.out.println("----------");
    }    
}
