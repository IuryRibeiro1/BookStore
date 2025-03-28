package entities;

import jakarta.persistence.*;
import org.example.bookstore.livrariaspring.Enum.StatusPedido;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Entity está indicando que minha classe corresponderá ao banco de dados
@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

//  Id está identificando qual variável será a chave primária.
    @Id
    private Long id;
    private Instant dataDoPedido;

    //Associação de muitos para um, adicionando a coluna Cliente ID
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

   //Realizando associação entre pedido e livro parar criar uma tabela de registro do pedido e livro
    @ManyToMany
    @JoinTable(name = "Registro_Livros",
    joinColumns = @JoinColumn(name = "pedido_id"))
    private Set<Livro> livros = new HashSet<>();

    //  Mapeando a associação one to one com atributo mappedBy e Cascade para que tenham o mesmo ID
    @OneToOne(mappedBy = "pedido" , cascade = CascadeType.ALL)
    public Pagamento pagamento;


//  Adicionando o SET nas coleções para que não seja permitida a repetição de um mesmo produto
    @OneToMany(mappedBy = "id.pedido")
    private Set<Pedido_Livro> pedido_livro;

    StatusPedido statusPedido;




    public Pedido() {

    }

    public Pedido(Long id, Instant dataDoPedido, StatusPedido statusPedido , Cliente cliente) {
        this.id = id;
        this.dataDoPedido = dataDoPedido;
        this.cliente = cliente;
        this.statusPedido = statusPedido;

    }



        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public Instant getDataDoPedido () {
            return dataDoPedido;
        }

        public void setDataDoPedido (Instant dataDoPedido){
            this.dataDoPedido = dataDoPedido;
        }

         public Cliente getCliente() {
            return cliente;
    }

        public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatusPedido() {
        return  statusPedido;
    }

    public Set<Livro> getLivro() {
        return livros;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<Pedido_Livro> getPedido_livro() {
        return pedido_livro;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if (statusPedido != null) {
            this.statusPedido = statusPedido;
        }

    }
    public Double valorTotal() {
        double soma = 0.0;
        for (Pedido_Livro x : pedido_livro) {
            soma += x.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        return "Pedido id: " + id +
                ", DataDoPedido: " + dataDoPedido +
                 cliente + "," +
                " Livro: " + livros +
                " , StatusDoPedido: " + statusPedido +
                " Valor total do pedido: " + valorTotal() + " Reais";


    }
}

