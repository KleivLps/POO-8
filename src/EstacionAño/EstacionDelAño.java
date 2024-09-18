package EstacionAño;

public class EstacionDelAño {

    public static Estacion obtenerEstacionPorMes(Mes mes) {
        return switch (mes) {
            case DICIEMBRE, ENERO, FEBRERO ->Estacion.INVIERNO;
            case MARZO, ABRIL, MAYO -> Estacion.PRIMAVERA;
            case JUNIO, JULIO, AGOSTO -> Estacion.VERANO;
            case SEPTIEMBRE, OCTUBRE, NOVIEMBRE -> Estacion.OTOÑO;
        };
    }

    public static void imprimirEstacion(Mes mes) {
        Estacion estacion = obtenerEstacionPorMes(mes);
        System.out.println("El mes de " +mes.name() + " pertenece a la estacion " +estacion.name());
    }

    public static void imprimirEstacion() {
        System.out.println("Primavera: Marzo, abril, Mayo.");
        System.out.println("Verano: Junio, Julio, Agosto.");
        System.out.println("Otoño: Septiembre, Octubre, Noviembre.");
        System.out.println("Invierno: Diciembre, Enero, Febrero.");
    }
}
