package com.project1.NikeClone.service.implService;

import com.project1.NikeClone.entity.User;
import com.project1.NikeClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImplLoginService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean checkAccount(String username, String password){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(!optionalUser.isPresent()){
            return false;
        }
        User user = optionalUser.get();
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public User userInfo(String username){
        return userRepository.findByUsername(username).get();
    }

//    public String loginUser(String username, String password){
//        Optional<User> optionalUser = userRepository.findByUsername(username);
//        if(!optionalUser.isPresent()){
//            return "fail";
//        }
//        User user = optionalUser.get();
//        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
//            return bCryptPasswordEncoder.e
//        }
//
//
//    }
}
