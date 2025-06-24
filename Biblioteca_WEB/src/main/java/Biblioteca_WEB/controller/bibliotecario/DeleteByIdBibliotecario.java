package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.repository.BibliotecarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bibliotecario")
public class DeleteByIdBibliotecario {

    private BibliotecarioRepository bibliotecarioRepository;

    public DeleteByIdBibliotecario(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }
}
