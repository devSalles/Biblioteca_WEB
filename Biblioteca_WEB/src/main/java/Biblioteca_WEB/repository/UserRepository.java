package Biblioteca_WEB.repository;

import Biblioteca_WEB.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

    //Metodo para achar email e senha do usuário para realizar login
    Optional<UserModel>findByEmailAndSenha(String email,String senha);

    //metodos para cadastrar o email e senha do usuário ao realizar o cadastro
    UserModel existsByEmail(String email);
    UserModel existsBySenha(String senha);
}
