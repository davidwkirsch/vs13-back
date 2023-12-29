public class Endereco {
    int tipo,
            numero;
    String logradouro,
            complemento,
            cep,
            cidade,
            estado,
            pais;

    public void imprimirEndereco()
    {
        if (tipo == 1)
        {
            System.out.printf("\n");
        }
        else
        {
            System.out.println("\n");
        }
    }
}
