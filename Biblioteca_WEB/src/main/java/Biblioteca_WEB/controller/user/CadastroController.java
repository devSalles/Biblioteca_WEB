package Biblioteca_WEB.controller.user;

import Biblioteca_WEB.model.UserModel;
import Biblioteca_WEB.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class CadastroController {

    private UserRepository userRepository;

    public CadastroController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastroTemplate()
    {
        ModelAndView mv = new ModelAndView("cadastrar/cadastro");
        mv.addObject("userDados",new UserModel());
        return mv;
    }

//    @PostMapping("/")
}
