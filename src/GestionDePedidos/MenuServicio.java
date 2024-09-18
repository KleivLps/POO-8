package GestionDePedidos;

import java.util.List;
import java.util.Scanner;

public class MenuServicio {
    private final PedidoServicio pedidoServicio;
    private final Scanner scanner;

    public MenuServicio() {
        this.pedidoServicio = new PedidoServicio();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n - - - MENU DE GESTION DE PEDIDOS - - - ");
            System.out.println("1. Crear nuevo pedido.");
            System.out.println("2. Actualizar estado de pedido.");
            System.out.println("3. Buscar pedidos por estado.");
            System.out.println("4. Mostrar lista de pedidos.");
            System.out.println("5. Salir.");
            System.out.println("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearNuevoPedido();
                case 2 -> actualizarEstadoPedido();
                case 3 -> buscarPedidosPorEstado();
                case 4 -> mostrarListaDePedidos();
                case 5 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
    }

    private void crearNuevoPedido() {

        System.out.println("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.println("Ingrese la lista de productos (separados por comas): ");
        String[] listaDeProductos = scanner.nextLine().split(", ");

        Pedido nuevoPedido = pedidoServicio.crearPedido(cliente, listaDeProductos);
        System.out.println("Pedido creado exitosamente: " +nuevoPedido);
    }

    private void actualizarEstadoPedido() {
        System.out.println("Ingrese el numero de pedido: ");
        int numeroDePedido = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n - - - Selecciona el nuevo estado: - - - ");
        System.out.println("1. Pendiente.");
        System.out.println("2. Enviado");
        System.out.println("3. Entregado");
        int estadoOpcion = scanner.nextInt();
        scanner.nextLine();

        EstadoPedido nuevoEstado;
        switch (estadoOpcion) {
            case 1 -> nuevoEstado = EstadoPedido.PENDIENTE;
            case 2 -> nuevoEstado = EstadoPedido.ENVIADO;
            case 3 -> nuevoEstado = EstadoPedido.ENTREGADO;
            default -> {
                System.out.println("Opcion invalida. No se actualizo el estado. ");
                return;
            }
        }

        boolean actualizado = pedidoServicio.actualizarEstadoPedido(numeroDePedido, nuevoEstado);
        if (actualizado) {
            System.out.println("Estado del pedido actualizado exitosamente.");
        } else {
            System.out.println("No se encontro un pedido con ese numero.");
        }
    }

    private void buscarPedidosPorEstado() {
        System.out.println("Seleccione el estado a buscar: ");
        System.out.println("1. Pendiente.");
        System.out.println("2. Enviado.");
        System.out.println("3. Entregado.");
        int estadoOpcion = scanner.nextInt();
        scanner.nextLine();

        EstadoPedido estadoBuscado;
        switch (estadoOpcion) {
            case 1 -> estadoBuscado = EstadoPedido.PENDIENTE;
            case 2 -> estadoBuscado = EstadoPedido.ENVIADO;
            case 3 -> estadoBuscado = EstadoPedido.ENTREGADO;
            default -> {
                System.out.println("opcion invalida.");
                return;
            }
        }
        List<Pedido> pedidos = pedidoServicio.buscarPedidosPorEstado(estadoBuscado);
        if (pedidos.isEmpty()) {
            System.out.println("No se encontraron pedidos con el estado seleccionado. ");
        } else {
            pedidos.forEach(System.out::println);
        }
    }

    private void mostrarListaDePedidos() {
        List<Pedido> pedidos = pedidoServicio.obtenerListaDePedidos();
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados. ");
        } else {
            pedidos.forEach(System.out::println);
        }
    }
}
