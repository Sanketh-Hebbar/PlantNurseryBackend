package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.User;
import com.tc.PlantNursery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user){
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepo.save(user);
    }

    public User validateUserLogin(String email, String password) {
        User foundUser = userRepo.findByEmailAndPassword( email , password);
        // if the user does not exist
        if (foundUser == null) {


            return null;
        }
        else
        {

            return foundUser;

        }

    }
}
