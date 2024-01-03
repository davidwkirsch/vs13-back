public class ContaCorrente extends Conta implements IImpressao {

    private double chequeEspecial;

    public ContaCorrente(String numero, int agencia, Cliente cliente1, double chequeEspecial) {
        super.setNumeroConta(numero);
        super.setAgencia(agencia);
        super.setCliente(cliente1);
        setChequeEspecial(chequeEspecial);
    }

    @Override
    public void imprimir()
    {
        System.out.print("\n\nCONTA CORRENTE");
        System.out.printf("\nConta corrente Nº: %s", super.getNumeroConta());
        System.out.printf("\nAgência: %d", super.getAgencia());
        System.out.printf("\nSaldo: %.2f", super.getSaldo());
        System.out.printf("\nSaldo total (saldo + cheque especial): %.2f", super.getSaldo() + getChequeEspecial());
    }

    @Override
    public boolean sacar(double valorSacado)
    {
        if (valorSacado <= super.getSaldo() + getChequeEspecial() && super.getSaldo() + getChequeEspecial() > 0 && valorSacado > 0)
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
    public double retornarSaldoComChequeEspecial()
    {
        return super.getSaldo() + getChequeEspecial();
    }

    public double getChequeEspecial()
    {
        return chequeEspecial;
    }

    public void setChequeEspecial(double valor)
    {
        this.chequeEspecial = valor;
    }

}
