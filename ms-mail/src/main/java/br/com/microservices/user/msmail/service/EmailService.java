package br.com.microservices.user.msmail.service;

import br.com.microservices.user.msmail.datatransferobject.UserDTO;

public interface EmailService
{

    void sendSimpleMessage(UserDTO input);

}
