package com.elb.servlet;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailDemo2 {
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
        message.setSubject("带图片的邮件");
        //准备邮件数据
        MimeBodyPart img = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("图片路径"));
        img.setDataHandler(dh);//body中放入图片数据
        img.setContentID("bz.jpg");
        //正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封带图片的邮件<img src='cid:bz.jpg'/>","text/html;charset=UTF-8");
        //数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(img);
        mm.setSubType("related");
        message.setContent(mm);//把最后编辑好的邮件放到信息中
        message.saveChanges();
        //发送邮件
        ts.sendMessage(message,message.getAllRecipients());
        //关闭连接
        ts.close();
    }
}
