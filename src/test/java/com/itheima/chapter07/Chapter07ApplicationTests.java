package com.itheima.chapter07;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class Chapter07ApplicationTests {
@Autowired
private PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
       String s1= passwordEncoder.encode("123456");
        System.out.println(s1);
       String s2= passwordEncoder.encode("654321");
    }


}


