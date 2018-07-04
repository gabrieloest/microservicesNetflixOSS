package br.com.microservices.user.msmail.datatransferobject;

public class UserDTO
{

    private Long id;

    private String userName;

    private String password;


    public UserDTO() {
    }


    public Long getId()
    {
        return this.id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getUserName()
    {
        return this.userName;
    }


    public void setUserName(String username)
    {
        this.userName = username;
    }


    public String getPassword()
    {
        return this.password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }

}
