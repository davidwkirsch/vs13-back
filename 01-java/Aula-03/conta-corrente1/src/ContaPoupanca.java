public class ContaPoupanca extends Conta implements Impressao{
    private static double JUROS_MENSAL = 1.01;
    public void creditarTaxa() {
        super.setSaldo(super.getSaldo() * JUROS_MENSAL);
    }
    @Override
    public void imprimir() {

    }
}
