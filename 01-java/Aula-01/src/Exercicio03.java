import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma palavra para traduzir:");
        String palavra = sc.nextLine().toLowerCase();

        if(palavra.equals("cachorro"))
        {
            System.out.println("Cachorro em inglês é: Dog");
        }
        else if(palavra.equals("tempo"))
        {
            System.out.println("Tempo em inglês é: Time");
        }
        else if(palavra.equals("amor"))
        {
            System.out.println("Amor em inglês é: Love");
        }
        else if(palavra.equals("cidade"))
        {
            System.out.println("Cidade em inglês é: City");
        }
        else if(palavra.equals("feliz"))
        {
            System.out.println("Feliz em inglês é: Happy");
        }
        else if(palavra.equals("triste"))
        {
            System.out.println("Triste em inglês é: Sad");
        }
        else if(palavra.equals("poderia"))
        {
            System.out.println("Poderia em inglês é: Could");
        }
        else if(palavra.equals("deveria"))
        {
            System.out.println("Deveria em inglês é: Should");
        }
        else if(palavra.equals("dog"))
        {
            System.out.println("Dog em português é: Cachorro");
        }
        else if(palavra.equals("time"))
        {
            System.out.println("Time em português é: Tempo");
        }
        else if(palavra.equals("love"))
        {
            System.out.println("Love em português é: Amor");
        }
        else if(palavra.equals("city"))
        {
            System.out.println("City em português é: Cidade");
        }
        else if(palavra.equals("happy"))
        {
            System.out.println("Happy em português é: Feliz");
        }
        else if(palavra.equals("sad"))
        {
            System.out.println("Sad em português é: Triste");
        }
        else if(palavra.equals("should"))
        {
            System.out.println("Should em português é: Deveria");
        }
        else if(palavra.equals("could"))
        {
            System.out.println("Could em português é: Poderia");
        }
        else
        {
            System.out.println("Essa palavra não é válida.");
        }


    }
}
