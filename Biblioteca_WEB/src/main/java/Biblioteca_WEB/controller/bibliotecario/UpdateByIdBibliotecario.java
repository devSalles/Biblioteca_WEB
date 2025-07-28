package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.Enum.StatusBibliotecario;
import Biblioteca_WEB.dto.BibliotecarioDTO;
import Biblioteca_WEB.model.BibliotecarioModel;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
@RequestMapping("/bibliotecario")
public class UpdateByIdBibliotecario {

    private BibliotecarioRepository bibliotecarioRepository;

    public UpdateByIdBibliotecario(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarCampos(@PathVariable Long id,BibliotecarioDTO bibliotecarioDTO)
    {
        //Procura de existência de ID
        Optional<BibliotecarioModel>bibliotecarioOpt=this.bibliotecarioRepository.findById(id);
        if(bibliotecarioOpt.isEmpty())
        {
            return new ModelAndView("redirect:/home/bibliotecario404");
        }
        else
        {
            BibliotecarioModel bibliotecarioModel=bibliotecarioOpt.get();
            //Converte os dados da entidade para DTO
            bibliotecarioDTO.fromBibliotecario(bibliotecarioModel);

            ModelAndView mv = new ModelAndView("bibliotecario/edit");
            mv.addObject("id",id);
            mv.addObject("bibliotecarioDTO",bibliotecarioDTO);
            mv.addObject("biblioStatus", StatusBibliotecario.values());

            return mv;
        }
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarTemplates(@PathVariable Long id,@Valid BibliotecarioDTO bibliotecarioDTO, BindingResult bindingResult)
    {
        //bindingResult para garantir a validação dos dados
        if(bindingResult.hasErrors())
        {
            ModelAndView mv = new ModelAndView("bibliotecario/edit");
            mv.addObject("id",id);
            mv.addObject("bibliotecarioDTO",bibliotecarioDTO);
            mv.addObject("biblioStatus",StatusBibliotecario.values());
            return mv;
        }
        else
        {
            //Procura de existência de ID
            Optional<BibliotecarioModel>bibliotecarioOpt = this.bibliotecarioRepository.findById(id);
            if(bibliotecarioOpt.isEmpty())
            {
                return new ModelAndView("redirect:/home/bibliotecario404");
            }
            else
            {
                BibliotecarioModel bibliotecarioSave=bibliotecarioOpt.get();
                //Converte os dados para a DTO
                bibliotecarioDTO.updateBibliotecario(bibliotecarioSave);
                this.bibliotecarioRepository.save(bibliotecarioSave);

                return new ModelAndView("redirect:/home/index");
            }
        }
    }
}
