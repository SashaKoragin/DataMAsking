package com.example.DataMasking.Controller;

import com.example.DataMasking.DataBaseEntity.User;
import com.example.DataMasking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    @RequestMapping(value = "/Add_Users", headers = {
            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity registration(@RequestBody User user){
        try {
            userRepository.save(user);
            return ResponseEntity.ok("Пользователь был успешно сохранен!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка!!!");
        }
    }

    @GetMapping("/")
    public ResponseEntity getUsers(){
        try {
            return ResponseEntity.ok("Сервер работает!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка!!!");
        }
    }
//    @RequestMapping(value = "/AutoIdentification", headers = {
//            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//    public User AutoIdentification(String login, String password){
//
//    }
}
