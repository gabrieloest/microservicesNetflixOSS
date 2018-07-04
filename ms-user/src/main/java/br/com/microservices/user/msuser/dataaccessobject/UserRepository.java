package br.com.microservices.user.msuser.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import br.com.microservices.user.msuser.domainobject.UserDO;

public interface UserRepository extends CrudRepository<UserDO, Long>
{

}
