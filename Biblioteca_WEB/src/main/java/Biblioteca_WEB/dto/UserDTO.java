package Biblioteca_WEB.dto;

import Biblioteca_WEB.model.LivroModel;
import Biblioteca_WEB.model.UserModel;
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
public class UserDTO {


    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String senha;

    @NotNull @NotBlank
    private String cpf;


    //Metodo para achar usuário e realizar login
    private void fromUser(UserModel userModel)
    {
        this.nome= userModel.getNome();
        this.cpf= userModel.getCpf();
        this.email= userModel.getEmail();
        this.senha=userModel.getSenha();
    }
}