import java.util.Scanner;

public class Exercicio07 {

    public static void main(String[] args)
    {
        double precoTotal = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o código do produto: ");
        String codigo = sc.nextLine().toLowerCase();
        System.out.print("Digite a quantidade comprada: ");
        double quantidadeComprada = sc.nextDouble();

        switch  (codigo)
        {
            case "abcd":
                precoTotal = quantidadeComprada * 5.3;
                System.out.println("Preço total: " + precoTotal);
                break;
            case "xypk":
                precoTotal = quantidadeComprada * 6;
                System.out.println("Preço total: " + precoTotal);
                break;
            case "klmp":
                precoTotal = quantidadeComprada * 3.2;
                System.out.println("Preço total: " + precoTotal);
                break;
            case "qrst":
                precoTotal = quantidadeComprada * 2.5;
                System.out.println("Preço total: " + precoTotal);
                break;
            default:
                System.out.println("Código inválido!");
                break;
        }
    }
}
