package com.gua.gmail.mail;

import java.io.ByteArrayOutputStream;

public interface MailService {

    /**
     * 发送邮件
     *
     * @param to                 目的地
     * @param subject            主题
     * @param content            内容
     * @param os                 附件
     * @param attachmentFilename 附件名
     * @throws Exception
     */
    void sendMail(String to, String subject, String content, ByteArrayOutputStream os, String attachmentFilename);
}