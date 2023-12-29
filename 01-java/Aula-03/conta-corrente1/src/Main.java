public class Main {
    public static void main(String[] args)
    {

        Endereco endereco1Cliente1 = new Endereco();
        endereco1Cliente1.tipo = 1;
        endereco1Cliente1.logradouro = "R. Bananeira";
        endereco1Cliente1.numero = 1000;
        endereco1Cliente1.complemento = "ap. 202";
        endereco1Cliente1.cidade = "Ivoti";
        endereco1Cliente1.cep = "93900-000";
        endereco1Cliente1.estado = "RS";
        endereco1Cliente1.pais = "Brasil";

        Endereco endereco2Cliente1 = new Endereco();
        endereco2Cliente1.tipo = 2;
        endereco2Cliente1.logradouro = "R. Macieira";
        endereco2Cliente1.numero = 2000;
        endereco2Cliente1.cidade = "Porto Alegre";
        endereco2Cliente1.cep = "95000000";
        endereco2Cliente1.estado = "RS";
        endereco2Cliente1.pais = "Brasil";

        Endereco endereco1Cliente2 = new Endereco();
        endereco1Cliente2.tipo = 1;
        endereco1Cliente2.logradouro = "Av. Nemaquinemla";
        endereco1Cliente2.numero = 2222;
        endereco1Cliente2.complemento = "Casa de rico";
        endereco1Cliente2.cidade = "São Paulo";
        endereco1Cliente2.cep = "45800.600";
        endereco1Cliente2.estado = "SP";
        endereco1Cliente2.pais = "Brasil";

        Contato contato1Cliente1 = new Contato();
        contato1Cliente1.tipo = 1;
        contato1Cliente1.descricao = "celular";
        contato1Cliente1.telefone = "(51) 980805050";

        Contato contato1Cliente2 = new Contato();
        contato1Cliente2.tipo = 1;
        contato1Cliente2.descricao = "Whats";
        contato1Cliente2.telefone = "985214752";

        Contato contato2Cliente2 = new Contato();
        contato2Cliente2.tipo = 2;
        contato2Cliente2.descricao = "Cel Empresa";
        contato2Cliente2.telefone = "51 3030-8020";

        Cliente cliente1 = new Cliente();
        cliente1.nome = "David Kirsch";
        cliente1.cpf = "123.456.789-00";
        cliente1.contatos[0] = contato1Cliente1;
        cliente1.enderecos[0] = endereco1Cliente1;
        cliente1.enderecos[1] = endereco2Cliente1;

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Lucas Brasil";
        cliente2.cpf = "85465485813";
        cliente2.contatos[0] = contato1Cliente2;
        cliente2.contatos[1] = contato2Cliente2;
        cliente2.enderecos[0] = endereco1Cliente2;

        ContaCorrente contaCliente1 = new ContaCorrente();
        contaCliente1.cliente = cliente1;
        contaCliente1.numeroConta = "123456";
        contaCliente1.agencia = 1234;
        contaCliente1.saldo = 1000.0;

        ContaCorrente contaCliente2 = new ContaCorrente();
        contaCliente2.cliente = cliente2;
        contaCliente2.numeroConta = "333666";
        contaCliente2.agencia = 1034;
        contaCliente2.saldo = 200.0;

        //Imprimir dados de cada cliente
        contaCliente1.cliente.imprimirCliente();
        contaCliente1.cliente.imprimirEnderecos();
        contaCliente1.cliente.imprimirContatos();
        contaCliente1.imprimirContaCorrente();

        contaCliente2.cliente.imprimirCliente();
        contaCliente2.cliente.imprimirEnderecos();
        contaCliente2.cliente.imprimirContatos();
        contaCliente2.imprimirContaCorrente();

        contaCliente1.sacar(100);
        System.out.println("Saldo: " + contaCliente1.saldo);
        contaCliente1.sacar(10000);
        contaCliente1.sacar(-100);

        contaCliente1.depositar(12);
        System.out.println("Saldo: " + contaCliente1.saldo);
        contaCliente1.depositar(-12);

        System.out.println("Saldo conta 1 com cheque especial: "+ contaCliente1.retornarSaldoComChequeEspecial());

        System.out.println("Saldo cliente 1: " + contaCliente1.saldo);
        System.out.println("Saldo cliente 2: " + contaCliente2.saldo);
        contaCliente1.transferir(contaCliente2, 200);
        System.out.println("Saldo cliente 1 após transferência: " + contaCliente1.saldo);
        System.out.println("Saldo cliente 2 após transferência: " + contaCliente2.saldo);

        //Imprimir dados de cada cliente
        contaCliente1.cliente.imprimirCliente();
        contaCliente1.cliente.imprimirEnderecos();
        contaCliente1.cliente.imprimirContatos();
        contaCliente1.imprimirContaCorrente();

        contaCliente2.cliente.imprimirCliente();
        contaCliente2.cliente.imprimirEnderecos();
        contaCliente2.cliente.imprimirContatos();
        contaCliente2.imprimirContaCorrente();

    }
}
