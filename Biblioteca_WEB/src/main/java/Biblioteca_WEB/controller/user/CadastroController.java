package Biblioteca_WEB.controller.user;

import Biblioteca_WEB.dto.UserDTO;
import Biblioteca_WEB.model.UserModel;
import Biblioteca_WEB.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        mv.addObject("userDTO",new UserModel());
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView cadastroCampos(@Valid @ModelAttribute("userDTO")UserDTO userDTO, BindingResult bindingResult)
    {
        ModelAndView mv = new ModelAndView("cadastrar/cadastro");
        //bindingResult para garantir a validação dos dados
        if(bindingResult.hasErrors())
        {
            mv.addObject("userDTO",userDTO);
            return mv;
        }
        //Verificação de existência de usuário
        if(userRepository.findByEmail(userDTO.getEmail())!=null)
        {
            mv.addObject("erro","email já está em uso");
            return mv;
        }
        if(userRepository.findBySenha(userDTO.getSenha())!=null)
        {
            mv.addObject("erro","escolha outra senha");
            return mv;
        }
        //toUser -> Conversão de dados para o Model
        UserModel userModel=userDTO.toUser();
        this.userRepository.save(userModel);

        return new ModelAndView("redirect:/user/login");
    }
}
