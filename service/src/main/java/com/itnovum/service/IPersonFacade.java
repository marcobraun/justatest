package com.itnovum.service;

import com.itnovum.model.Person;

import java.util.List;

/**
 * Created by mbraun on 24.02.2016.
 */
public interface IPersonFacade {
    public void add (final Person p);
    public void del (final Person p);
    public List<Person> getPersonList ();
}
