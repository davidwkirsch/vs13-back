public class Contato {
    String descricao,
    telefone;
    int tipo;

    public void imprimirContato()
    {
        if (tipo == 1)
        {
            System.out.printf("Contato residencial: %s", telefone);
        }
        else
        {
            System.out.printf("Contato comercial: %s", telefone);
        }
    }
}
