package Biblioteca_WEB.repository;

import Biblioteca_WEB.model.BibliotecarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioModel,Long> {
}
