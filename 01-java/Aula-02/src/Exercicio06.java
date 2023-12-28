import java.util.Scanner;

public class Exercicio06
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] meusNumeros = {1,1,1,1,5,5,8,8,8,8};
        int numeroDeVezesNoVetor = 0;
        int numerosMenores = 0;
        int numerosMaiores = 0;

        System.out.print("Digite um número: ");
        int numeroUsuario = sc.nextInt();


        for (int i = 0; i < 10; i++)
        {
            if(numeroUsuario == meusNumeros[i])
            {
                numeroDeVezesNoVetor++;
            }
            if (numeroUsuario > meusNumeros[i])
            {
                numerosMenores++;
            }
            if (numeroUsuario < meusNumeros[i])
            {
                numerosMaiores++;
            }
        }
        System.out.printf("\nNúmero de vezes que o seu número está no meu vetor: %d", numeroDeVezesNoVetor);
        System.out.printf("\nQuantidade de números menores: %d", numerosMenores);
        System.out.printf("\nQuantidade de números maiores: %d", numerosMaiores);

    }
}
