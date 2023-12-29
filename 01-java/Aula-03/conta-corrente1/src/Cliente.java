public class Cliente {
    String nome,
            cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos()
    {
        if (this.contatos[0] != null) {
            this.contatos[0].imprimirContato();
        }
        if (this.contatos[1] != null) {
            this.contatos[1].imprimirContato();
        }
    }

    public void imprimirEnderecos()
    {
            if (this.enderecos[0] != null) {
                this.enderecos[0].imprimirEndereco();
            }
            if (this.enderecos[1] != null) {
                this.enderecos[1].imprimirEndereco();
            }
    }

    public void imprimirCliente()
    {
        System.out.printf("\n\n\nNome: %s\nCPF: %s\n", nome, cpf);
    }


}
