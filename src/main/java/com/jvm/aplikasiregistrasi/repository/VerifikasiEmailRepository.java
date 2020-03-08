package com.jvm.aplikasiregistrasi.repository;

import com.jvm.aplikasiregistrasi.entity.Peserta;
import com.jvm.aplikasiregistrasi.entity.VerifikasiEmail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VerifikasiEmailRepository extends PagingAndSortingRepository<VerifikasiEmail, String> {
    VerifikasiEmail findByToken(String token);
}
