package Biblioteca_WEB.model;

import Biblioteca_WEB.Enum.StatusBibliotecario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb__bibliotecario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecarioModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private StatusBibliotecario statusBibliotecario;

    @OneToMany(fetch = FetchType.LAZY)
    private List<LivroModel> livro=new ArrayList<>();

}
