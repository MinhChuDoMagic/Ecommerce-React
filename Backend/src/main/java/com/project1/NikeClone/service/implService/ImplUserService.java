package com.project1.NikeClone.service.implService;

import com.project1.NikeClone.entity.ConfirmToken;
import com.project1.NikeClone.entity.User;
import com.project1.NikeClone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImplUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with username %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ImplConfirmTokenService implConfirmTokenService;

    @Override
    public UserDetails loadUserByUsername(String user_username) throws UsernameNotFoundException {
        return userRepository.findByUsername(user_username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, user_username)));
    }

    public String signUpUser(User user)  {
        boolean userExists = userRepository
                .findByUsername(user.getUsername())
                .isPresent();

        if(userExists){
            throw new IllegalStateException("username already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmToken confirmToken = new ConfirmToken(token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        implConfirmTokenService.saveConfirmationToken(confirmToken);

        return token;
    }

    public int enableUser(String username) {
        return userRepository.enableUser(username);
    }
}
