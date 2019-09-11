package crud.app.controller;

import crud.app.entity.User;
import crud.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/") // будет обрабатывать все запросы по адресам с началом со слэша
public class UserController {

    @Autowired
    public UserService userService;


    // методы возвращают название темплейта во вьюхах

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    // id придёт как параметр
    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String crateUserPage() {
        return "createUser";
    }

    // а это уже не Get запрос!! но они друг другу не мешают
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
