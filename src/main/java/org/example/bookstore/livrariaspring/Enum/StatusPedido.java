package org.example.bookstore.livrariaspring.Enum;

//Criando ENUM com boas práticas utilizando indicadores nos indices.
public enum StatusPedido {

    REALIZADO(0),
    PAGAMENTO(1),
    PREPARO(2),
    ENVIO(3),
    ENTREGA(4);


    private int codigo;

    //construtor do Status Pedido
    private StatusPedido(int codigo) {
        this.codigo = codigo;
    }

    //método público para retornar o código
    public int getCodigo() {
        return codigo;
    }

    //Converte valor número para Enum - estático para não ser necessário instânciar
    public static StatusPedido valueOf(int codigo) {
        for (StatusPedido value : StatusPedido.values()) {
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de pedido inválidio");
    }

}
