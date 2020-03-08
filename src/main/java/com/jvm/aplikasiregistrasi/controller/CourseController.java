package com.jvm.aplikasiregistrasi.controller;

import com.jvm.aplikasiregistrasi.entity.Materi;
import com.jvm.aplikasiregistrasi.service.MateriService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/course")
public class CourseController {

    @Autowired
    MateriService materiService;

    @GetMapping("/list")
    public ModelMap list(Pageable pageable) {
        Page<Materi> hasilQuery = materiService.findAll(pageable);

        return new ModelMap()
                .addAttribute("daftarMateri", hasilQuery);
    }

    @GetMapping("/enroll")
    public ModelMap displayEnrollment() {
        return new ModelMap();
    }

    @PostMapping("/enroll")
    public String processEnrollment() {
        return "redirect:enrollment_confirmation";
    }

    @GetMapping("/enrollment_confirmation")
    public ModelMap displayEnrollmentConfirmation() {
        return new ModelMap();
    }
}
