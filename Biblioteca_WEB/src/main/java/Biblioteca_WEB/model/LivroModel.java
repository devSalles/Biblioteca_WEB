package Biblioteca_WEB.model;

import Biblioteca_WEB.Enum.StatusLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Column(nullable = false,unique = true)
    private String isbn;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private StatusLivro statusLivro;

    @Column(nullable = false)
    private LocalDate anoPublicacao;

    @Column(nullable = false)
    private String categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bibliotecario_id",nullable = true)
    private BibliotecarioModel bibliotecarioModel;
}
