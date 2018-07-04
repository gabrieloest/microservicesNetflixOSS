package br.com.microservices.user.msuser.service;

import br.com.microservices.user.msuser.domainobject.UserDO;

public interface UserService
{
    UserDO registerUser(UserDO input);


    Iterable<UserDO> findAll();
}
