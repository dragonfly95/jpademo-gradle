package com.example.jpademo.web;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class JpaRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("argsdddd = " + args);
    }
}
