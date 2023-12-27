import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha um estado (digite o número): ");
        System.out.println("1 - Rio Grande do Sul");
        System.out.println("2 - Paraíba");
        System.out.println("3 - Pernambuco");

        int estado = sc.nextInt();

        switch (estado)
        {
            case 0:
                System.out.println("Escolha uma cidade agora: ");
            case 1:
                System.out.println("1 - Ivoti");
                System.out.println("2 - Torres");
                break;
            case 2:
                System.out.println("3 - João Pessoa");
                System.out.println("4 - Bananeiras");
                break;
            case 3:
                System.out.println("5 - Recife");
                System.out.println("6 - Bonito");
                break;
            default:
                System.out.println("Número inválido!");
                break;
        }

        int cidade = sc.nextInt();

        switch (cidade)
        {
            case 1:
                System.out.println("Cidade: Ivoti - RS\n" +
                        "População: 25.068\n" +
                        "IDH: 0,784\n" +
                        "Principal festa: Festa do Colono");
                break;
            case 2:
                System.out.println("Cidade: Torres - RS\n" +
                        "População: 39.381\n" +
                        "IDH: 0,762\n" +
                        "Principal festa: Motobeach");
                break;
            case 3:
                System.out.println("Cidade: João Pessoa - PB\n" +
                        "População: 833.932\n" +
                        "IDH: 0,763\n" +
                        "Principal festa: Carnaval");
                break;
            case 4:
                System.out.println("Cidade: Bananeiras - PB\n" +
                        "População: 23.134\n" +
                        "IDH: 0,599\n" +
                        "Principal festa: São João");
                break;
            case 5:
                System.out.println("Cidade: Recife - PE\n" +
                        "População: 1.488.920 \n" +
                        "IDH: 0,772\n" +
                        "Principal festa: Maracatu Nação");
                break;
            case 6:
                System.out.println("Cidade: Bonito - PE\n" +
                        "População: 38.069\n" +
                        "IDH: 0,591\n" +
                        "Principal festa: Festival de Inverno de Bonito");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
