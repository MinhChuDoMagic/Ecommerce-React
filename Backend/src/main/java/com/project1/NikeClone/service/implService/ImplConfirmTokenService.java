package com.project1.NikeClone.service.implService;

import com.project1.NikeClone.entity.ConfirmToken;
import com.project1.NikeClone.repository.ConfirmTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImplConfirmTokenService {
    private final ConfirmTokenRepository confirmTokenRepository;

    public void saveConfirmationToken(ConfirmToken token) {
        confirmTokenRepository.save(token);
    }

    public Optional<ConfirmToken> getToken(String token) {
        return confirmTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmTokenRepository.updateConfirmAt(
                token, LocalDateTime.now());
    }
}
