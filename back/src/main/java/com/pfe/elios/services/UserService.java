package com.pfe.elios.services;

import com.pfe.elios.Repositories.EleveRepository;
import com.pfe.elios.Repositories.EnseignantRepository;
import com.pfe.elios.Repositories.RoleNameRepository;
import com.pfe.elios.Repositories.UserRepository;
import com.pfe.elios.Request.LoginForm;
import com.pfe.elios.Request.SignUpForm;
import com.pfe.elios.SecurityConfig.JwtUtils;
import com.pfe.elios.SecurityConfig.Response.SignInResponse;
import com.pfe.elios.entities.*;

import com.pfe.elios.exception.UserNotFoundException;
import com.pfe.elios.utils.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class UserService {





    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleNameRepository roleNameRepository;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;


    public ResponseEntity<?> addUser(UserTest user )  {


        String role = user.getRole();

        if (userRepository.findByUserName(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel("user name is used"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel(" Email is  used"), HttpStatus.BAD_REQUEST);
        }
        if (!isValidEmailAddress(user.getEmail())) {
            return new ResponseEntity<>(new ErrorModel("Invalid email"), HttpStatus.BAD_REQUEST);
        }
        if (role.equals("Eleve")) {
            Eleve eleve = new Eleve();
            if (user.getFirstName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("UserName is empty"), HttpStatus.BAD_REQUEST);
            }
            eleve.setFirstName(user.getFirstName());
            if (user.getLastName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("LastName is empty"), HttpStatus.BAD_REQUEST);
            }
            eleve.setLastName(user.getLastName());
            eleve.setAdresse(user.getAdresse());
            eleve.setEmail(user.getEmail());
            eleve.setUserName(user.getUsername());

            eleve.setNum(user.getNum());
            eleve.setNump(user.getNump());
            eleve.setGenre(user.getGenre());
            eleve.setAge(user.getAge());
            eleve.setNiveau(user.getNiveau());
            LocalDate today = LocalDate.now();
            eleve.setStarterDate(today);
            if (user.getPassword().length() < 5) {
                return new ResponseEntity<>(new ErrorModel("Short PassWord"), HttpStatus.BAD_REQUEST);
            }

            String password = passwordEncoder().encode(user.getPassword());
            eleve.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Eleve).get());
            eleve.setRole_name(rolesNameList);

            userRepository.save(eleve);
            return new ResponseEntity<>(eleve, HttpStatus.OK);


        }
        if (role.equals("Admin")) {
            Admin admin = new Admin();
            if (user.getFirstName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("UserName is empty"), HttpStatus.BAD_REQUEST);
            }
            admin.setFirstName(user.getFirstName());
            if (user.getLastName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("LastName is empty"), HttpStatus.BAD_REQUEST);
            }
            admin.setLastName(user.getLastName());
            admin.setAdresse(user.getAdresse());
            admin.setEmail(user.getEmail());
            admin.setUserName(user.getUsername());

            admin.setNum(user.getNum());
            admin.setNump(user.getNump());
            admin.setGenre(user.getGenre());
            admin.setAge(user.getAge());
            admin.setNiveau(user.getNiveau());
            LocalDate today = LocalDate.now();
            admin.setStarterDate(today);
            if (user.getPassword().length() < 5) {
                return new ResponseEntity<>(new ErrorModel("Short PassWord"), HttpStatus.BAD_REQUEST);
            }
            String password = passwordEncoder().encode(user.getPassword());
            admin.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Admin).get());
            admin.setRole_name(rolesNameList);
            userRepository.save(admin);
            return new ResponseEntity<>(admin, HttpStatus.OK);


        }


        if (role.equals("Enseignant")) {

            Enseignant enseignant = new Enseignant();
            enseignant.setFirstName(user.getFirstName());
            enseignant.setLastName(user.getLastName());
            enseignant.setAdresse(user.getAdresse());
            enseignant.setEmail(user.getEmail());
            LocalDate today = LocalDate.now();
            enseignant.setStarterDate(today);
            enseignant.setNum(user.getNum());
            enseignant.setCin(user.getCin());
            enseignant.setGenre(user.getGenre());
            enseignant.setUserName(user.getUsername());
            String password = passwordEncoder().encode(user.getPassword());
            enseignant.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Enseignant).get());
            enseignant.setRole_name(rolesNameList);

            userRepository.save(enseignant);
            return new ResponseEntity<>(enseignant, HttpStatus.OK);


        }
        return new ResponseEntity<>(new ErrorModel("Role is empty"), HttpStatus.BAD_REQUEST);


    }


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public ResponseEntity<?> signUp(SignUpForm signUpForm) {
        String role = signUpForm.getRole();

        if (userRepository.findByUserName(signUpForm.getUsername()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel("user name is used"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(signUpForm.getEmail()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel(" Email is  used"), HttpStatus.BAD_REQUEST);
        }
        if (!isValidEmailAddress(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ErrorModel("Invalid email"), HttpStatus.BAD_REQUEST);
        }
        if (role.equals("Eleve")) {
            Eleve eleve = new Eleve();
            if (signUpForm.getFirstName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("UserName is empty"), HttpStatus.BAD_REQUEST);
            }
            eleve.setFirstName(signUpForm.getFirstName());
            if (signUpForm.getLastName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("LastName is empty"), HttpStatus.BAD_REQUEST);
            }
            eleve.setLastName(signUpForm.getLastName());
            eleve.setAdresse(signUpForm.getAdresse());
            eleve.setEmail(signUpForm.getEmail());
            eleve.setUserName(signUpForm.getUsername());

            eleve.setNum(signUpForm.getNum());
            eleve.setNump(signUpForm.getNump());
            eleve.setGenre(signUpForm.getGenre());
            eleve.setAge(signUpForm.getAge());
            eleve.setNiveau(signUpForm.getNiveau());
            LocalDate today = LocalDate.now();
            eleve.setStarterDate(today);
            if (signUpForm.getPassword().length() < 5) {
                return new ResponseEntity<>(new ErrorModel("Short PassWord"), HttpStatus.BAD_REQUEST);
            }
            String password = passwordEncoder().encode(signUpForm.getPassword());
            eleve.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Eleve).get());
            eleve.setRole_name(rolesNameList);
            userRepository.save(eleve);
            return new ResponseEntity<>(eleve, HttpStatus.OK);


        }
        if (role.equals("Enseignant")) {

            Enseignant enseignant = new Enseignant();
            enseignant.setFirstName(signUpForm.getFirstName());
            enseignant.setLastName(signUpForm.getLastName());
            enseignant.setAdresse(signUpForm.getAdresse());
            enseignant.setEmail(signUpForm.getEmail());
            LocalDate today = LocalDate.now();
            enseignant.setStarterDate(today);
            enseignant.setNum(signUpForm.getNum());
            enseignant.setCin(signUpForm.getCin());
            enseignant.setGenre(signUpForm.getGenre());
            enseignant.setUserName(signUpForm.getUsername());
            String password = passwordEncoder().encode(signUpForm.getPassword());
            enseignant.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Enseignant).get());
            enseignant.setRole_name(rolesNameList);
            userRepository.save(enseignant);
            return new ResponseEntity<>(enseignant, HttpStatus.OK);


        }
        return new ResponseEntity<>(new ErrorModel("Role is empty"), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<?> signIn(LoginForm loginform) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginform.getUsername(), loginform.getPassword()));


        String jwt = jwtUtils.generateToken(loginform.getUsername());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<>(new SignInResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()), HttpStatus.ACCEPTED);
    }
    public ResponseEntity<?> updateUser(long id, User updatedUser) {
        Optional<User> UserOptional = userRepository.findById(id);
        if(!UserOptional.isPresent())
            return new ResponseEntity<>(new ErrorModel("wrong user id "),HttpStatus.BAD_REQUEST);

        User databaseUser = UserOptional.get();

        if(updatedUser.getAdresse() != null)
            if (updatedUser.getAdresse().length() < 3)
                return new ResponseEntity<>(new ErrorModel("wrong user name"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setFirstName(updatedUser.getFirstName());

        if(updatedUser.getFirstName() != null)
            if (updatedUser.getFirstName().length() < 3)
                return new ResponseEntity<>(new ErrorModel("wrong user name"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setFirstName(updatedUser.getFirstName());

        if(updatedUser.getLastName() != null)
            if (updatedUser.getLastName().length() < 3)
                return new ResponseEntity<>(new ErrorModel("Invalid LastName"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setLastName(updatedUser.getLastName());


        if (updatedUser.getPassword().length()<5){
            return  new ResponseEntity<>(new ErrorModel("Short PassWord"),HttpStatus.BAD_REQUEST); }
        String password = passwordEncoder().encode(updatedUser.getPassword());
        databaseUser.setPassword(password);


        if (userRepository.findByEmail(updatedUser.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST); }

        if(!isValidEmailAddress(updatedUser.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }
        databaseUser.setEmail(updatedUser.getEmail());

        databaseUser.setPhotoBytes(updatedUser.getPhotoBytes());
        databaseUser.setCin(updatedUser.getCin());
        databaseUser.setSalaire(updatedUser.getSalaire());
        databaseUser.setAdresse(updatedUser.getAdresse());
        databaseUser.setAge(updatedUser.getAge());
        databaseUser.setGenre(updatedUser.getGenre());
        databaseUser.setNum(updatedUser.getNum());
        databaseUser.setNump(updatedUser.getNump());
        databaseUser.setStarterDate(updatedUser.getStarterDate());
        databaseUser.setSalaire(updatedUser.getSalaire());
        userRepository.save(databaseUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public List<User> findAllUsers() {

        return userRepository.findAll();



    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }


    public List<Eleve> findAllEleves() {
        return eleveRepository.findAll();
    }


    public List<Enseignant> findAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Eleve addEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public User findUserById(Long id) {
        return (User) userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }



    public User findUser(String userName) {
        return (User) userRepository.findByUserName(userName)
                .orElseThrow(() -> new UserNotFoundException("User by id " + userName + " was not found"));
    }

    public ResponseEntity<?> addUser1(User user) {


        String role = user.getRole();

        if (userRepository.findByUserName(user.getUserName()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel("user name is used"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel(" Email is  used"), HttpStatus.BAD_REQUEST);
        }
        if (!isValidEmailAddress(user.getEmail())) {
            return new ResponseEntity<>(new ErrorModel("Invalid email"), HttpStatus.BAD_REQUEST);
        }
        if (role.equals("Eleve")) {
            Eleve eleve = new Eleve();
            if (user.getFirstName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("UserName is empty"), HttpStatus.BAD_REQUEST);
            }
            eleve.setFirstName(user.getFirstName());
            if (user.getLastName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("LastName is empty"), HttpStatus.BAD_REQUEST);
            }
            eleve.setLastName(user.getLastName());
            eleve.setAdresse(user.getAdresse());
            eleve.setEmail(user.getEmail());
            eleve.setUserName(user.getUserName());

            eleve.setNum(user.getNum());
            eleve.setNump(user.getNump());
            eleve.setGenre(user.getGenre());
            eleve.setAge(user.getAge());
            eleve.setNiveau(user.getNiveau());
            LocalDate today = LocalDate.now();
            eleve.setStarterDate(today);
            if (user.getPassword().length() < 5) {
                return new ResponseEntity<>(new ErrorModel("Short PassWord"), HttpStatus.BAD_REQUEST);
            }

            String password = passwordEncoder().encode(user.getPassword());
            eleve.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Eleve).get());
            eleve.setRole_name(rolesNameList);

            userRepository.save(eleve);
            return new ResponseEntity<>(eleve, HttpStatus.OK);


        }
        if (role.equals("Admin")) {
            Admin admin = new Admin();
            if (user.getFirstName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("UserName is empty"), HttpStatus.BAD_REQUEST);
            }
            admin.setFirstName(user.getFirstName());
            if (user.getLastName().length() == 0) {
                return new ResponseEntity<>(new ErrorModel("LastName is empty"), HttpStatus.BAD_REQUEST);
            }
            admin.setLastName(user.getLastName());
            admin.setAdresse(user.getAdresse());
            admin.setEmail(user.getEmail());
            admin.setUserName(user.getUserName());

            admin.setNum(user.getNum());
            admin.setNump(user.getNump());
            admin.setGenre(user.getGenre());
            admin.setAge(user.getAge());
            admin.setNiveau(user.getNiveau());
            LocalDate today = LocalDate.now();
            admin.setStarterDate(today);
            if (user.getPassword().length() < 5) {
                return new ResponseEntity<>(new ErrorModel("Short PassWord"), HttpStatus.BAD_REQUEST);
            }
            String password = passwordEncoder().encode(user.getPassword());
            admin.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Admin).get());
            admin.setRole_name(rolesNameList);
            userRepository.save(admin);
            return new ResponseEntity<>(admin, HttpStatus.OK);


        }


        if (role.equals("Enseignant")) {

            Enseignant enseignant = new Enseignant();
            enseignant.setFirstName(user.getFirstName());
            enseignant.setLastName(user.getLastName());
            enseignant.setAdresse(user.getAdresse());
            enseignant.setEmail(user.getEmail());
            LocalDate today = LocalDate.now();
            enseignant.setStarterDate(today);
            enseignant.setNum(user.getNum());
            enseignant.setCin(user.getCin());
            enseignant.setGenre(user.getGenre());
            enseignant.setUserName(user.getUserName());
            String password = passwordEncoder().encode(user.getPassword());
            enseignant.setPassword(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Enseignant).get());
            enseignant.setRole_name(rolesNameList);

            userRepository.save(enseignant);
            return new ResponseEntity<>(enseignant, HttpStatus.OK);


        }
        return new ResponseEntity<>(new ErrorModel("Role is empty"), HttpStatus.BAD_REQUEST);


    }




}



