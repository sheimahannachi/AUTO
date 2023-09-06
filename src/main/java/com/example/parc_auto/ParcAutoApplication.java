package com.example.parc_auto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.parc_auto")
@EntityScan("com.example.parc_auto.entities")
@EnableJpaRepositories("com.example.parc_auto.repositories")

public class ParcAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcAutoApplication.class, args);
    }

}
