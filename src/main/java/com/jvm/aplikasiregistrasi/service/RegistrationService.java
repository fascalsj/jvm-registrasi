package com.jvm.aplikasiregistrasi.service;

import com.jvm.aplikasiregistrasi.entity.Peserta;
import com.jvm.aplikasiregistrasi.entity.VerifikasiEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    PesertaService pesertaService;

    @Autowired
    VerificationEmailService verificationEmailService;

    public void registrasiPesertaBaru(Peserta peserta) {
        pesertaService.create(peserta);
        VerifikasiEmail verifikasiEmail = new VerifikasiEmail();
        verifikasiEmail.setPeserta(peserta);
        verificationEmailService.create(verifikasiEmail);
    }

    public void verifikasiToken(String token) {
        VerifikasiEmail verifikasiEmail = verificationEmailService.findVerifikasiEmailByToken(token);
        if (verifikasiEmail != null) {
            Peserta peserta = verifikasiEmail.getPeserta();
            peserta.setEmailTerverifikasi(true);
            verificationEmailService.delete(verifikasiEmail);
        }
    }


}
