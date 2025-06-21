package Biblioteca_WEB.model;

import Biblioteca_WEB.Enum.StatusLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb__livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private StatusLivro statusLivro;

    @Column(nullable = false)
    private Integer anoPublicacao;

    @Column(nullable = false)
    private String categoria;
}
