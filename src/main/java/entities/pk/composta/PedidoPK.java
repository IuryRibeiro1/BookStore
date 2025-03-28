package entities.pk.composta;

import entities.Livro;
import entities.Pedido;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

//Classe para criar uma chave composta no banco de dados
//Recuperando ID do livro e do Pedido para gerar um histórico de compra
//marca uma classe cujas instâncias são armazenadas como parte de uma entidade proprietária. Essa classe pode então ser usada como chave primária composta.
@Embeddable
public class PedidoPK implements Serializable {

//  Criando uma chave composta para receber o ID do pedido
    @ManyToOne
    @JoinColumn(name = "Pedido_id")
    private Pedido pedido;
//  Criando uma chave composta para receber o ID do livro
    @ManyToOne
    @JoinColumn(name = "Livro_id")
    private Livro livro;


    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPK pedidoPK = (PedidoPK) o;
        return Objects.equals(livro, pedidoPK.livro) && Objects.equals(pedido, pedidoPK.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, pedido);
    }
}
