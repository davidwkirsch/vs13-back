package br.com.dbccompany.vemser;

public class ContaPagamento extends Conta implements IImpressao {

    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(String numeroConta, int agencia, Cliente cliente) {
        super(numeroConta, agencia, cliente);
    }

    @Override
    public boolean sacar(double valorSacado)
    {
        if ((valorSacado + TAXA_SAQUE) <= super.getSaldo() && valorSacado > 0)
        {
            setSaldo(super.getSaldo() - (valorSacado + TAXA_SAQUE));
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
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
    }

    @Override
    public void imprimir()
    {
        System.out.print("\n\nCONTA DE PAGAMENTO");
        System.out.printf("\nConta de pagamento Nº: %s", super.getNumeroConta());
        System.out.printf("\nAgência: %d", super.getAgencia());
        System.out.printf("\nSaldo: %.2f", super.getSaldo());
    }

}
