public class Contato {
    private String descricao,
    telefone;
    private int tipo;

    public Contato() {}
    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    public void imprimirContato()
    {
        if (tipo != 1 && tipo != 2)
        {
            System.out.print("");
        }
        else if (tipo == 1)
        {
            System.out.printf("\nContato residencial: %s", telefone);
        }
        else
        {
            System.out.printf("\nContato comercial: %s", telefone);
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
