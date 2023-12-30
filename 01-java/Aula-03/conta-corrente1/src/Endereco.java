public class Endereco {
    int tipo,
            numero;
    String logradouro,
            complemento = "",
            cep,
            cidade,
            estado,
            pais;
    public Endereco() {}
    public Endereco(int tipo, int numero, String logradouro, String cidade, String estado, String pais) {}

    public void imprimirEndereco()
    {
        if (this.tipo != 1 && this.tipo != 2)
        {
            System.out.print("");
        }
        else if (this.tipo == 1)
        {
            System.out.printf("\nEndereço residencial: %s, Nº %d, %s, %s - %s, %s - %s",
                    logradouro, numero, complemento, cidade, cep, estado, pais);
        }
        else
        {
            System.out.printf("\nEndereço comercial: %s, Nº %d, %s, %s - %s, %s - %s",
                    logradouro, numero, complemento, cidade, cep, estado, pais);
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
