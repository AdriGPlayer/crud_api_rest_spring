package crud.crud_mysql_api.controllers;

import crud.crud_mysql_api.models.UserModel;
import crud.crud_mysql_api.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel){
        return this.userService.saveUser(userModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable long id){
        return this.userService.getByID(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel userModel, @PathVariable long id){
        return this.userService.updateById(userModel, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable long id){
        this.userService.deleteUser(id);
        return "usuario eliminado";

    }





}
