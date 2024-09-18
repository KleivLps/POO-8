import java.util.Random;
import java.util.Scanner;

public class Aplicacion {
   public static Scanner scanner =  new Scanner(System
           .in);

    public static void main(String[] args) {
        Color();
    }
    public static void DiasDeLaSemana() {
        System.out.println("Dias de la semana");
        DiaSemana[] dias = new DiaSemana[10];
        Random random = new Random();

        for (int i = 0; i < dias.length; i++) {
            int indiceAleatorio = random.nextInt(DiaSemana.values().length);
            dias[i] = DiaSemana.values()[indiceAleatorio];
        }

        for (DiaSemana dia : dias) {
            imprimirDiaLaboral(dia);
        }
    }

    public static void imprimirDiaLaboral(DiaSemana dia ) {
        String mensaje = dia.esDiaLaboral() ? "Dia laboral" : "No es dia laboral";
        System.out.println(dia.name() + "; " +mensaje);
    }

    public static void Color() {
        String[] coloresHexandecimales = new String[5];

        System.out.println("Ingrese 5 valores hexadecimales para verificar si son colores primarios: ");

        for (int i = 0; i < coloresHexandecimales.length; i++) {
            System.out.println("Color" +(i+1) + ": ");
            coloresHexandecimales[i] = scanner.nextLine();
        }

        for (String valorHex: coloresHexandecimales) {
            Color color = ConvertidorColor.convertitHexadecimal(valorHex);

            if (color != null) {
                System.out.println(valorHex + " es el color primario: " + color.name());
            } else {
                System.out.println(valorHex + " No es un color primario.");
            }
        }
    }
}