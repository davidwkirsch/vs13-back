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
        ContaCorrente contaCliente1 = new ContaCorrente("123456", 1234, cliente1, 300);
        ContaPoupanca contaCliente2 = new ContaPoupanca("333666", 1034, cliente2);

        //Contas iniciam zeradas, então é feito um depósito inicial em cada uma
        contaCliente1.depositar(1000);
        contaCliente2.depositar(200);

        //Imprimir dados de cada cliente
        cliente1.imprimirCliente();
        cliente1.imprimirEnderecos();
        cliente1.imprimirContatos();
        contaCliente1.imprimir(); //Conta corrente, então imprime também o saldo + cheque especial

        cliente2.imprimirCliente();
        cliente2.imprimirEnderecos();
        cliente2.imprimirContatos();
        contaCliente2.imprimir(); //Conta poupança, só imprime o saldo


        System.out.println("\n\nInicio dos testes:\n");
        //Teste saque
        contaCliente1.sacar(100);
        System.out.println("Saldo após saque: " + contaCliente1.getSaldo());
        contaCliente1.sacar(10000);
        contaCliente1.sacar(-100);

        //Teste depósito
        contaCliente1.depositar(12);
        System.out.println("Saldo após deposito: " + contaCliente1.getSaldo());
        contaCliente1.depositar(-12);

        System.out.println("Saldo do cliente 1 com cheque especial: " + contaCliente1.retornarSaldoComChequeEspecial());

        //Teste de transferência
        System.out.println("Saldo cliente 1: " + contaCliente1.getSaldo());
        System.out.println("Saldo cliente 2: " + contaCliente2.getSaldo());
        contaCliente1.transferir(contaCliente2, 1200);
        System.out.println("Saldo cliente 1 após transferência: " + contaCliente1.getSaldo());
        System.out.println("Saldo cliente 2 após transferência: " + contaCliente2.getSaldo());
        contaCliente1.depositar(1200);

        //Teste taxa de juros
        System.out.println("Saldo do cliente 2 antes dos juros: " + contaCliente2.getSaldo());
        contaCliente2.creditarTaxa();
        System.out.println("Saldo cliente 2 após juros aplicados: " + contaCliente2.getSaldo());

        //Teste sacar do limite em conta corrente e na conta poupança
        contaCliente1.sacar(1000);
        System.out.println("Saldo cliente 1 após sacar do limite: " + contaCliente1.getSaldo());
        contaCliente2.sacar(450);

        //Imprimir dados de cada cliente
        cliente1.imprimirCliente();
        cliente1.imprimirEnderecos();
        cliente1.imprimirContatos();
        contaCliente1.imprimir(); //Conta corrente, então imprime também o saldo + cheque especial

        cliente2.imprimirCliente();
        cliente2.imprimirEnderecos();
        cliente2.imprimirContatos();
        contaCliente2.imprimir(); //Conta poupança, só imprime o saldo

    }
}
