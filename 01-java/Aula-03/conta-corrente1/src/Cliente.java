public class Cliente {
    String nome,
            cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos()
    {
        contatos[0].imprimirContato();
        contatos[1].imprimirContato();
    }

    public void imprimirEnderecos()
    {
        enderecos[0].imprimirEndereco();
        enderecos[1].imprimirEndereco();
    }

    public void imprimirCliente()
    {
        System.out.printf("\nNome: %s\nCPF: %s\n", nome, cpf);
        imprimirContatos();
        imprimirEnderecos();
    }


}
