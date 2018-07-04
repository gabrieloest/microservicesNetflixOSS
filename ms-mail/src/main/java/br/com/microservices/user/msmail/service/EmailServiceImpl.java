package br.com.microservices.user.msmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.com.microservices.user.msmail.dataaccessobject.MailRepository;
import br.com.microservices.user.msmail.datatransferobject.UserDTO;
import br.com.microservices.user.msmail.domainobject.MailDO;

public class EmailServiceImpl implements EmailService
{

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public MailRepository mailRepository;


    @Override
    public void sendSimpleMessage(UserDTO input)
    {
        try
        {

            MailDO newMail = new MailDO();
            newMail.setTo(input.getUserName());
            newMail.setSubject("TestSubject");
            newMail.setText("TestText");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(newMail.getTo());
            message.setSubject(newMail.getSubject());
            message.setText(newMail.getText());

            this.mailRepository.save(newMail);
            this.emailSender.send(message);
        }
        catch (MailException exception)
        {
            exception.printStackTrace();
        }
    }
}
