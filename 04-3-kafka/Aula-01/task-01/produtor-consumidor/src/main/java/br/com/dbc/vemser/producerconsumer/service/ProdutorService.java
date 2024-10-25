package br.com.dbc.vemser.producerconsumer.service;

import br.com.dbc.vemser.producerconsumer.dto.ReceitaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic; //meu-primeiro-topico

    public void enviarMensagem(String mensagem) {
        send(mensagem, null);
    }

    public void enviarReceita(ReceitaDTO receitaDTO, Integer particao) throws JsonProcessingException {
        String mensagem = objectMapper.writeValueAsString(receitaDTO);
        send(mensagem, particao);
    }

    private void send(String messageStr, Integer particao) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(messageStr)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        if (particao != null) {
            stringMessageBuilder
                    .setHeader(KafkaHeaders.PARTITION_ID, particao);
        }
        Message<String> message = stringMessageBuilder.build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", messageStr);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", messageStr, ex);
            }
        });
    }
}
