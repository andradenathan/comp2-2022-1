package exercicio05;

class Veiculo 
{
    public String marca;
    public String modelo;
    public String dono;

    private double tanque_capacid;
    private double tanque_atual;
    private double autonomia_km_l;
    private double km_rodados;

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
            throw new IllegalArgumentException(
                "Parâmetro inválido para a capacidade do tanque!"
            );
        }

        if(!this.validarProp(autonomia_km_l)) {
            this.autonomia_km_l = 10;
            throw new IllegalArgumentException(
                "Parâmetro inválido para a autonomia de km/L!"
            );
        }

        this.tanque_capacid = tanque_capacid;
        this.autonomia_km_l = autonomia_km_l;
    }

    private Boolean validarProp(double prop) {
        return prop > 0; 
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
            throw new IllegalArgumentException("Parâmetro inválido para a autonomia de km/L!");
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