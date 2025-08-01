package Biblioteca_WEB.controller;

import Biblioteca_WEB.Enum.StatusBibliotecario;
import Biblioteca_WEB.Enum.StatusLivro;
import Biblioteca_WEB.dto.BibliotecarioDTO;
import Biblioteca_WEB.dto.LivroDTO;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import Biblioteca_WEB.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class GetAllController {

    private BibliotecarioRepository bibliotecarioRepository;
    private LivroRepository livroRepository;

    public GetAllController(BibliotecarioRepository bibliotecarioRepository, LivroRepository livroRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
        this.livroRepository=livroRepository;
    }

    //Exibição de Home principal tanto de bibliotecario quanto de livro
    @GetMapping("/index")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("layout/index");

        mv.addObject("bibliotecarioList", bibliotecarioRepository.findAll());
        mv.addObject("livros", livroRepository.findAll());

        mv.addObject("bibliotecarioDTO",new BibliotecarioDTO());
        mv.addObject("livroDTO", new LivroDTO());

        mv.addObject("statusBibliotecario", StatusBibliotecario.values());
        mv.addObject("statusLivroList", StatusLivro.values());

        return mv;
    }
}
