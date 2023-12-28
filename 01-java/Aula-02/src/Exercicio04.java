import java.util.Scanner;

public class Exercicio04
{
    public static void main(String[] args)
    {
        int QUANTIDADE_LINHAS = 5;
        int QUANTIDADE_COLUNAS = 4;

        int[][] matriz = new int[QUANTIDADE_LINHAS][QUANTIDADE_COLUNAS];
        double somaNotasFinais = 0;
        int maiorNotaFinal = 0,
        matriculaMaiorNota = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < QUANTIDADE_LINHAS; i++)
        {
            System.out.printf("\nInforme o número de matricula do %dº aluno: ", i+1);
            matriz[i][0] = sc.nextInt();
            System.out.println("Informe a média das provas: ");
            matriz[i][1] = (int) sc.nextDouble();
            System.out.println("Informe a media dos trabalhos: ");
            matriz[i][2] = (int) sc.nextDouble();

            matriz[i][3] = (int) ((matriz[i][1] * 0.6) + (matriz[i][2] * 0.4));

            somaNotasFinais += matriz[i][3];

            if (matriz[i][3] > maiorNotaFinal)
            {
                maiorNotaFinal = matriz[i][3];
                matriculaMaiorNota = matriz[i][0];
            }
        }

        double mediaNotasFinais = somaNotasFinais / QUANTIDADE_LINHAS;

        for (int i = 0; i < QUANTIDADE_LINHAS; i++)
        {
            System.out.printf("\nMatricula do %dº aluno: %d", i+1, matriz[i][0]);
            System.out.printf("\nMédia das provas: %d", matriz[i][1]);
            System.out.printf("\nMédia dos trabalhos: %d\n", matriz[i][2]);
        }

        System.out.printf("\n\nMatricula da maior nota final: %d", matriculaMaiorNota);
        System.out.printf("\nMédia das notas finais: %.2f", mediaNotasFinais);

    }
}
