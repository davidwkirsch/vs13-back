package br.com.dbc.vemser.pessoaapi.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PropertieReader {
    @Value("${admin}")
    private Boolean admin;
}
