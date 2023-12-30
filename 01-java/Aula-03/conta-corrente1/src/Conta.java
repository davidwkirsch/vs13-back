public class Conta implements Movimentacao
{

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

    public boolean sacar(double valorSacado)
    {
        if (valorSacado <= super.getSaldo()+this.chequeEspecial && super.getSaldo()+getChequeEspecial() > 0 && valorSacado > 0)
        {
            super.setSaldo(super.getSaldo() - valorSacado);
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

    public boolean depositar(double valorDeposito)
    {
        if (valorDeposito > 0) {
            super.setSaldo(super.getSaldo() + valorDeposito);
            System.out.println("\n Valor depositado com sucesso!");
            return true;
        }
        System.out.println("\nO valor depositado deve ser maior que zero!");
        return false;
    }
    public boolean transferir(ContaCorrente conta, double valor)
    {
        if (valor < super.getSaldo() && valor > 0)
        {
            this.saldo -= valor;
            conta.saldo += valor;
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
