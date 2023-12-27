import java.util.Scanner;

public class Exercicio06 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o total de eleitores: ");
        double totalEleitores = sc.nextDouble();

        System.out.print("Digite o total de votos brancos: ");
        double totalBrancos = sc.nextDouble();

        System.out.print("Digite o total de nulos: ");
        double totalNulos = sc.nextDouble();

        System.out.print("Digite o total de válidos: ");
        double totalValidos = sc.nextDouble();

        double percentualBrancos = totalBrancos / totalEleitores * 100;
        double percentualNulos = totalNulos / totalEleitores * 100;
        double percentualValidos = totalValidos / totalEleitores * 100;

        System.out.println("Total de eleitores: " + totalEleitores);
        System.out.println("Percentual de votos brancos: " + percentualBrancos + "%");
        System.out.println("Percentual de votos nulos: " + percentualNulos + "%");
        System.out.println("Percentual de votos válidos: " + percentualValidos + "%");
    }
}
