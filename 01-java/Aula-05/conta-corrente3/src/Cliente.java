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
        this.contatos.add(contatos[0]);
        if (contatos[1] != null)  {this.contatos.add(contatos[1]);}
        this.enderecos.add(enderecos[0]);
        if (enderecos[1] != null) {this.enderecos.add(enderecos[1]);}
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
