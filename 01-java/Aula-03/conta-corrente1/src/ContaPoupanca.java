public class ContaPoupanca extends Conta implements Impressao{
    private static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(String numero, int agencia, Cliente cliente1) {
        super.setNumeroConta(numero);
        super.setAgencia(agencia);
        super.setCliente(cliente1);
    }
    public void creditarTaxa() {
        super.setSaldo(super.getSaldo() * JUROS_MENSAL);
    }
    @Override
    public void imprimir()
    {
        System.out.print("\n\nCONTA POUPANÇA");
        System.out.printf("\nConta corrente Nº: %s", super.getNumeroConta());
        System.out.printf("\nAgência: %d", super.getAgencia());
        System.out.printf("\nSaldo: %.2f", super.getSaldo());
    }
}
