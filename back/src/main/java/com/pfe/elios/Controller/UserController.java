package com.pfe.elios.Controller;

import com.fasterxml.jackson.databind.JsonMappingException;

import com.pfe.elios.Repositories.UserRepository;
import com.pfe.elios.Request.LoginForm;
import com.pfe.elios.Request.SignUpForm;
import com.pfe.elios.entities.*;
import com.pfe.elios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;


@Controller
@Transactional
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;





    @PostMapping("/auth/Register")
    public ResponseEntity<?> signUp(@RequestBody SignUpForm signUpForm) {
        return userService.signUp(signUpForm);
    }


    @PostMapping("auth/addUser")

    public ResponseEntity<?> addUserr(@RequestBody UserTest user )  {
        return ResponseEntity.ok(userService.addUser(user ));
    }

    @PostMapping("auth/addUuser")
    public ResponseEntity<?> addUser1(@RequestBody User user) {
        return userService.addUser1(user);
    }

    @GetMapping("auth/finde/{userName}")
    public ResponseEntity<User> getUser (@PathVariable("userName") String userName) {
        User user = userService.findUser(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("auth/updateById/{id}")
    public ResponseEntity<?> updateUser(@PathVariable ("id") long id, @RequestBody User updatedUser){
        return userService.updateUser(id,updatedUser);
    }



    /*@PutMapping("auth/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ("id") Long id , @RequestBody User user) {

        User user = userRepository.findById(id).get();
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser ,HttpStatus.OK);
    }
    */


    @PostMapping("auth/signIn")
    public ResponseEntity<?> signIn(@RequestBody LoginForm loginForm) {
        return userService.signIn(loginForm);
    }

    @GetMapping("auth/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> Users = userService.findAllUsers();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @DeleteMapping("auth/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/auth/alleleves")
    public ResponseEntity<List<Eleve>> getAllEleves() {
        List<Eleve> Eleves = userService.findAllEleves();
        return new ResponseEntity<>(Eleves, HttpStatus.OK);
    }
    @GetMapping("/auth/allenseig")
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> Enseignants = userService.findAllEnseignants();
        return new ResponseEntity<>(Enseignants, HttpStatus.OK);
    }

    @PostMapping("/auth/addEleve")
    public ResponseEntity<User> addEleve(@RequestBody Eleve eleve) {
        Eleve newEleve = userService.addEleve(eleve);
        return new ResponseEntity<>(newEleve, HttpStatus.CREATED);
    }

    @PostMapping("/auth/addEnseignant")
    public ResponseEntity<User> addEnseignant(@RequestBody Enseignant enseignant) {
        Enseignant newEnseignant = userService.addEnseignant(enseignant);
        return new ResponseEntity<>(newEnseignant, HttpStatus.CREATED);
    }


  /* @PutMapping(value="auth/updateph/{id}")
    public ResponseEntity<?> ModifierUserPhoto(@PathVariable("id")Long id ,

                                               @RequestParam("file") MultipartFile file ) {
      // User user = new User();
       User user = userRepository.findById(id).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String message = "";
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            user.setImageUrl(Base64.getEncoder().encodeToString(file.getBytes()));
            message = "User Photo Modifier successfully! " + file.getOriginalFilename();
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseEntity(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            message = "Could not upload the Photo: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseEntity(HttpStatus.OK));
        }


    }
*/





    /* @GetMapping("/find/{id}")
     public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
         User user = userService.findUserById(id);
         return new ResponseEntity<>(user, HttpStatus.OK);
     }

     */
    @PutMapping("auth/editProfile/{idU}")
    public ResponseEntity<User> editProfile(@PathVariable("idU") Long id
            , @RequestBody User user ) throws JsonParseException, JsonMappingException, Exception {
        // User u = new ObjectMapper().readValue(user, User.class);
        User oldUser = userRepository.getById(id);
        oldUser.setPhotoBytes(user.getPhotoBytes());
     /*  if (file != null) {
           System.out.println("file changing ...");
           u.setPhotoBytes(file.getBytes());
       } else {
           u.setPhotoBytes(oldUser.getPhotoBytes());/*
       }*/
        return (ResponseEntity<User>) userService.updateUser(id,oldUser);
    }
    @GetMapping("auth/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
  /* @GetMapping("auth/finnd/{id}")
    public ResponseEntity<UserTest> getUserrById (@PathVariable("id") Long id) {
        User usertest = userService.findUserById(id);
        return new ResponseEntity<>(usertest, HttpStatus.OK);
    }*/



}


