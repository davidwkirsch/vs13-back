package br.com.dbccompany.vemser;

public interface IMovimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);

}
