package GestionDePedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoServicio {
    private final List<Pedido> pedidos;
    private int contadorPedidos;

    public PedidoServicio() {
        this.pedidos = new ArrayList<>();
        this.contadorPedidos = 0;
    }

    public Pedido crearPedido(String cliente, String[] listaDeProductos) {
        Pedido nuevoPedido = new Pedido(++contadorPedidos, cliente, listaDeProductos);
        pedidos.add(nuevoPedido);
        return nuevoPedido;
    }

    public boolean actualizarEstadoPedido(int numeroDePedido, EstadoPedido nuevoEstado) {
        Pedido pedido = buscarPedidoPorNumero(numeroDePedido);
        if (pedido != null) {
            pedido.setEstadoPedido(nuevoEstado);
            return true;
        }
        return false;
    }

    public Pedido buscarPedidoPorNumero(int numeroDePedido) {
        return pedidos.stream().filter(pedido -> pedido.getNumeroDePedido() == numeroDePedido).findFirst().orElse(null);
    }

    public List<Pedido> buscarPedidosPorEstado(EstadoPedido estado) {
        return pedidos.stream().filter(pedido -> pedido.getEstadoPedido() == estado).collect(Collectors.toList());
    }

    public List<Pedido> obtenerListaDePedidos() {
        return pedidos;
    }
}
