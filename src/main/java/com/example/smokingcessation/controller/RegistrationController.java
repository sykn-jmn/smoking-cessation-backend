package com.example.smokingcessation.controller;

import com.example.smokingcessation.model.SubModels;
import com.example.smokingcessation.model.User;
import com.example.smokingcessation.service.CigaretteService;
import com.example.smokingcessation.service.PostService;
import com.example.smokingcessation.service.RegistrationService;
import com.example.smokingcessation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@RestController
public class RegistrationController {
    private final RegistrationService registrationService;
    private final UserService userService;
    @Autowired
    public RegistrationController(RegistrationService registrationService, UserService userService){
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @PostMapping(
            value = "/registerUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> createUser(@RequestBody SubModels.UserRegistration userRegistration){
        return new ResponseEntity<>(registrationService.register(userRegistration), HttpStatus.OK);
    }

    @PostMapping(
            value = "/updateProfileImage",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Boolean> createUser(@RequestBody SubModels.ProfileImageUpdate profileImageUpdate){
        return new ResponseEntity<>(userService.updateProfileImage(profileImageUpdate),HttpStatus.OK);
    }
}
