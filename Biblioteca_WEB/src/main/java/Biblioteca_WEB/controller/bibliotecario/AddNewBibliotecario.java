package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.Enum.StatusBibliotecario;
import Biblioteca_WEB.dto.BibliotecarioDTO;
import Biblioteca_WEB.model.BibliotecarioModel;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bibliotecario")
public class AddNewBibliotecario {

    private BibliotecarioRepository bibliotecarioRepository;
    public AddNewBibliotecario(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    @GetMapping("/adicionar")
    public ModelAndView templateCampos()
    {
        ModelAndView mv = new ModelAndView("bibliotecario/new");
        mv.addObject("bibliotecarioDTO",new BibliotecarioDTO());
        mv.addObject("statusBibliotecario", StatusBibliotecario.values());
        return mv;
    }
    @PostMapping("/adicionar")
    public ModelAndView templateBibliotecario(@Valid BibliotecarioDTO bibliotecarioDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("redirect:/bibliotecario/adicionar");
        }
        BibliotecarioModel bibliotecarioModel=bibliotecarioDTO.toBibliotecario();
        this.bibliotecarioRepository.save(bibliotecarioModel);
        return new ModelAndView("redirect:/home/index");
    }
}
