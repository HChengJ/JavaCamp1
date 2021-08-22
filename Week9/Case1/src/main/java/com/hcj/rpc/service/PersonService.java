package com.hcj.rpc.service;

import com.hcj.rpc.entity.Person;

/**
 * @author Administrator
 */
public interface PersonService {
    public Person getInfo();

    public boolean printInfo(Person person);
}
