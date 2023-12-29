public class ContaCorrente {
    Cliente cliente = new Cliente();
    String numeroConta;
    int agencia;
    double saldo,
    chequeEspecial;

    public void imprimirContaCorrente()
    {
        System.out.printf("Conta corrente: %s", this.numeroConta);
    }

    public boolean sacar(double valorSacado)
    {
        if (valorSacado > this.saldo)
        {
            return false;
        }
        else
        {
            this.saldo -= valorSacado;
            return true;
        }

    }

    public boolean depositar(double valorDeposito)
    {
        this.saldo += valorDeposito;
        return true;
    }

    public double retornarSaldoComChequeEspecial()
    {
        return this.saldo + this.chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor)
    {
        if (valor > this.saldo)
        {
            this.saldo -= valor;
            conta.saldo += valor;
            return true;
        }
        else
        {
            return false;
        }
    }

}
