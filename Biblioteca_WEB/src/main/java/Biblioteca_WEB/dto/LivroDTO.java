package Biblioteca_WEB.dto;

import Biblioteca_WEB.Enum.StatusLivro;
import Biblioteca_WEB.model.LivroModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    @NotBlank @NotNull
    private String titulo;

    @NotBlank @NotNull
    private String autor;

    @NotBlank @NotNull
    private String isbn;

    @Enumerated(EnumType.STRING)
    private StatusLivro statusLivro;

    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate anoPublicacao;

    @NotBlank @NotNull
    private String categoria;

    private Long bibliotecario_id;

    // ---Metodos abaixo de conversão---

    //Metodo para salvar funcionario
    public LivroModel toLivro()
    {
        LivroModel livroModel=new LivroModel();

        livroModel.setTitulo(this.titulo);
        livroModel.setAutor(this.autor);
        livroModel.setIsbn(this.isbn);
        livroModel.setAnoPublicacao(this.anoPublicacao);
        livroModel.setCategoria(this.categoria);
        livroModel.setStatusLivro(this.statusLivro);

        return livroModel;
    }

    //Metodo para achar livro
    public void fromLivro(LivroModel livroModel)
    {
        this.titulo=livroModel.getTitulo();
        this.autor=livroModel.getAutor();
        this.isbn=livroModel.getIsbn();
        this.anoPublicacao=livroModel.getAnoPublicacao();
        this.categoria=livroModel.getCategoria();
        this.statusLivro=livroModel.getStatusLivro();
        if(livroModel.getBibliotecarioModel()!=null)
        {
            this.bibliotecario_id=livroModel.getBibliotecarioModel().getId();
        }
        else
        {
            bibliotecario_id=null;
        }
    }

    //Metodo para atualizar livro
    public LivroModel updateLivro(LivroModel livroModel)
    {
        livroModel.setTitulo(this.getTitulo());
        livroModel.setAutor(this.getAutor());
        livroModel.setIsbn(this.getIsbn());
        livroModel.setAnoPublicacao(this.getAnoPublicacao());
        livroModel.setCategoria(this.getCategoria());
        livroModel.setStatusLivro(this.getStatusLivro());

        return livroModel;
    }
}