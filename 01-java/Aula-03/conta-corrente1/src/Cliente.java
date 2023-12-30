public class Cliente {
    String nome,
            cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public Cliente() {
    }
    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
}
