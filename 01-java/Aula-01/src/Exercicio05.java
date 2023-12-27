import java.util.Scanner;

public class Exercicio05 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a base do retângulo: ");
        int base = sc.nextInt();
        System.out.print("Digite a altura do retângulo: ");
        int altura = sc.nextInt();

        int area = base * altura;
        System.out.println("\nÁrea do retângulo: " + area);
    }
}
