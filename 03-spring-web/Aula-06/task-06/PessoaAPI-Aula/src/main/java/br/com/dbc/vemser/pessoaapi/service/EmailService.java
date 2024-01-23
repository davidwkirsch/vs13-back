package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.utils.PropertieReader;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    private final PropertieReader propertieReader;
    private final JavaMailSender emailSender;

    private String to = "davidwkirsch@gmail.com";


    public void sendSimpleMessage(String to, String subject, String text) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(propertieReader.getUsernameEmail());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendWithAttachment() throws Exception {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(message,
                    true);
        } catch (MessagingException e) {
            throw new Exception(e.getMessage());
        }

        mimeMessageHelper.setFrom(propertieReader.getUsernameEmail());
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Assunto 1");
        mimeMessageHelper.setText("Meu e-mail!");

        ClassPathResource resource = new ClassPathResource("imagens/pfp.png");
        mimeMessageHelper.addAttachment(Objects.requireNonNull(resource.getFilename()), resource);

        emailSender.send(message);
    }

    public void sendEmail(PessoaDTO pessoa, String assunto, EmailTemplates template) throws Exception {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(propertieReader.getUsernameEmail());
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(getContentFromTemplate(pessoa, template), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public String getContentFromTemplate(PessoaDTO pessoaDTO, EmailTemplates template) throws IOException, TemplateException {
        Map<String, Object> dados = mapDtoToMap(pessoaDTO);

        Template emailTemplate = fmConfiguration.getTemplate(template.getFileName());
        return FreeMarkerTemplateUtils.processTemplateIntoString(emailTemplate, dados);
    }

    private Map<String, Object> mapDtoToMap(PessoaDTO pessoaDTO) {
        Map<String, Object> dados = new HashMap<>();
        Field[] fields = pessoaDTO.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                dados.put(field.getName(), field.get(pessoaDTO));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        dados.put("usernameEmail", propertieReader.getUsernameEmail());

        return dados;
    }

}