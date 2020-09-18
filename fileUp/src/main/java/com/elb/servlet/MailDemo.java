package com.elb.servlet;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailDemo {
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        Properties prop =new Properties();
        //设置QQ邮箱服务器
        prop.setProperty("mail.host","smtp.qq.com");
        //邮件发送协议
        prop.setProperty("mail.transport.protocol","smtp");
        //需要验证用户名密码
        prop.setProperty("mail.smtp.auth","true");
        //关于qq邮箱还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactory",mailSSLSocketFactory);
        //使用javamail发送邮件的五个步骤
        //创建定义整个应用程序所需的环境信息的Session对象
        //qq才有
        Session session=Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("邮箱名","授权码");
            }
        });
        session.setDebug(true);
        //通过session得到transport对象
        Transport ts = session.getTransport();

        //使用邮箱的用户名和授权码连接上邮箱服务器
        ts.connect("smtp.qq.com","邮箱名","授权码");
        //创建邮件
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("发件人邮箱"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("收件人邮箱"));
        //邮件标题
        message.setSubject("只包含文本的简单邮件");
        //邮件内容
        message.setContent("hello","text/html;charset=UTF-8");
        //发送邮件
        ts.sendMessage(message,message.getAllRecipients());
        //关闭连接
        ts.close();
    }

}
