package Biblioteca_WEB.dto;

import Biblioteca_WEB.Enum.StatusFuncionario;
import Biblioteca_WEB.model.BibliotecarioModel;
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

    // ---Metodos abaixo de conversão---

    //metodo para salvar bibliotecario
    public BibliotecarioModel toBibliotecario()
    {
        BibliotecarioModel bibliotecarioModel=new BibliotecarioModel();

        bibliotecarioModel.setNome(this.nome);
        bibliotecarioModel.setEmail(this.email);
        bibliotecarioModel.setCargo(this.cargo);
        bibliotecarioModel.setSalario(this.salario);
        bibliotecarioModel.setStatusFuncionario(this.statusFuncionario);

        return bibliotecarioModel;
    }

    //Metodo para achar funcionario
    public void fromBibliotecario(BibliotecarioModel bibliotecarioModel)
    {
        this.nome=bibliotecarioModel.getNome();
        this.email=bibliotecarioModel.getEmail();
        this.cargo=bibliotecarioModel.getCargo();
        this.salario=bibliotecarioModel.getSalario();
        this.statusFuncionario=bibliotecarioModel.getStatusFuncionario();
    }

    //metodo para atualizar funcionario
    public BibliotecarioModel updateBibliotecario(BibliotecarioModel bibliotecarioModel)
    {
        bibliotecarioModel.setNome(this.getNome());
        bibliotecarioModel.setEmail(this.getEmail());
        bibliotecarioModel.setCargo(this.getCargo());
        bibliotecarioModel.setSalario(this.getSalario());
        bibliotecarioModel.setStatusFuncionario(this.getStatusFuncionario());

        return bibliotecarioModel;
    }
}