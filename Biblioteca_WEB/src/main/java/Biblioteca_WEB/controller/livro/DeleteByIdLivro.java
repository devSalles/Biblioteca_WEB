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
public class DeleteByIdLivro {

    private LivroRepository livroRepository;

    public DeleteByIdLivro(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView deletar(@PathVariable Long id)
    {
        Optional<LivroModel>livroID=this.livroRepository.findById(id);
        if(livroID.isEmpty())
        {
            return new ModelAndView("redirect:/home/livro404");
        }
        else
        {
            LivroModel livroDel=livroID.get();
            this.livroRepository.delete(livroDel);
            return new ModelAndView("redirect:/home/index");
        }
    }
}
