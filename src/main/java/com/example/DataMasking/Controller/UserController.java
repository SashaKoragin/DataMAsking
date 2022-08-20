package com.example.DataMasking.Controller;

import com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity.User;
import com.example.DataMasking.ModelUserAndPassword.LoginAndPasswordUses;
import com.example.DataMasking.ModelUserAndPassword.UserDtoLoginAndPassword;
import com.example.DataMasking.Repository.UserRepository;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Users")

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
            NativeQuery query = session.createSQLQuery("Select NameUser,TabelNumber,LoginUser,PasswordsUser,StatusActual,IdHistory,\n" +
                                                                 "(Select Rules.NameRules From RuleAndUsers\n" +
                                                                 "Join Rules on Rules.IdRule = RuleAndUsers.IdRule\n" +
                                                                 "Where RuleAndUsers.IdUser = Users.IdUser For Xml Auto,Type\n" +
                                                                 ") From Users \n" +
                                                                 "where LoginUser = :login and PasswordsUser = :password For Xml Auto,Root('LoginAndPasswordUses')")
                    .setParameter("login", ModelLoginAndPassword.getPasswordsUser())
                    .setParameter("password",ModelLoginAndPassword.getPasswordsUser());
            var file = query.toString();
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(file));
          //  SimpleBean value = xmlMapper.readValue(xml, SimpleBean.class);
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

    public String inputStreamToString(InputStream is) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            return sb.toString();
        }
        catch (Exception e){

        }
        return null;
    }

}
