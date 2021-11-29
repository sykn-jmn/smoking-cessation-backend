package com.example.smokingcessation.service;

import com.example.smokingcessation.SmokingCessationApplication;
import com.example.smokingcessation.config.UserConfig;
import com.example.smokingcessation.model.Session;
import com.example.smokingcessation.model.SubModels;
import com.example.smokingcessation.model.User;
import com.example.smokingcessation.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UsernameValidator usernameValidator;
    private final UserService userService;
    private final SessionRepository sessionRepository;
    @Autowired
    public RegistrationService(UsernameValidator usernameValidator, UserService userService, SessionRepository sessionRepository){
        this.usernameValidator = usernameValidator;
        this.userService = userService;
        this.sessionRepository = sessionRepository;
    }

    public String register(SubModels.UserRegistration userRegistration) {
        User user = new User(
                userRegistration.getUsername(),
                userRegistration.getPassword(),
                userRegistration.getCigarette().getPrice(),
                userRegistration.getTimesADay(),
                userRegistration.getCity(),
                UserConfig.getByteArray("startPics/default.png")
        );
        user = userService.signUpUser(user);
        Session session = new Session(user.getId());
        sessionRepository.save(session);
        System.out.println(session.getUuid());
        return session.getUuid();

    }
}
