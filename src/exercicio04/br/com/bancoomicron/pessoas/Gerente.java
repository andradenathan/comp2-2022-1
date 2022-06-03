package exercicio04.br.com.bancoomicron.pessoas;

import exercicio04.br.com.bancoomicron.carteiras.CarteiraClientes;
import exercicio04.br.com.bancoomicron.carteiras.IAuditoria;

public class Gerente extends Pessoa implements IAuditoria {

    private CarteiraClientes carteiraClientes;

    Gerente(String cpf, String nome) {
        super(cpf, nome);
        this.carteiraClientes = new CarteiraClientes();
    }

    @Override
    public double somaSaldo() {
        return this.carteiraClientes.somaSaldo();
    }

    @Override
    public int quantidadeContas() {
        return this.carteiraClientes.quantidadeContas();
    }    
}
