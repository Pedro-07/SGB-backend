package com.biblioteca.livro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long id;
    
    // @NotBlank(message = "Titulo obrigatório")
    private String titulo;
    
    // @NotBlank(message = "Nome do Autor é obrigatório")
    private String autor;
    
    // @NotBlank(message = "Nome da editora é obrigatório")
    private String editora;
    
    // @NotBlank(message = "ISBN é obrigatório")
    private String isbn;
    
    // @NotNull(message = "Campo obrigatório")
    private int anoPubli;
    
    // @NotNull(message = "Campo obrigatório")
    private int quantidade;
    
    // Comentado porque não está sendo usado no momento
    // public void incrementarQuantidade() {
    //     System.out.println("Antes de incrementar: quantidade = " + this.quantidade);
    //     this.quantidade++;
    //     System.out.println("Depois de incrementar: quantidade = " + this.quantidade);
    // }

    // Comentado porque não está sendo usado no momento
    // public void decrementarQuantidade() {
    //     if (this.quantidade != 0 && this.quantidade > 0) {
    //         this.quantidade--;
    //     }
    // }

    public Livro() {}

    public Livro(String titulo, String autor, String editora, String isbn, Integer anoPubli, Integer quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPubli = anoPubli;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long idLivro) {
        this.id = idLivro;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnoPubli() {
        return anoPubli;
    }

    public void setAnoPubli(int anoPubli) {
        this.anoPubli = anoPubli;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return id;
    }
}
