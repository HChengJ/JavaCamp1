package com.hcj.rpc.service.impl;

import com.hcj.rpc.service.PersonService;
import com.hcj.rpc.entity.Person;

/**
 * @author Administrator
 */
@RpcService(PersonService.class)

public class PersonServiceImpl implements PersonService {
    @Override
    public Person getInfo() {
        Person person = new Person();
        person.setAge(22);
        person.setName("qjm");
        person.setSex("男");
        return person;
    }

    @Override
    public boolean printInfo(Person person) {
        if(person != null){
            System.out.println(person);
            return true;
        }
        return false;
    }

}
