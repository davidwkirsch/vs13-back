import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra para traduzir: ");
        String palavra = sc.nextLine().toLowerCase();

        switch (palavra) {
            case "cachorro" -> System.out.println("\"Cachorro\" em inglês é: Dog");
            case "tempo" -> System.out.println("\"Tempo\" em inglês é: Time");
            case "amor" -> System.out.println("\"Amor\" em inglês é: Love");
            case "cidade" -> System.out.println("\"Cidade\" em inglês é: City");
            case "feliz" -> System.out.println("\"Feliz\" em inglês é: Happy");
            case "triste" -> System.out.println("\"Triste\" em inglês é: Sad");
            case "poderia" -> System.out.println("\"Poderia\" em inglês é: Could");
            case "deveria" -> System.out.println("\"Deveria\" em inglês é: Should");
            case "dog" -> System.out.println("\"Dog\" em português é: Cachorro");
            case "time" -> System.out.println("\"Time\" em português é: Tempo");
            case "love" -> System.out.println("\"Love\" em português é: Amor");
            case "city" -> System.out.println("\"City\" em português é: Cidade");
            case "happy" -> System.out.println("\"Happy\" em português é: Feliz");
            case "sad" -> System.out.println("\"Sad\" em português é: Triste");
            case "should" -> System.out.println("\"Should\" em português é: Deveria");
            case "could" -> System.out.println("\"Could\" em português é: Poderia");
            default -> System.out.println("Essa palavra não é válida.");
        }
    }
}
