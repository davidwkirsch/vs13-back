public class Main {
    public static void main(String[] args)
    {
        //Endereços
        Endereco endereco1Cliente1 = new Endereco(1, 1000, "R. Bananeira", "",
                "Ivoti", "93900-000","RS", "Brasil");
        Endereco endereco2Cliente1 = new Endereco(2, 2000, "R. Macieira", "",
                "Ivoti", "93900-000","RS", "Brasil");
        Endereco endereco1Cliente2 = new Endereco(1, 2222, "Av. Nemaquinemla", "Casa de rico",
                "São Paulo", "45800.600", "SP", "Brasil");

        //Contatos
        Contato contato1Cliente1 = new Contato(1, "Cel", "(51) 980805050");
        Contato contato1Cliente2 = new Contato(1, "Whats", "985214752");
        Contato contato2Cliente2 = new Contato(2, "Cel Empresa", "51 3030-8020");

        //Clientes
        Cliente cliente1 = new Cliente("David Kirsch", "123.456.789-00",
                 new Contato[]{contato1Cliente1, null}, new Endereco[]{endereco1Cliente1, endereco2Cliente1});
        Cliente cliente2 = new Cliente("Lucas Brasil", "85465485813",
                new Contato[]{contato1Cliente2, contato2Cliente2}, new Endereco[]{endereco1Cliente2, null});

        //Contas
        ContaCorrente contaCorrenteCliente1 = new ContaCorrente("123456", 1234, cliente1, 300);
        ContaPoupanca contaCliente2 = new ContaPoupanca("333666", 1034, cliente2);
        ContaPagamento contaPagamentoCliente1 = new ContaPagamento("888888", 9999, cliente1);

        //Contas iniciam zeradas, então é feito um depósito inicial em cada uma
        contaCorrenteCliente1.depositar(1000);
        contaCliente2.depositar(200);

        //Imprimir dados de cada cliente
        cliente1.imprimirCliente();
        cliente1.imprimirEnderecos();
        cliente1.imprimirContatos();
        contaCorrenteCliente1.imprimir(); //Conta corrente, então imprime também o saldo + cheque especial
        contaPagamentoCliente1.imprimir();

        cliente2.imprimirCliente();
        cliente2.imprimirEnderecos();
        cliente2.imprimirContatos();
        contaCliente2.imprimir(); //Conta poupança, só imprime o saldo


        System.out.println("\n\nInicio dos testes:\n");
        //Teste saque
        contaCorrenteCliente1.sacar(100);
        System.out.println("Saldo após saque: " + contaCorrenteCliente1.getSaldo());
        contaCorrenteCliente1.sacar(10000);
        contaCorrenteCliente1.sacar(-100);

        //Teste depósito
        contaCorrenteCliente1.depositar(12);
        System.out.println("Saldo após deposito: " + contaCorrenteCliente1.getSaldo());
        contaCorrenteCliente1.depositar(-12);

        System.out.println("Saldo do cliente 1 com cheque especial: " + contaCorrenteCliente1.retornarSaldoComChequeEspecial());

        //Teste de transferência
        System.out.println("Saldo na conta corrente do cliente 1: " + contaCorrenteCliente1.getSaldo());
        System.out.println("Saldo na conta poupança do cliente 2: " + contaCliente2.getSaldo());
        System.out.println("\"Cliente 1 transfere R$200 para cliente 2\"");
        contaCorrenteCliente1.transferir(contaCliente2, 200);
        System.out.println("Saldo na conta corrente cliente 1 após transferência: " + contaCorrenteCliente1.getSaldo());
        System.out.println("Saldo na conta poupança do cliente 2 após transferência: " + contaCliente2.getSaldo());

        System.out.println("Saldo na conta poupança do cliente 2: " + contaCliente2.getSaldo());
        System.out.println("Saldo na conta pagamento do cliente 1: " + contaPagamentoCliente1.getSaldo());
        System.out.println("\"Cliente 2 transfere R$200 para cliente 1\"");
        contaCliente2.transferir(contaPagamentoCliente1, 200);
        System.out.println("Saldo na conta poupança cliente 2 após transferência: " + contaCliente2.getSaldo());
        System.out.println("Saldo na conta pagamento do cliente 1 após transferência: " + contaPagamentoCliente1.getSaldo());

        System.out.println("Saldo na conta pagamento do cliente 1: " + contaPagamentoCliente1.getSaldo());
        System.out.println("Saldo na conta corrente do cliente 1: " + contaCorrenteCliente1.getSaldo());
        System.out.println("\"Cliente 1 transfere R$200 da pagamento para corrente\"");
        contaPagamentoCliente1.transferir(contaCorrenteCliente1, 100);
        System.out.println("Saldo na conta corrente cliente 1 após transferência: " + contaPagamentoCliente1.getSaldo());
        System.out.println("Saldo na conta poupança do cliente 2 após transferência: " + contaCorrenteCliente1.getSaldo());

        //Teste taxa de juros
        System.out.println("Saldo do cliente 2 antes dos juros: " + contaCliente2.getSaldo());
        contaCliente2.creditarTaxa();
        System.out.println("Saldo cliente 2 após juros aplicados: " + contaCliente2.getSaldo());

        //Teste sacar do limite em conta corrente e na conta poupança
        contaCorrenteCliente1.sacar(1000);
        System.out.println("Saldo cliente 1 após sacar do limite: " + contaCorrenteCliente1.getSaldo());
        contaCliente2.sacar(450);

        //Imprimir dados de cada cliente
        cliente1.imprimirCliente();
        cliente1.imprimirEnderecos();
        cliente1.imprimirContatos();
        contaCorrenteCliente1.imprimir(); //Conta corrente, então imprime também o saldo + cheque especial
        contaPagamentoCliente1.imprimir();

        cliente2.imprimirCliente();
        cliente2.imprimirEnderecos();
        cliente2.imprimirContatos();
        contaCliente2.imprimir(); //Conta poupança, só imprime o saldo

    }
}
