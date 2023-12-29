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
            System.out.printf("\nEndereço residencial: %s, Nº %d, %s, %s - %s, %s - %s",
                    logradouro, numero, complemento, cidade, cep, estado, pais);
        }
        else
        {
            System.out.printf("\nEndereço comercial: %s, Nº %d, %s, %s - %s, %s - %s",
                    logradouro, numero, complemento, cidade, cep, estado, pais);
        }
    }
}
