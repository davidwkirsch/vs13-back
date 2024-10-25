package br.com.dbc.vemser.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
