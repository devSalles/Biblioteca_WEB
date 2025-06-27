package Biblioteca_WEB.repository;

import Biblioteca_WEB.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    //metodos para cadastrar o email e senha do usuário ao realizar o cadastro
    UserModel findByEmail(String email);
    UserModel findBySenha(String senha);
}
