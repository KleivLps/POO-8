package EstacionAño;

import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n- - - MENU - - -");
            System.out.println("1. Mostrar estaciones y sus meses correspondientes.");
            System.out.println("2. Ingresar un número de mes para obtener la estacion del año.");
            System.out.println("3. Salir(Ingrese el núimero 0 para salir)");
            System.out.println("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            System.out.println(" ");

            switch (opcion) {
                case 1 -> EstacionDelAño.imprimirEstacion();
                case 2 -> {
                    System.out.println("Ingrese un número de mes (1 - 12): ");
                    int numeroMes = scanner.nextInt();
                    Mes mes = Mes.obtenerMesPorNumero(numeroMes);
                    if (mes != null) {
                        Estacion estacion = EstacionDelAño.obtenerEstacionPorMes(mes);
                        System.out.println("El mes " + mes.name() + " corresponde a la estacion: " +estacion);
                    }else {
                        System.out.println("Numero de mes invalido. Por favor, ingresa un numero entre 1 y 12. ");
                    }
                }
                case 0 -> {
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                }
                default -> System.out.println("Opcion invalida, por favor intente nuevamente.");
            }
        }
        scanner.close();
    }
}
