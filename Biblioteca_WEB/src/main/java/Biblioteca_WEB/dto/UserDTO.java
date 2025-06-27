package Biblioteca_WEB.dto;

import Biblioteca_WEB.model.UserModel;
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
public class UserDTO {


    @NotNull @NotBlank
    private String nome;

    @Email @NotBlank
    private String email;

    @NotNull @NotBlank
    private String senha;

    //Metodo salvar usuário no cadastro
    public UserModel toUser()
    {
        UserModel userModel=new UserModel();

        userModel.setNome(this.nome);
        userModel.setEmail(this.email);
        userModel.setSenha(this.senha);

        return userModel;
    }
}