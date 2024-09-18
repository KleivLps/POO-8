package GestionDePedidos;

import java.util.Arrays;

public class Pedido {
    private int numeroDePedido;
    private String cliente;
    private String[] listaDeProductos;
    private EstadoPedido estadoPedido;

    public Pedido() {
    }

    public Pedido(int numeroDePedido, String cliente, String[] listaDeProductos) {
        this.numeroDePedido = numeroDePedido;
        this.cliente = cliente;
        this.listaDeProductos = listaDeProductos;
        this.estadoPedido = EstadoPedido.PENDIENTE;
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String[] getListaDeProductos() {
        return listaDeProductos;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numeroDePedido= " +numeroDePedido + ", cliente= '" +cliente+ '\'' + ", listaDeProductos= " + Arrays.toString(listaDeProductos) + "' estadoDePedido= " + estadoPedido + '}';
    }
}
