package main;

import java.util.Scanner;
import itempedido.ItemPedido;
import lanchonete.Lanchonete;
import pedido.Pedido;

public class Main {
    public static void main(String[] args) {
        Lanchonete lanchonete = new Lanchonete();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- MENU ---");
            System.out.println("1. Criar novo pedido");
            System.out.println("2. Adicionar item a um pedido");
            System.out.println("3. Remover item de um pedido");
            System.out.println("4. Listar todos os pedidos");
            System.out.println("5. Exibir detalhes de um pedido específico");
            System.out.println("6. Remover um pedido");
            System.out.println("7. Sair");
            System.out.print("Digite uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
	            case 1:
	                System.out.print("Digite o número da mesa: ");
	                int mesa = scanner.nextInt();
	                scanner.nextLine();
	
	                if (lanchonete.verificarMesaAtendida(mesa)) {
	                    System.out.println("A mesa " + mesa + " já está sendo atendida.");
	                    break;
	                }
	
	                int idPedido = lanchonete.getProximoIdPedido();
	                System.out.print("Digite o nome do cliente: ");
	                String nomeCliente = scanner.nextLine();
	
	                Pedido novoPedido = new Pedido(idPedido, mesa, nomeCliente);
	                lanchonete.AddPedido(novoPedido);
	
	                System.out.println("Pedido criado com sucesso! ID do Pedido: " + idPedido);
	                break;

	            case 2:
	                System.out.print("Digite o número da mesa: ");
	                mesa = scanner.nextInt();
	                scanner.nextLine();

	                System.out.print("Digite o item: ");
	                String item = scanner.nextLine();
	                System.out.print("Digite o preço: ");
	                double preco = scanner.nextDouble();
	                System.out.print("Digite a quantidade: ");
	                int quantidade = scanner.nextInt();
	                scanner.nextLine();

	                ItemPedido novoItem = new ItemPedido(mesa, null, item, preco, quantidade);
	                lanchonete.adicionarItemPedidoPorMesa(mesa, novoItem);
	                break;

                case 3:
                	System.out.print("Digite o ID do pedido: ");
                	int idPedidoRemoverItem = scanner.nextInt();
                	System.out.print("Digite o ID do item a ser removido: ");
                	int idItem = scanner.nextInt();
                	lanchonete.removerItemPedido(idPedidoRemoverItem, idItem);
                    break;

                case 4:
                    lanchonete.listarPedidos();
                    break;

                case 5:
                    System.out.print("Digite o ID do pedido: ");
                    int idPedidoDetalhes = scanner.nextInt();
                    scanner.nextLine();
                    lanchonete.exibirDetalhesPedido(idPedidoDetalhes);
                    break;

                case 6:
                    System.out.print("Digite o ID do pedido a ser removido: ");
                    int idPedidoRemover = scanner.nextInt();
                    scanner.nextLine();
                    lanchonete.removerPedido(idPedidoRemover);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
