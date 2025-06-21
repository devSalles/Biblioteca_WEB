package Biblioteca_WEB.repository;

import Biblioteca_WEB.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel,Long> {
}
