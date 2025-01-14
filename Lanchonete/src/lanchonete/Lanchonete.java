package lanchonete;

import java.util.ArrayList;
import itempedido.ItemPedido;
import pedido.Pedido;

public class Lanchonete {
	private ArrayList<Pedido> pedidos;

    public Lanchonete() {
        this.pedidos = new ArrayList<>();
    }

    public int getProximoIdPedido() {
        if (pedidos.isEmpty()) {
            return 1; // Se não houver pedidos, começa com ID 1
        }
        // Encontra o maior ID na lista de pedidos
        int maiorId = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getId() > maiorId) {
                maiorId = pedido.getId();
            }
        }
        return maiorId + 1; // Retorna o próximo ID
    }

    public void AddPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public boolean verificarMesaAtendida(int numeroMesa) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroMesa() == numeroMesa) {
                return true; // Mesa já está sendo atendida
            }
        }
        return false;
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    public void adicionarItemPedidoPorMesa(int numeroMesa, ItemPedido item) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroMesa() == numeroMesa) {
                pedido.getItempedido().add(item);
                System.out.println("Item adicionado ao pedido da mesa " + numeroMesa);
                return;
            }
        }
        System.out.println("Mesa " + numeroMesa + " não encontrada!");
    }

    public void removerItemPedido(int idPedido, int itemId) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                ArrayList<ItemPedido> itens = pedido.getItempedido();
                for (ItemPedido item : itens) {
                    if (item.getId() == itemId) {
                        itens.remove(item);
                        System.out.println("Item removido do pedido " + idPedido);
                        return;
                    }
                }
                System.out.println("Item não encontrado no pedido!");
                return;
            }
        }
        System.out.println("Pedido não encontrado!");
    }



    public void exibirDetalhesPedido(int idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                System.out.println(pedido);
                return;
            }
        }
        System.out.println("Pedido não encontrado!");
    }

    public void removerPedido(int idPedido) {
        pedidos.removeIf(pedido -> pedido.getId() == idPedido);
        System.out.println("Pedido " + idPedido + " removido.");
    }
}
