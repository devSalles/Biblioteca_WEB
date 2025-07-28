package Biblioteca_WEB.dto;

import Biblioteca_WEB.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    @NotBlank(message = "nome obrigatório")
    private String nome;

    //Validação de email
    @Email(message = "O e-mail deve ser válido") @NotBlank(message = "email obrigatório")
    private String email;

    @NotNull(message = "senha obrigatória") @Size(min = 6, max = 18)
    private String senha;

    //Metodo para conversão
    public UserModel toUser()
    {
        UserModel userModel=new UserModel();

        userModel.setNome(this.nome);
        userModel.setEmail(this.email);
        userModel.setSenha(this.senha);

        return userModel;
    }
}