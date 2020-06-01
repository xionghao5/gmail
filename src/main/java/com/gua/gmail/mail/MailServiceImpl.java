package com.gua.gmail.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendMail(String to, String subject, String content, ByteArrayOutputStream os, String attachmentFilename) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            if (null != os) {
                //附件
                InputStreamSource inputStream = new ByteArrayResource(os.toByteArray());
                helper.addAttachment(attachmentFilename, inputStream);
            }

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}