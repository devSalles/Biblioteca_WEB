package Biblioteca_WEB.controller.livro;

import Biblioteca_WEB.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livro")
public class AddNewLivro {

    private LivroRepository livroRepository;

    public AddNewLivro(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
}
