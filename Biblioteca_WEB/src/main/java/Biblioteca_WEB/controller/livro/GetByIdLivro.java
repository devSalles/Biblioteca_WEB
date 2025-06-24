package Biblioteca_WEB.controller.livro;

import Biblioteca_WEB.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livro")
public class GetByIdLivro {

    private LivroRepository livroRepository;

    public GetByIdLivro(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
}
