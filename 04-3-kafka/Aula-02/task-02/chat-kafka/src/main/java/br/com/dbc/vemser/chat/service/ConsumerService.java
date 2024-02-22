package br.com.dbc.vemser.chat.service;

import br.com.dbc.vemser.chat.dto.MensagemDTO;
import br.com.dbc.vemser.chat.dto.NomeChat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;

    private final String P_GERAL = "0";
    private final String P_PRIVADA = "8";

    @KafkaListener(
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {P_GERAL})},
            clientIdPrefix = "geral"
    )
    public void consumeChatGeral(@Payload String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
            log.info("{} [{}] : {}",
                    mensagemDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                    mensagemDTO.getUsuario(),
                    mensagemDTO.getMensagem());
    }

    @KafkaListener(
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {P_PRIVADA})},
            clientIdPrefix = "privado"
    )
    public void consumeMeuChat(@Payload String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("{} [{}] (privado): {}",
                mensagemDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                mensagemDTO.getUsuario(),
                mensagemDTO.getMensagem());
    }
}
