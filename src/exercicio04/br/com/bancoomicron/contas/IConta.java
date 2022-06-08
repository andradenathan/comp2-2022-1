package exercicio04.br.com.bancoomicron.contas;

public interface IConta {
    public boolean sacar(double valor);
    public void depositar(double valor);
    public double getSaldo();
    public int getNumero();
    public int getMatriculaCliente();
}
