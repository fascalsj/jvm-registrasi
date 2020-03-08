package com.jvm.aplikasiregistrasi.service;

import com.jvm.aplikasiregistrasi.entity.Materi;
import com.jvm.aplikasiregistrasi.entity.Peserta;
import com.jvm.aplikasiregistrasi.repository.MateriRepository;
import com.jvm.aplikasiregistrasi.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class MateriService {

    @Autowired
    MateriRepository materiRepository;

    public Page<Materi> findAll(Pageable pageable) {
        return materiRepository.findAll(pageable);
    }
}
