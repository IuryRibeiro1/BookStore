package entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Livro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

//  Declarando o atributo isbn como chave primária e que sera incrementado automaticamente no banco de dados a sua chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer isbn;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;
    private String idioma;
    private String genero;
    private String palavrasChave;
    private int numeroPaginas;
    private String formato;
    private String anoDePublicacao;
    private Double preco;
    private int estoque;
    private String resumo;

//  Mapeando o SET na classe Pedido para associar muito para muitos, sendo assim possível resgatar os livros que foram solicitados no pedido
    @ManyToMany(mappedBy = "livros")
    Set<Pedido> pedidos = new HashSet<>();


    public Livro() {

    }

    public Livro(Integer isbn, String titulo, String autor, String editora, String edicao, String idioma, String genero, String palavrasChave, int numeroPaginas, String formato, String anoDePublicacao, Double preco, int estoque, String resumo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.idioma = idioma;
        this.genero = genero;
        this.palavrasChave = palavrasChave;
        this.numeroPaginas = numeroPaginas;
        this.formato = formato;
        this.anoDePublicacao = anoDePublicacao;
        this.preco = preco;
        this.estoque = estoque;
        this.resumo = resumo;
    }


        public Integer getIsbn() {
            return isbn;
        }

        public void setIsbn(Integer isbn) {
            this.isbn = isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getEditora() {
            return editora;
        }

        public void setEditora(String editora) {
            this.editora = editora;
        }

        public String getEdicao() {
            return edicao;
        }

        public void setEdicao(String edicao) {
            this.edicao = edicao;
        }

        public String getIdioma() {
            return idioma;
        }

        public void setIdioma(String idioma) {
            this.idioma = idioma;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getPalavrasChave() {
            return palavrasChave;
        }

        public void setPalavrasChave(String palavrasChave) {
            this.palavrasChave = palavrasChave;
        }

        public int getNumeroPaginas() {
            return numeroPaginas;
        }

        public void setNumeroPaginas(int numeroPaginas) {
            this.numeroPaginas = numeroPaginas;
        }

        public String getFormato() {
            return formato;
        }

        public void setFormato(String formato) {
            this.formato = formato;
        }

        public String getAnoDePublicacao() {
            return anoDePublicacao;
        }

        public void setAnoDePublicacao(String anoDePublicacao) {
            this.anoDePublicacao = anoDePublicacao;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }

        public String getResumo() {
            return resumo;
        }

        public void setResumo(String resumo) {
            this.resumo = resumo;
        }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Livro: " +
                " isbn: " + isbn +
                ", titulo: " + titulo + '\'' +
                ", autor: " + autor + '\'';
    }
}



