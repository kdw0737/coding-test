package com.example.myboard.email;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class EmailController {
    @PostMapping("/emailConfirm")
    public String emailConfirm(@RequestParam String email) throws Exception {
        EmailService emailService = new EmailService() {
            @Override
            public String sendSimpleMessage(String to) throws Exception {
                return null;
            }
        };

        String confirm = emailService.sendSimpleMessage(email);

        return confirm;
    }
}
