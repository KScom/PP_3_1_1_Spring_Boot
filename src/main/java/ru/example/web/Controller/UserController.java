package ru.example.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.example.web.Model.User;
import ru.example.web.Services.UserServices;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @GetMapping
    private String index(Model model){
        model.addAttribute("users", userServices.getAllUsers());
        return "user/index";
    }

    @GetMapping("/new")
    private String newUser(@ModelAttribute("user") User user){
        return "user/new";
    }

    @PostMapping("/")
    private String createUser(@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return "user/new";

        userServices.createUser(user);
        return "redirect:/";
    }


    @GetMapping("/{id}")
    private String viewUser(@PathVariable int id, Model model){

        model.addAttribute("user", userServices.getUser(id));
        return "user/view";
    }

    @PatchMapping("/{id}")
    private String updateUser(@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult){

        if(!bindingResult.hasErrors())
            userServices.updateUser(user);

        return "user/view";
    }

    @DeleteMapping("/{id}")
    private String deleteUser(@PathVariable int id){

        userServices.deleteUser(id);
        return "redirect:/";
    }
}
