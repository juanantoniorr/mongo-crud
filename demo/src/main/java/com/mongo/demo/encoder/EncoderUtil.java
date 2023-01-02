package com.mongo.demo.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncoderUtil {
    private EncoderUtil(){}
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encode(String text){
        return bCryptPasswordEncoder.encode(text);
    }


}
