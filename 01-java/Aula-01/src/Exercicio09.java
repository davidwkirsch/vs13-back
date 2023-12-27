import java.util.Scanner;

public class Exercicio09 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o horário de início do jogo, digitando inicialmente as horas e depois os minutos!");
        System.out.print("Horas: ");
        int horaInicio = sc.nextInt();
        System.out.print("Minutos: ");
        int minutoInicio = sc.nextInt();

        System.out.println("Digite o horário de término do jogo, digitando inicialmente as horas e depois os minutos!");
        System.out.print("Horas: ");
        int horaTermino = sc.nextInt();
        System.out.print("Minutos: ");
        int minutoTermino = sc.nextInt();

        if (horaTermino < horaInicio)
        {
            horaTermino += 24;
        }

        int totalHorasEmMinutos = (horaTermino - horaInicio) * 60;
        int totalMinutos = minutoTermino - minutoInicio;
        int tempoTotal = totalHorasEmMinutos + totalMinutos;

        int duracaoHoras = tempoTotal / 60;
        int duracaoMinutos = tempoTotal % 60;

        if (duracaoHoras == 0 && duracaoMinutos == 00)
        {
            System.out.println("O jogo acabou assim que começou ou teve duração de 24 horas.");
        }
        else
        {
            System.out.println("O jogo durou " + duracaoHoras + "h" + duracaoMinutos + "min");
        }



    }
}
