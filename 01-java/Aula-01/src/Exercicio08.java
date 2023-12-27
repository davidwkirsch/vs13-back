import java.util.Scanner;

public class Exercicio08 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o salário atual: ");
        double salarioAntigo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o cargo: ");
        String cargo = sc.nextLine().toLowerCase();

        double salarioNovo = switch (cargo) {
            case "gerente" -> salarioAntigo * 1.1;
            case "engenheiro" -> salarioAntigo * 1.2;
            case "tecnico" -> salarioAntigo * 1.3;
            default -> salarioAntigo * 1.4;
        };

        System.out.println("Salário antigo: R$" + salarioAntigo);
        System.out.println("Salário novo: R$" + salarioNovo);
        System.out.println("Diferença: R$" + (salarioNovo - salarioAntigo));
    }
}
