package itempedido;

public class ItemPedido {
    private static int idCounter = 1; 
    private int id;
    private int mesa;
    private String nome;
    private String item;
    private double preco;
    private int quantidade;

    public ItemPedido(int mesa, String nome, String item, double preco, int quantidade) {
        this.id = idCounter++;
        this.mesa = mesa;
        this.nome = nome;
        this.item = item;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public int getMesa() {
        return mesa;
    }

    public String getNome() {
        return nome;
    }

    public String getItem() {
        return item;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido [id=" + id + ", mesa=" + mesa + ", nome=" + nome + ", item=" + item 
               + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }
}
