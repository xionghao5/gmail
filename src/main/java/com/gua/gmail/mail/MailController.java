package com.gua.gmail.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/hello")
    public String test() {
        return "hello world!";
    }

    @GetMapping("/mail/test")
    public String sendMail(String email) {
        mailService.sendMail(email, "测试邮件", "测试邮件，不要回复,小心密码泄露", null, null);
        return "success";
    }
}