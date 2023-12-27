import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite sua cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Digite seu estado: ");
        String estado = sc.nextLine();

        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade +
                ", situada no estado de " + estado + ".");
    }
}
