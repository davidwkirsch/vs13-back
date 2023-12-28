import java.util.Scanner;

public class Exercicio05
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        double[][] precoItens = new double[10][3];


        for (int i = 0; i < 10; i++)
        {
            System.out.printf("Insira os preços do %dº produto: \n", i+1);
            for (int j = 0; j < 3; j++)
            {
                System.out.printf("Preços no %dº mercado: R$", j+1);
                precoItens[i][j] = sc.nextDouble();
            }
        }

        double totalMercadoUm = 0,
                totalMercadoDois = 0,
                totalMercadoTres = 0;

        for (int i = 0; i < 10; i++)
        {
            totalMercadoUm += precoItens[i][0];
            totalMercadoDois += precoItens[i][1];
            totalMercadoTres += precoItens[i][2];
        }



        if (totalMercadoUm < totalMercadoDois && totalMercadoUm < totalMercadoTres)
        {
            System.out.println("O primeiro mercado é o mais barato!");
        }
        else if (totalMercadoDois < totalMercadoUm && totalMercadoDois < totalMercadoTres)
        {
            System.out.println("O segundo mercado é o mais barato!");
        }
        else if (totalMercadoTres < totalMercadoDois && totalMercadoTres < totalMercadoUm)
        {
            System.out.println("O terceiro mercado é o mais barato!");
        }
        else
        {
            System.out.println("Há dois ou três mercados com o mesmo valor mais baixo: ");
            System.out.println("Total do primeiro mercado: RS" + totalMercadoUm);
            System.out.println("Total do segundo mercado: RS" + totalMercadoDois);
            System.out.println("Total do terceiro mercado: RS" + totalMercadoTres);
        }


    }
}
