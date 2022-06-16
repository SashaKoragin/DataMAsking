package com.example.DataMasking.Controller;

import com.example.DataMasking.DataBaseEntity.User;
import com.example.DataMasking.ModelUserAndPassword.UserDtoLoginAndPassword;
import com.example.DataMasking.Repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity getUsers(){
        try {

            return ResponseEntity.ok("Сервер работает!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка!!!");
        }
    }


    @RequestMapping(value = "/Add_Users", headers = {
            "content-type=application/json" },
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)

    public ResponseEntity registration(@RequestBody User user){
        try {
            userRepository.save(user);
            return ResponseEntity.ok("Пользователь был успешно сохранен!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка!!!");
        }
    }




    @RequestMapping(value = "/AutoIdentification", headers = {
            "content-type=application/json" },
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity AutoIdentification(@RequestBody UserDtoLoginAndPassword ModelLoginAndPassword){
        Configuration configuration = new org.hibernate.cfg.Configuration();
        List<User> list = new ArrayList<>();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            NativeQuery query = session.createSQLQuery("Select * From Users where ");
            list = query.list();
            session.beginTransaction();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
             return ResponseEntity.badRequest().body("Произошла ошибка!!!");
        }finally {
            session.close();
            sessionFactory.close();
        }
        return  ResponseEntity.ok(list);
    }

}
