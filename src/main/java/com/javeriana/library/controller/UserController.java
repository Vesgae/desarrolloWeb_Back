package com.javeriana.library.controller;
import com.javeriana.library.dto.Mensaje;
import com.javeriana.library.entity.User;
import com.javeriana.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User currentUser = userService.getUser(id).get();
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    @DeleteMapping("/users")
    public ResponseEntity<?> deleteUser(@RequestParam Long id){
        if (!userService.existsByIdUser(id))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        userService.deleteUser(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity(new Mensaje("Usuario Creado"), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user){
        User currentUser = userService.getUser(id).get();
        currentUser.setName(user.getName());
        currentUser.setLast_name(user.getLast_name());
        currentUser.setBirthday(user.getBirthday());
        currentUser.setRole(user.getRole());
        userService.saveUser(currentUser);
        return new ResponseEntity(new Mensaje("Usuario Actualizado"), HttpStatus.OK);
    }

}
