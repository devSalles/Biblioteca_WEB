package Biblioteca_WEB.core;


import Biblioteca_WEB.Enum.StatusBibliotecario;
import Biblioteca_WEB.Enum.StatusLivro;
import Biblioteca_WEB.core.exception.EmailJaCdastradoException;
import Biblioteca_WEB.core.exception.IsbnJaCadastrado;
import Biblioteca_WEB.dto.BibliotecarioDTO;
import Biblioteca_WEB.dto.LivroDTO;
import Biblioteca_WEB.repository.BibliotecarioRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlers {

    private final BibliotecarioRepository bibliotecarioRepository;

    public ExceptionHandlers(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }


    //Exceção para email duplicado
    @ExceptionHandler(EmailJaCdastradoException.class)
    public ModelAndView emailCadastradoHandler(EmailJaCdastradoException ex) {
        ModelAndView mv = new ModelAndView("bibliotecario/new");
        mv.addObject("errorMessage", ex.getMessage());
        mv.addObject("bibliotecarioDTO", new BibliotecarioDTO());
        mv.addObject("statusBibliotecario", StatusBibliotecario.values());
        return mv;
    }

    //Exceção para ISBN duplicado
    @ExceptionHandler(IsbnJaCadastrado.class)
    public ModelAndView isbnHandlerException(IsbnJaCadastrado ex, @ModelAttribute("livroDTO") LivroDTO livroDTO)
    {
        ModelAndView mv = new ModelAndView("livro/new");
        mv.addObject("errorMessage", ex.getMessage());
        mv.addObject("livroDTO", livroDTO);
        mv.addObject("statusLivro", StatusLivro.values());
        mv.addObject("biblios_id", this.bibliotecarioRepository.findAll());
        return mv;
    }
}
