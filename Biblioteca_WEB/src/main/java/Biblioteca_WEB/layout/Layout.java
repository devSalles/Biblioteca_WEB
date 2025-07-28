package Biblioteca_WEB.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Layout {

    //Classe responsável por templates de layout do site

    @GetMapping("/livro404")
    public ModelAndView livroNotFound()
    {
        return new ModelAndView("layout/livro404");
    }

    @GetMapping("/bibliotecario404")
    public ModelAndView bibliotecarioNotFound()
    {
        return new ModelAndView("layout/bibliotecario404");
    }
}
