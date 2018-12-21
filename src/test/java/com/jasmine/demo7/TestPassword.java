package com.jasmine.demo7;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPassword {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void test() {
        String passwd = stringEncryptor.encrypt("root");
        System.out.println(passwd);
    }
}

