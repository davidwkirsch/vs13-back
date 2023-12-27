import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de identificação do aluno: ");
        int identificacao = sc.nextInt();
        System.out.print("Digite a Nota 1: ");
        double nota1 = sc.nextDouble();
        System.out.print("Digite a Nota 2: ");
        double nota2 = sc.nextDouble();
        System.out.print("Digite a Nota 3: ");
        double nota3 = sc.nextDouble();
        System.out.print("Digite a média dos exercícios: ");
        double mediaExercicios = sc.nextDouble();

        double mediaAproveitamento = (nota1 + (nota2 * 2) + (nota3 * 3) + mediaExercicios) / 7;

        char conceito;

        if (mediaAproveitamento >= 9)
        {
            conceito = 'A';
        }
        else if (mediaAproveitamento >= 7.5)
        {
            conceito = 'B';
        }
        else if (mediaAproveitamento >= 6)
        {
            conceito = 'C';
        }
        else if (mediaAproveitamento >= 4)
        {
            conceito = 'D';
        }
        else
        {
            conceito = 'E';
        }

        System.out.println("Número de identificação: " + identificacao);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.println("Média dos exercícios: " + mediaExercicios);
        System.out.println("Média de aproveitamento: " + mediaAproveitamento);
        System.out.println("Conceito: " + conceito);

        if (conceito == 'A' || conceito == 'B' || conceito == 'C')
        {
            System.out.println("APROVADO");
        }
        else {
            System.out.println("REPROVADO");
        }


    }
}
