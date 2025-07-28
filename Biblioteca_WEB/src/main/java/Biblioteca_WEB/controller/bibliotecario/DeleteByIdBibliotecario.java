package Biblioteca_WEB.controller.bibliotecario;

import Biblioteca_WEB.model.BibliotecarioModel;
import Biblioteca_WEB.model.LivroModel;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import Biblioteca_WEB.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bibliotecario")
public class DeleteByIdBibliotecario {

    private BibliotecarioRepository bibliotecarioRepository;
    private LivroRepository livroRepository;

    public DeleteByIdBibliotecario(BibliotecarioRepository bibliotecarioRepository, LivroRepository livroRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
        this.livroRepository = livroRepository;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id)
    {
        //Procura de existência de ID
        Optional<BibliotecarioModel>bibliotecarioOpt=this.bibliotecarioRepository.findById(id);
        if(bibliotecarioOpt.isEmpty())
        {
            return new ModelAndView("redirect:/home/bibliotecario404");
        }
        else
        {
            //List para buscar todos os ID associados ao bibliotecário
            List<LivroModel> livroID=this.livroRepository.findByBibliotecarioModelId(id);

            //for para cada livro encontrado remove a referência do ID do bibliotecario
            for(LivroModel livro:livroID)
            {
                livro.setBibliotecarioModel(null);
            }

            //Salva o livro novamente com o ID null
            this.livroRepository.saveAll(livroID);

            this.bibliotecarioRepository.delete(bibliotecarioOpt.get());
            return new ModelAndView("redirect:/home/index");
        }
    }
}
