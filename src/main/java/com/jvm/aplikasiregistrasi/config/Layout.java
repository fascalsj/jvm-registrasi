package com.jvm.aplikasiregistrasi.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;

public class Layout {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
