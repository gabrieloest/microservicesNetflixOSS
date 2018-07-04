package br.com.microservices.user.msuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.microservices.user.msuser.dataaccessobject.UserRepository;
import br.com.microservices.user.msuser.domainobject.UserDO;
import br.com.microservices.user.msuser.sender.Sender;

@Service
public class DefaultUserService implements UserService
{
    private final UserRepository userRepository;

    @Value("${spring.kafka.topic.userCreated}")
    private static String USER_CREATED_TOPIC;

    private Sender sender;


    @Autowired
    public DefaultUserService(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    @Override
    public UserDO registerUser(UserDO input)
    {
        UserDO createdUser = this.userRepository.save(input);
        this.sender.send(DefaultUserService.USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }


    @Override
    public Iterable<UserDO> findAll()
    {
        return this.userRepository.findAll();
    }

}
