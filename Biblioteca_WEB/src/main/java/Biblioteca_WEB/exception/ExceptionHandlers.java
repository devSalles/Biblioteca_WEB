package Biblioteca_WEB.exception;


import Biblioteca_WEB.Enum.StatusBibliotecario;
import Biblioteca_WEB.dto.BibliotecarioDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlers {

    //Exceção para email duplicado
    @ExceptionHandler(EmailJaCdastradoException.class)
    public ModelAndView emailCadastradoHandler(EmailJaCdastradoException ex) {
        ModelAndView mv = new ModelAndView("bibliotecario/new");
        mv.addObject("errorMessage", ex.getMessage());
        mv.addObject("bibliotecarioDTO", new BibliotecarioDTO());
        mv.addObject("statusBibliotecario", StatusBibliotecario.values());
        return mv;
    }
}
