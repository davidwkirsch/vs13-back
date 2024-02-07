package br.com.dbc.vemser.pessoaapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);

        String minhaSenhaCript = "$2a$10$LMNeJo9gpeZ2mMO5BO2fGem8LWlYGIZuqsFEmg4uT09NCly6ojq2";
        boolean matches = bCryptPasswordEncoder.matches("123", minhaSenhaCript);
        System.out.println(matches);
    }
}
