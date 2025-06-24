package Biblioteca_WEB.controller.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Layout {


    @GetMapping("/index")
    public ModelAndView index()
    {
        return new ModelAndView("index");
    }

    @GetMapping("/livro404")
    public ModelAndView livroNotFound()
    {
        return new ModelAndView("bibliotecario404");
    }

    @GetMapping("/bibliotecario404")
    public ModelAndView bibliotecarioNotFound()
    {
        return new ModelAndView("bibliotecario404");
    }
}
