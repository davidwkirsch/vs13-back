import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args)
    {
        int meuNumero = 8;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Escolha um número de 1 a 10: ");
            int numeroEscolhido = sc.nextInt();
            if (numeroEscolhido == meuNumero)
            {
                System.out.println("Parabéns, você acertou!");
                break;
            }
            else if (numeroEscolhido < meuNumero)
            {
                System.out.println("Errou! O número a ser encontrado é maior do que você digitou.");
            }
            else
            {
                System.out.println("Errou! O número a ser encontrado é menor do que você digitou.");
            }
        }
    }
}
