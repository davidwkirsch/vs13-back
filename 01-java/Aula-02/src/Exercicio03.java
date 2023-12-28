import java.util.Scanner;

public class Exercicio03
{
    public static void main(String[] args)
    {
        String nomeJogador = "";
        int quantidadeJogadores = 0,
                idadeJogadorMaisVelho = 0,
                idadeJogador = 0;
        double alturaJogador = 0,
                alturaJogadorMaisAlto = 0,
                pesoJogador = 0,
                pesoJogadorMaisPesado = 0,
                mediaAlturas = 0;

        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.printf("\nNome do %dº jogador: ", quantidadeJogadores+1);
            nomeJogador = sc.next();

            if (!nomeJogador.equalsIgnoreCase("sair"))
            {
                quantidadeJogadores++;
            }
            else
            {
                break;
            }

            System.out.print("Altura do jogador: ");
            alturaJogador = sc.nextDouble();
            System.out.print("Idade do jogador: ");
            idadeJogador = sc.nextInt();
            System.out.print("Peso do jogador: ");
            pesoJogador = sc.nextDouble();

            mediaAlturas += alturaJogador;

            if (alturaJogador > alturaJogadorMaisAlto)
            {
                alturaJogadorMaisAlto = alturaJogador;
            }
            if (pesoJogador > pesoJogadorMaisPesado)
            {
                pesoJogadorMaisPesado = pesoJogador;
            }
            if (idadeJogador > idadeJogadorMaisVelho)
            {
                idadeJogadorMaisVelho = idadeJogador;
            }
        } while (true);

        System.out.printf("\nQuantidade de jogadores cadastrados: %d", quantidadeJogadores);
        System.out.printf("\nAltura do maior jogador: %.2f", alturaJogadorMaisAlto);
        System.out.printf("\nJogador mais velho: %d", idadeJogadorMaisVelho);
        System.out.printf("\nJogador mais pesado: %.2f", pesoJogadorMaisPesado);
        System.out.printf("\nMedia de altura dos jogadores: %.2f", (mediaAlturas / quantidadeJogadores));
    }
}
