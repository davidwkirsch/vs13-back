public class Conta {

    private Cliente cliente = new Cliente();
    private String numeroConta;
    private int agencia;
    private double saldo = 0;

    public Conta() {}
    public Conta(String numeroConta, int agencia, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.cliente = cliente;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
