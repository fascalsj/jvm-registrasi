package com.jvm.aplikasiregistrasi.service;

import com.jvm.aplikasiregistrasi.entity.Peserta;
import com.jvm.aplikasiregistrasi.entity.VerifikasiEmail;
import com.jvm.aplikasiregistrasi.repository.VerifikasiEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class VerificationEmailService {

    @Value("${token.expiry.days}")
    private Integer tokenExpiryDays;

    @Autowired
    private VerifikasiEmailRepository verifikasiEmailRepository;

    public VerifikasiEmail create(VerifikasiEmail verifikasiEmail) {
        verifikasiEmail.setToken(UUID.randomUUID().toString());
        verifikasiEmail.setExpire(LocalDateTime.now().plusDays(tokenExpiryDays));
        return verifikasiEmailRepository.save(verifikasiEmail);
    }

    public VerifikasiEmail findVerifikasiEmailByToken(String token) {
        return verifikasiEmailRepository.findByToken(token);
    }

    public void delete(VerifikasiEmail verifikasiEmail) {
        verifikasiEmailRepository.delete(verifikasiEmail);
    }
}
