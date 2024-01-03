import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome,
            cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente() {}
    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos)
    {
        this.nome = nome;
        this.cpf = cpf;
        for (Contato contato : contatos)
        {
            if (contato != null)  {this.contatos.add(contato);}
        }
        for (Endereco endereco : enderecos)
        {
            if (endereco != null)  {this.enderecos.add(endereco);}
        }
    }

    public void imprimirContatos()
    {
        for (Contato cont : contatos) {
        cont.imprimirContato();
        }
    }

    public void imprimirEnderecos()
    {
        for (Endereco end : enderecos) {
            end.imprimirEndereco();
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
