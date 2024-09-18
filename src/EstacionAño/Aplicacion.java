package EstacionAño;

public class Aplicacion {
    public static void main(String[] args) {
        for (Mes mes: Mes.values()) {
            EstacionDelAño.imprimirEstacion(mes);
        }

        Menu.mostrarMenu();
    }
}
