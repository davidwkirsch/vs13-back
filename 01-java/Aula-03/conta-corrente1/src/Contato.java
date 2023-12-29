public class Contato {
    String descricao,
    telefone;
    int tipo;

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
}
