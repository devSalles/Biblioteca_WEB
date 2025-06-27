package Biblioteca_WEB.controller.user;

import Biblioteca_WEB.dto.UserDTO;
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
    public ModelAndView loginTemplate(@Valid @ModelAttribute("userDTO")UserDTO userDTO)
    {
        return new ModelAndView("Login/login");
    }

    @PostMapping("/login")
    public ModelAndView loginCampos(@RequestParam String email, @RequestParam String senha)
    {
        return userRepository.findByEmailAndSenha(email, senha)
                .map(userModel -> new ModelAndView("redirect:/layout/index"))
                .orElseGet(() -> { ModelAndView mv = new ModelAndView("Login/login");
                mv.addObject("erro","email ou senha inválido");
                return mv;
                });
    }
}
