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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/livro")
public class UpdateByIdLivro {

    private LivroRepository livroRepository;
    private BibliotecarioRepository bibliotecarioRepository;

    public UpdateByIdLivro(LivroRepository livroRepository,  BibliotecarioRepository bibliotecarioRepository) {
        this.livroRepository = livroRepository;
        this.bibliotecarioRepository=bibliotecarioRepository;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarCampos(@PathVariable Long id, LivroDTO livroDTO)
    {
        Optional<LivroModel>livroID=this.livroRepository.findById(id);
        if (livroID.isEmpty())
        {
            return new ModelAndView("redirect:/home/livro404");
        }
        else
        {
            LivroModel livroRecId=livroID.get();
            livroDTO.fromLivro(livroRecId);

            ModelAndView mv = new ModelAndView("/livro/edit");
            mv.addObject("livroID",id);
            mv.addObject("livroDTO",livroDTO);
            mv.addObject("StatusLivro", StatusLivro.values());
            mv.addObject("idBiblio",this.bibliotecarioRepository.findAll());

            return mv;
        }
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarInfo(@PathVariable Long id, @Valid LivroDTO livroDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            ModelAndView mv = new ModelAndView("/livro/edit");
            mv.addObject("livroID",id);
            mv.addObject("livroDTO",livroDTO);
            mv.addObject("StatusLivro",StatusLivro.values());
            mv.addObject("idBiblio",this.bibliotecarioRepository.findAll());
            return mv;
        }
        else
        {
            Optional<LivroModel>livroModelID=this.livroRepository.findById(id);
            if(livroModelID.isEmpty())
            {
                return new ModelAndView("redirect:/home/livro404");
            }
            else
            {
                LivroModel livroRecID=livroModelID.get();
                LivroModel livroAtualizado=livroDTO.updateLivro(livroRecID);

                Optional<BibliotecarioModel>bibliotecarioID=this.bibliotecarioRepository.findById(livroDTO.getBibliotecario_id());
                if(bibliotecarioID.isEmpty())
                {
                    return new ModelAndView("redirect:/home/bibliotecario404");
                }
                livroAtualizado.setBibliotecarioModel(bibliotecarioID.get());
                this.livroRepository.save(livroAtualizado);
                return new ModelAndView("redirect:/home/index");
            }
        }
    }
}
