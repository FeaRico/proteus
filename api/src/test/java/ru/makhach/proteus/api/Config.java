package ru.makhach.proteus.api;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// TODO: 08.09.2022 Пофиксить окружение

@SpringBootConfiguration
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan("ru.makhach.proteus")
@EnableJpaRepositories("ru.makhach.proteus")
@EntityScan("ru.makhach.proteus")
public class Config {
}
