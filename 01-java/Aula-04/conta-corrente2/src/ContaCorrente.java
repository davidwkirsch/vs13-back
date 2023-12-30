public class ContaCorrente {
    Cliente cliente = new Cliente();
    String numeroConta;
    int agencia;
    double saldo,
    chequeEspecial = 300.0;

    public void imprimirContaCorrente()
    {
        System.out.printf("\nConta corrente Nº: %s", this.numeroConta);
        System.out.printf("\nAgência: %d", this.agencia);
        System.out.printf("\nSaldo: %.2f", this.saldo);
        System.out.printf("\nSaldo total (saldo + cheque especial): %.2f", this.saldo + this.chequeEspecial);
    }

    public boolean sacar(double valorSacado)
    {
        if (valorSacado <= this.saldo+this.chequeEspecial && this.saldo+this.chequeEspecial > 0 && valorSacado > 0)
        {
            this.saldo -= valorSacado;
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
            this.saldo += valorDeposito;
            System.out.println("\n Valor depositado com sucesso!");
            return true;
        }
        System.out.println("\nO valor depositado deve ser maior que zero!");
        return false;
    }

    public double retornarSaldoComChequeEspecial()
    {
        return this.saldo + this.chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor)
    {
        if (valor < this.saldo && valor > 0)
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

}
