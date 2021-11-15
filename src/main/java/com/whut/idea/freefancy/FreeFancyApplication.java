package com.whut.idea.freefancy;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LiMing
 */
@EnableSwagger2Doc
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class FreeFancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeFancyApplication.class, args);
    }

}
