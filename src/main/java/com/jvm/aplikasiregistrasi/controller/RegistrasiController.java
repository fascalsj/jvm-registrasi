package com.jvm.aplikasiregistrasi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class RegistrasiController {

    @GetMapping("/registrasi")
    public ModelMap tampilanFormRegistrasi() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("nama", "Fascal");
        modelMap.addAttribute("waktu", LocalDateTime.now());
        return modelMap;
    }

    @PostMapping("/registrasi")
    public String prosesFormRegistrasi() {
        return "redirect:konfirmasi";
    }

    @GetMapping("/konfirmasi")
    public void tampilkanHalamanKonfirmasi() {

    }

}
