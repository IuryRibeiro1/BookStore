package entities;

import entities.pk.composta.PedidoPK;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Classe que criará a associação composta do PedidoPK e ira transformar na leitura relacional para o banco de dados MySQL
@Entity
@Table(name = "Pedido_Livro")
public class Pedido_Livro {

//Indica a chave primária composta no caso a classe PedidoPK
    @EmbeddedId
    private PedidoPK id = new PedidoPK();

    private Integer quantidade;
    private Double preco;

    public Pedido_Livro(){

    }

    public Pedido_Livro(Pedido pedido, Livro livro, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setLivro(livro);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Livro getLivro(){
        return id.getLivro();
    }

    public void setLivro(Livro livro){
        id.setLivro(livro);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double subTotal(){
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return  "  quantidade: " + quantidade +
                ", preco: "  + preco;
    }
}
