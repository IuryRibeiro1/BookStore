package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Pagamento")
public class Pagamento implements Serializable {

    @Id
    private Long id;
    private Instant data;

    @OneToOne
    @MapsId
    public Pedido pedido;

    public Pagamento(){

    }


    public Pagamento(Long id, Instant data, Pedido pedido) {
        this.id = id;
        this.data = data;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setLong(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
