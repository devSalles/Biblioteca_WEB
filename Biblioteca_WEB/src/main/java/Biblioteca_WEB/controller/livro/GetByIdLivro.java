package Biblioteca_WEB.controller.livro;

import Biblioteca_WEB.model.LivroModel;
import Biblioteca_WEB.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/livro")
public class GetByIdLivro {

    private LivroRepository livroRepository;

    public GetByIdLivro(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/detalhe/{id}")
    public ModelAndView showDetalhes(@PathVariable Long id)
    {
        Optional<LivroModel>livroID=this.livroRepository.findById(id);
        if(livroID.isEmpty())
        {
            return new ModelAndView("redirect:/home/livro404");
        }
        else
        {
            LivroModel livroRecId=livroID.get();

            ModelAndView mv = new ModelAndView("livro/showById");
            mv.addObject("idLivro",livroRecId);
            mv.addObject("BiblioResp",livroRecId.getBibliotecarioModel());

            return mv;
        }
    }
}
