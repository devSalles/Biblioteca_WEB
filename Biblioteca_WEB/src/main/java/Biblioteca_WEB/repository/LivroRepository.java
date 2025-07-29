package Biblioteca_WEB.repository;

import Biblioteca_WEB.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel,Long> {

    //Busca o ID dos bibliotecários
    List<LivroModel> findByBibliotecarioModelId(Long id);

    boolean existsByIsbn(String isbn);
}
