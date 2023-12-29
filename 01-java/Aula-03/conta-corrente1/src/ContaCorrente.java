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

    public boolean retornarSaldoComChequeEspecial()
    {
        return true;
    }

    public boolean transferir(String ContaCorrente, double valor)
    {
        return true;
    }

}
