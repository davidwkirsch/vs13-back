public class ContaCorrente extends Conta implements Impressao{

    private double chequeEspecial = 300.0;

    @Override
    public void imprimir()
    {
        System.out.printf("\nConta corrente Nº: %s", super.getNumeroConta());
        System.out.printf("\nAgência: %d", super.getAgencia());
        System.out.printf("\nSaldo: %.2f", super.getSaldo());
        System.out.printf("\nSaldo total (saldo + cheque especial): %.2f", super.getSaldo() + getChequeEspecial());
    }

    public double retornarSaldoComChequeEspecial()
    {
        return super.getSaldo() + getChequeEspecial();
    }



    public double getChequeEspecial()
    {
        return this.chequeEspecial;
    }

}
