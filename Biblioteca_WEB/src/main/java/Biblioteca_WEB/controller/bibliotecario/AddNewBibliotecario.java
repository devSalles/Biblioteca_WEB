package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.Enum.StatusBibliotecario;
import Biblioteca_WEB.dto.BibliotecarioDTO;
import Biblioteca_WEB.core.exception.EmailJaCdastradoException;
import Biblioteca_WEB.model.BibliotecarioModel;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bibliotecario")
public class AddNewBibliotecario {

    private final BibliotecarioRepository bibliotecarioRepository;

    public AddNewBibliotecario(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    @GetMapping("/adicionar")
    public ModelAndView templateCampos()
    {
        ModelAndView mv = new ModelAndView("bibliotecario/new");
        mv.addObject("bibliotecarioDTO", new BibliotecarioDTO());
        mv.addObject("statusBibliotecario", StatusBibliotecario.values());
        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView templateBibliotecario(@Valid BibliotecarioDTO bibliotecarioDTO, BindingResult bindingResult)
    {

        //Verifica erros de validação
        if (bindingResult.hasErrors())
        {
            ModelAndView mv = new ModelAndView("bibliotecario/new");
            mv.addObject("statusBibliotecario", StatusBibliotecario.values());
            mv.addObject("bibliotecarioDTO", bibliotecarioDTO);
            return mv;
        }

        try
        {
            //Verifica se o email já existe
            if (bibliotecarioRepository.existsByEmail(bibliotecarioDTO.getEmail()))
            {
                throw new EmailJaCdastradoException("Email já cadastrado: " + bibliotecarioDTO.getEmail());
            }

            //Persiste no banco
            BibliotecarioModel bibliotecarioModel = bibliotecarioDTO.toBibliotecario();
            bibliotecarioRepository.save(bibliotecarioModel);
            return new ModelAndView("redirect:/home/index");

        }
        catch (EmailJaCdastradoException ex)
        {
            //Retorna o formulário com mensagem de erro e dados preenchidos
            ModelAndView mv = new ModelAndView("bibliotecario/new");
            mv.addObject("statusBibliotecario", StatusBibliotecario.values());
            mv.addObject("errorMessage", ex.getMessage());
            mv.addObject("bibliotecarioDTO", bibliotecarioDTO); // garante os dados preenchidos
            return mv;
        }
        catch (DataIntegrityViolationException ex)
        {
            // Captura violações de constraint do banco
            ModelAndView mv = new ModelAndView("bibliotecario/new");
            mv.addObject("statusBibliotecario", StatusBibliotecario.values());
            mv.addObject("errorMessage", "Email já cadastrado no sistema");
            mv.addObject("bibliotecarioDTO", bibliotecarioDTO);
            return mv;
        }
    }
}
