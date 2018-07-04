package br.com.microservices.user.msuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservices.user.msuser.domainobject.UserDO;
import br.com.microservices.user.msuser.service.UserService;

@RestController
public class UserController
{
    private final UserService userService;


    @Autowired
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/member")
    public ResponseEntity<Iterable<UserDO>> getAll()
    {
        Iterable<UserDO> all = this.userService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/member")
    public ResponseEntity<UserDO> register(@RequestBody UserDO input)
    {
        UserDO result = this.userService.registerUser(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
