package Biblioteca_WEB.dto;

import Biblioteca_WEB.Enum.StatusFuncionario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
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
public class BibliotecarioDTO {

    @NotNull @NotBlank
    private String nome;

    @Email @NotBlank
    private String email;

    @NotNull @NotBlank
    private String cargo;

    @DecimalMin("0.0")
    private Double salario;

    @Enumerated(EnumType.STRING)
    private StatusFuncionario statusFuncionario;
}
