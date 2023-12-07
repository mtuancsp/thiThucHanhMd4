package com.example.thithuchanhmd4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ThiThucHanhMd4Application {

    public static void main(String[] args) {
        SpringApplication.run(ThiThucHanhMd4Application.class, args);
    }

}
