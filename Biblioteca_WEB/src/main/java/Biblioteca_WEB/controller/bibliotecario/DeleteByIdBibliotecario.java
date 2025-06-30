package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.model.BibliotecarioModel;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/bibliotecario")
public class DeleteByIdBibliotecario {

    private BibliotecarioRepository bibliotecarioRepository;

    public DeleteByIdBibliotecario(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id)
    {
        Optional<BibliotecarioModel>bibliotecarioOpt=this.bibliotecarioRepository.findById(id);
        if(bibliotecarioOpt.isEmpty())
        {
            return new ModelAndView("redirect:/home/bibliotecario404");
        }
        else
        {
            this.bibliotecarioRepository.delete(bibliotecarioOpt.get());
            return new ModelAndView("redirect:/home/index");
        }
    }
}
