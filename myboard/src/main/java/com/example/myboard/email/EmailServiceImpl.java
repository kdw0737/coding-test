package com.example.myboard.email;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender emailSender;

    public static final String ePw = createKey();

    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rd = new Random();

        for (int i = 0; i < 8; i++) { //인증코드 8자리
            int index = rd.nextInt(3); //0~2까지 랜덤생성

            switch (index) {
                case 0:
                    //a~z 까지 랜덥생성
                    key.append((char) ((int) (rd.nextInt(26)) + 97));
                    break;

                case 1:
                    //A~Z 까지 랜덤생성
                    key.append((char) ((int) (rd.nextInt(26)) + 65));
                    break;

                case 2:
                    //0~9 까지 랜덤생성
                    key.append((rd.nextInt(10)));
                    break;
            }
        }
        return key.toString();
    }

    private MimeMessage createMessage(String to) throws Exception {
        System.out.println("보내는 대상" + to);
        System.out.println("인증 번호" + ePw);
        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, to); //보내는 대상
        message.setSubject("헐레벌떡 회원가입 이메일 인증입니다."); //제목

        String msg = "";
        msg+= "<div style='margin:100px;'>";
        msg+= "<h1> 안녕하세요 헐레벌떡입니다. </h1>";
        msg+= "<br>";
        msg+= "<p>아래 인증코드를 인증창에 입력해주세요.<p>";
        msg+= "<br>";
        msg+= "<p>감사합니다!<p>";
        msg+= "<br>";
        msg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msg+= "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msg+= "<div style='font-size:130%'>";
        msg+= "CODE : <strong>";
        msg+= ePw+"</strong><div><br/> ";
        msg+= "</div>";
        message.setText(msg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("kdw981129@gmail.com","Babble"));//보내는 사람

        return message;
    }

    @Override
    public String sendSimpleMessage(String to) throws Exception {
        // TODO Auto-generated method stub
        MimeMessage message = createMessage(to);
        try {
            emailSender.send(message);
        } catch (MailException es) {
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return ePw;
    }
}
