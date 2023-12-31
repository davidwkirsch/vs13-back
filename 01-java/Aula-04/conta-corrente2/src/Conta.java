public class Conta implements IMovimentacao
{

    private Cliente cliente = new Cliente();
    private String numeroConta;
    private int agencia;
    private double saldo = 0;

    public Conta() {}
    public Conta(String numeroConta, int agencia, Cliente cliente)
    {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    @Override
    public boolean sacar(double valorSacado)
    {
        if (valorSacado <= getSaldo() && valorSacado > 0)
        {
            setSaldo(getSaldo() - valorSacado);
            System.out.println("\nValor sacado com sucesso!");
            return true;
        }
        else if (valorSacado <= 0)
        {
            System.out.println("\nO valor sacado deve ser maior que zero!");
            return false;
        }
        else
        {
            System.out.println("\nSaldo insuficiente!");
            return false;
        }
    }

    @Override
    public boolean depositar(double valorDeposito)
    {
        if (valorDeposito > 0) {
            setSaldo(getSaldo() + valorDeposito);
            System.out.println("\nValor depositado com sucesso!");
            return true;
        }
        System.out.println("\nO valor depositado deve ser maior que zero!");
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor < getSaldo() && valor > 0)
        {
            this.saldo -= valor;
            conta.saldo += valor;
            System.out.println("Transferência realizada com sucesso!");
            return true;
        }
        else if (valor < 0)
        {
            System.out.println("\nValor de transferência deve ser maior que zero! ");
            return false;
        }
        else
        {
            return false;
        }
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
