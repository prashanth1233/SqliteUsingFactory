package com.example.prasanth.sqlite_factory;


 interface Model_Factory
{

     void setFirstName(String firstName);
    String getFirstName();
    void setLastName(String lastName);
    String getLastName();
    void setNickName(String nickName);
    String getNickName();
}

class Model implements Model_Factory {

    private String firstName,lastName;
    private String nickName;

    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setNickName(String nickName)
    {
        this.nickName=nickName;
    }

    public String getNickName()
    {
        return nickName;
    }
}

 class Factory_pattern
{
    public static Model_Factory getObjectRef(String param)
    {
        if(param.equalsIgnoreCase("model"))
            return new Model();
        else
           return null;
    }
}



