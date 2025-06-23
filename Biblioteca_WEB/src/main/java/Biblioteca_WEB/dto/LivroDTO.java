package Biblioteca_WEB.dto;

import Biblioteca_WEB.Enum.StatusLivro;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotBlank @NotNull
    private Integer anoPublicacao;

    @NotBlank @NotNull
    private String categoria;

}
