package br.com.microservices.user.msmail.domainobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "\"mail\"")
public class MailDO
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Size(min = 1, message = "Please, set recipient email address to send the message")
    private String to;
    private String subject;
    private String text;


    public String getTo()
    {
        return this.to;
    }


    public void setTo(String to)
    {
        this.to = to;
    }


    public String getSubject()
    {
        return this.subject;
    }


    public void setSubject(String subject)
    {
        this.subject = subject;
    }


    public String getText()
    {
        return this.text;
    }


    public void setText(String text)
    {
        this.text = text;
    }
}
