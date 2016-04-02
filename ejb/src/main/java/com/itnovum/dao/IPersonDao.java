package com.itnovum.dao;

import com.itnovum.model.Person;

/**
 * Created by mbraun on 26.02.2016.
 */
public interface IPersonDao {
    // add a person
    public void add(Person p);

    // remove a person
    public void del(Person p);

    // print all persons
   // public List<Person> getAllPersons();
}
