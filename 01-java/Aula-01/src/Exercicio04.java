public class Exercicio04 {

    public static void main(String[] args)
    {
        int A = 10;
        int B = 20;
        int temp;

        System.out.println("A antes da conversão: " + A);
        System.out.println("B antes da conversão: " + B);

        temp = B;
        B = A;
        A = temp;
        System.out.println("A após a conversão: " + A);
        System.out.println("B após a conversão: " + B);
    }
}
