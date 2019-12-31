package be.intecbrussel.cruddemo.cruddemo.Controllers;

import be.intecbrussel.cruddemo.cruddemo.entities.User;
import be.intecbrussel.cruddemo.cruddemo.repositories.userRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private userRepository repo;

    @GetMapping("/signup")
    public String showsSignUpForm(User user){
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
       if(result.hasErrors()){
           return "add-user";
       }

        repo.save(user);
       model.addAttribute("users", repo.findAll());
       return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        User user = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    //Update user
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        repo.save(user);
        model.addAttribute("users", repo.findAll());
        return "index";
    }


    //Delete user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repo.delete(user);
        model.addAttribute("users", repo.findAll());
        return "index";
    }


}
