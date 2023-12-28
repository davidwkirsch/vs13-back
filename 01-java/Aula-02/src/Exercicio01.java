import java.util.Scanner;

public class Exercicio01
{
    public static void main(String[] args)
    {
        double desconto = 0.95;

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = sc.next();
        System.out.print("Digite o valor do produto: ");
        double valorProduto = sc.nextDouble();

        System.out.printf("Produto: %s", nomeProduto);
        System.out.printf("\nPreço: R$%.2f", valorProduto);
        System.out.printf("\nPromoção: %s", nomeProduto);
        System.out.printf("\n-------------------------");

        for (int i = 1; i <= 10; i++)
        {
            double valorDescontado = valorProduto * desconto;
            double valorTotal = valorDescontado * i;
            System.out.printf("\n%d X R$%.2f = R$%.2f", i, valorDescontado, valorTotal);
            desconto -= 0.05;
        }
    }
}
