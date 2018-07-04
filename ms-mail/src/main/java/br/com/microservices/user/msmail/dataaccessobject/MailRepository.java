package br.com.microservices.user.msmail.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import br.com.microservices.user.msmail.domainobject.MailDO;

public interface MailRepository extends CrudRepository<MailDO, Long>
{

}
