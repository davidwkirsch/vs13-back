import java.util.Scanner;

public class Exercicio05
{
    public static void main(String[] args)
    {
        double[][] precoItens = {
                {10.0, 20.0, 30.0},
                {25.0, 15.0, 35.0},
                {30.0, 10.0, 25.0},
                {15.0, 30.0, 20.0},
                {20.0, 250.0, 15.0},
                {35.0, 58.0, 30.0},
                {5.0, 35.0, 10.0},
                {30.0, 15.0, 25.0},
                {10.0, 30.0, 25.0},
                {25.0, 20.0, 55.0}
        };
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
