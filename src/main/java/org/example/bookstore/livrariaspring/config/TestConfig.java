package org.example.bookstore.livrariaspring.config;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.bookstore.livrariaspring.Enum.StatusPedido;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

//Configuration e profile estão tornando a classe config apta para fazer testes da aplicação
@Configuration
@Profile("test")
//CommandLineRunner é uma interface que permite rodar a aplicação
public class TestConfig implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstore");
        EntityManager em = emf.createEntityManager();



//          Instanciando os livros que serão populados no banco de dados
                Livro livroUm = new Livro(1, "O senhor dos anéis: A Sociedade do anel", "J.R.R Tolkiken", "Martins Fontes", "Brasileira", "Português", "Fantasia", "Frodo, Gandalf, Anel, Coragem, Determinação, Valentia, Sociedade do Anel, Bilbo Bolseiro, Sauron, Senhor Sombrio.", 464, "Impresso", "03/2000", 44.91, 5, "O Senhor dos Anéis: A Sociedade do Anel é o primeiro livrigos na missão de destruir o Um Anel");
                Livro livroDois = new Livro(2, "O senhor dos anéis: As duas torres", "J.R.R Tolkiken", "George Allen & Unwin", "Brasileira", "Português", "Fantasia", "Sociedade, Literatura, Fantasia, Tolkien, Amizade, Confiança, Resiliência, Esperança, Coragem, Sacrifício.", 464, "Impresso", "11/2003", 69.90, 5, "Após a captura de Merry e Pippy pelos orcs, a Sociedade do Anel é dissolvida. Frodo e Sam seguem sua jornada rumo à Mont el de Saruman.");
                Livro livroTres = new Livro(3, "O senhor dos anéis: O retorno do reio", "J.R.R Tolkiken", "Martins Fontes", "Brasileira", "Português", "Fantasia", "Amizade, Lealdade, Redenção, Poder, Corrupção, Esperança, Bondade, Batalha, Reconstrução.", 528, "Impresso", "12/2003", 41.79, 5, "Sauron planeja um grande ataque a Minas Tirith, capital de Gondor, o que faz com que Gandalf e Pippin partam para o local na intenção de ajudar nel.");



//          Instanciando o cliente que será populado no banco de dados
                Cliente cliente = new Cliente("00100200304", "Iury" , "iury211@gmail.com" , "96981440238" , "06/03/1997" , "25/03/2025");

//              Instanciando os pedidos realizados para popular no banco de dados
                Pedido pedido = new Pedido(1L, Instant.now(), StatusPedido.PAGAMENTO, cliente);
//
//              Adicionando os livros que foram solicitados no pedido na tabela Registro_Livros
                pedido.getLivro().add(livroUm);
                pedido.getLivro().add(livroDois);

//              Adicionando os livros que foram pedidos, com seu valor e quantidade
                Pedido_Livro pedidoLivroUm = new Pedido_Livro(pedido, livroUm,1, livroUm.getPreco());
                Pedido_Livro pedidoLivroDois = new Pedido_Livro(pedido, livroDois,1, livroDois.getPreco());


                Pagamento pagamento = new Pagamento(1L, Instant.now(), pedido);
                pedido.setPagamento(pagamento);



                em.getTransaction().begin();
                em.merge(pagamento);
                em.getTransaction().commit();

                Pedido p = em.find(Pedido.class, 1);
                System.out.println(p);


           }
}



