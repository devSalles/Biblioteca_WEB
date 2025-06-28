package Biblioteca_WEB.controller.livro;

import Biblioteca_WEB.Enum.StatusLivro;
import Biblioteca_WEB.dto.LivroDTO;
import Biblioteca_WEB.model.BibliotecarioModel;
import Biblioteca_WEB.model.LivroModel;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import Biblioteca_WEB.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/livro")
public class AddNewLivro {

    private LivroRepository livroRepository;
    private BibliotecarioRepository bibliotecarioRepository;
    public AddNewLivro(LivroRepository livroRepository, BibliotecarioRepository bibliotecarioRepository) {
        this.livroRepository = livroRepository;
        this.bibliotecarioRepository=bibliotecarioRepository;
    }

    @GetMapping("/adicionar")
    public ModelAndView templateCampos()
    {
        ModelAndView mv = new ModelAndView("livro/new");
        mv.addObject("livroDTO",new LivroDTO());
        mv.addObject("statusLivro", StatusLivro.values());
        mv.addObject("biblios_id",this.bibliotecarioRepository.findAll());
        return mv;
    }
    @PostMapping("/adicionar")
    public ModelAndView templateLivro(@Valid LivroDTO livroDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("redirect:/livro/adicionar");
        }

        LivroModel livroSave=livroDTO.toLivro();
        Optional<BibliotecarioModel>bibliotecarioID=this.bibliotecarioRepository.findById(livroDTO.getBibliotecario_id());

        if(bibliotecarioID.isEmpty())
        {
            return new ModelAndView("redirect:/home/bibliotecario404");
        }

        livroSave.setBibliotecarioModel(bibliotecarioID.get());
        this.livroRepository.save(livroSave);

        return new ModelAndView("redirect:/home/index");
    }
}
