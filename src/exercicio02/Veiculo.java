package exercicio02;

/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

public class Veiculo {
    public String marca;
    public String modelo;
    public String dono;

    private double tanque_capacid;
    private double tanque_atual;
    private double autonomia_km_l;
    private double km_rodados;

    public static void main(String[] args) {
        System.out.print("--- HONDA FIT ---\n");
        Veiculo hondaFit = new Veiculo("Honda", "Fit", "Nathan", 45.3, 8.3);
        
        hondaFit.abastecerTanque(38.27);
        System.out.println("Tanque atual do Honda Fit: " + hondaFit.lerTanqueAtual());

        hondaFit.fazerViagem(15);
        System.out.println("Viagem feita. Tanque atual: " + hondaFit.lerTanqueAtual());
        
        System.out.print("--- FIAT PALIO ---\n");
        Veiculo fiatPalio = new Veiculo("Fiat", "Palio", "Nathan", 30, -17.5);

        fiatPalio.abastecerTanque(19.0);
        System.out.println("Tanque atual do Fiat Palio: " + fiatPalio.lerTanqueAtual());

        fiatPalio.alterarAutonomia(6.5);
        System.out.print("Autonomia alterada. Autonomia/Km: " + fiatPalio.lerTanqueAtual() + "\n");
        
        fiatPalio.fazerViagem(8);
        System.out.print("Viagem feita. Tanque atual: " + fiatPalio.lerTanqueAtual() + "\n");
    }

    public Veiculo(
        String marca, 
        String modelo,
        String dono,
        double tanque_capacid,
        double autonomia_km_l
    ) 
    {
        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;
        this.tanque_atual = 0;
        this.km_rodados = 0;

        if(!this.validarProp(tanque_capacid)) {
            this.tanque_capacid = 10;
            System.out.println("Parâmetro inválido para capacidade do tanque!");
        }

        if(!this.validarProp(autonomia_km_l)) {
            this.autonomia_km_l = 10;
            System.out.println("Parâmetro inválido para a autonomia de KM/L!");
        }

        this.tanque_capacid = tanque_capacid;
        this.autonomia_km_l = autonomia_km_l;
    }


    private Boolean validarProp(double prop) {
        return prop > 0 ? true : false; 
    }

    public double lerTanqueAtual() {
        return tanque_atual;
    }

    public double lerTanqueCapacid() {
        return tanque_capacid;
    }

    public double lerAutonomia() {
        return autonomia_km_l;
    }

    public double lerRodagem() {
        return km_rodados;
    }

    public void alterarAutonomia(double autonomia_km_l) {
        if(!this.validarProp(autonomia_km_l)) {
            this.autonomia_km_l = 10;
            System.out.println("Parâmetro inválido para a autonomia de KM/L!");
        }

        this.autonomia_km_l = autonomia_km_l;
    }

    public void alterarKmRodados(double km_rodados) {
        this.km_rodados = km_rodados;
    }

    public Boolean abastecerTanque(double litros) {
        if(this.validarProp(litros) && (this.tanque_atual + litros <= this.tanque_capacid)) {
            this.tanque_atual += litros;
            return true;
        }

        return false;
    }

    public Boolean fazerViagem(double km) {
        double litros = km / this.autonomia_km_l;
        if(litros > this.tanque_atual) {
            return false;
        } 
    
        this.tanque_atual -= litros;
        this.km_rodados += km;
        return true;
    }
}