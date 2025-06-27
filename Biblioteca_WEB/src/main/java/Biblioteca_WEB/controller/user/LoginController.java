package Biblioteca_WEB.controller.user;

import Biblioteca_WEB.dto.UserDTO;
import Biblioteca_WEB.model.UserModel;
import Biblioteca_WEB.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class LoginController {

    private UserRepository userRepository;
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ModelAndView loginTemplate()
    {
        return new ModelAndView("Logar/login");
    }

    @PostMapping("/login")
    public ModelAndView loginCampos(@RequestParam String email, @RequestParam String senha)
    {
        UserModel userModel=this.userRepository.findByEmail(email);
        if(userModel!=null &&  userModel.getEmail().equals(email) && userModel.getSenha().equals(senha))
        {
            return new ModelAndView("redirect:/home/index");
        }
        else
        {
            ModelAndView mv = new ModelAndView("Logar/login");
            mv.addObject("erro","email ou senha inválidos");
            return mv;
        }
    }
}
