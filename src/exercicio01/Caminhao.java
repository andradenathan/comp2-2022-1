package exercicio01;

/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

public class Caminhao extends Veiculo {
    public int qnt_eixos;
    private double capacid_carga;

    public static void main(String[] args) {
        System.out.println("--- MERCEDES BENZ ACCELO ---");
        
        Caminhao caminhao = new Caminhao("Mercedes", "Accelo 815", "Nathan", 6.2, 3.3, 150, 4, 8.3);
        System.out.println("KM Rodados: " + caminhao.lerRodagem()); 
        
        caminhao.abastecerTanque(30);
        System.out.println("Tanque abastecido. Tanque atual: " + caminhao.lerTanqueAtual() + "L");

        caminhao.fazerViagem(19);
        System.out.println("Viagem feita. Tanque atual: " + caminhao.lerTanqueAtual() + "L");
        
        System.out.print("KM Rodados: " + caminhao.lerRodagem() + "\n");
    }

    public Caminhao(
        String marca, 
        String modelo,
        String dono,
        double autonomia_km_l,
        double km_rodados,
        double tanque_capacid,
        double qnt_eixos,
        double capacid_carga
    ) 
    {
        super(marca, modelo, dono, tanque_capacid, autonomia_km_l);      
        super.alterarKmRodados(km_rodados);
    }

    public double lerCapacidCarga() {
        return this.capacid_carga;
    }

    public Boolean fazerViagem(double km, double carga) {
        if(this.lerCapacidCarga() >= carga) {
            return super.fazerViagem(km);
        }
        return false;
    }
}