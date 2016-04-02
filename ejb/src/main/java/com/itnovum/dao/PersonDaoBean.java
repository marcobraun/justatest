package com.itnovum.dao;

import com.itnovum.model.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbraun on 24.02.2016.
 */
@Stateless(name = "PersonDaoEJB")
public class PersonDaoBean {

    private List<Person> pList;

    @PostConstruct
    private void init () {

        pList = new ArrayList<Person>();
    }

    public PersonDaoBean() {
    }

    public void add(final Person p) {
        pList.add(p);
    }

    public void del(final Person p) {
        pList.remove(p);
    }

    public List<Person> getAllPersons(){
        return pList;
    }
}
