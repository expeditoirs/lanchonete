package pedido;

import java.util.ArrayList;

import itempedido.ItemPedido;

public class Pedido {
    private int id;
    private int numeroMesa;
    private String nomeCliente;
    private ArrayList<ItemPedido> itempedido;

    public Pedido(int id, int numeroMesa, String nomeCliente) {
        this.id = id;
        this.numeroMesa = numeroMesa;
        this.nomeCliente = nomeCliente;
        this.itempedido = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public ArrayList<ItemPedido> getItempedido() {
        return itempedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", mesa=" + numeroMesa +
                ", cliente='" + nomeCliente + '\'' +
                ", itens=" + itempedido +
                '}';
    }
}
