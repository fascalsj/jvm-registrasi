package com.jvm.aplikasiregistrasi.service;

import com.jvm.aplikasiregistrasi.entity.Peserta;
import com.jvm.aplikasiregistrasi.entity.VerifikasiEmail;
import com.jvm.aplikasiregistrasi.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service @Transactional
public class PesertaService {

    @Autowired
    PesertaRepository pesertaRepository;

    @Value("${token.expiry.days}")
    private Integer tokenExpiryDays;

    public Peserta create(Peserta peserta) {
        return pesertaRepository.save(peserta);
    }
}
