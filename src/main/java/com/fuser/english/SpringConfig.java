package com.fuser.english;

import com.fuser.english.registration.RegistrationService;
import com.fuser.english.security.PasswordEncoder;
import com.fuser.english.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;

@Configuration
public class SpringConfig {

    @Bean
    public UserServiceImpl userService(){
        return new UserServiceImpl();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("admin");
        dataSource.setPassword("falcon873");
        dataSource.setUrl("jdbc:mysql://localhost:3306/platform?useUnicode=true&serverTimezone=UTC");

        return dataSource;
    }
}
