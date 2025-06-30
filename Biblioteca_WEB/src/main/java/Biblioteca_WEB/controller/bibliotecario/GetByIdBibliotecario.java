package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.dto.BibliotecarioDTO;
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
public class GetByIdBibliotecario {

    private BibliotecarioRepository bibliotecarioRepository;

    public GetByIdBibliotecario(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    @GetMapping("/detalhe/{id}")
    public ModelAndView detalhesBiblio(@PathVariable Long id, BibliotecarioDTO bibliotecarioDTO)
    {
        Optional<BibliotecarioModel>bibliotecarioOpt = this.bibliotecarioRepository.findById(id);
        if(bibliotecarioOpt.isEmpty())
        {
            return new ModelAndView("redirect:/home/bibliotecario404");
        }
        else
        {
            BibliotecarioModel bibliotecarioModel=bibliotecarioOpt.get();
            bibliotecarioDTO.fromBibliotecario(bibliotecarioModel);

            ModelAndView mv = new ModelAndView("/bibliotecario/showById");
            mv.addObject("biblioDTO", bibliotecarioModel);

            return mv;
        }
    }
}
