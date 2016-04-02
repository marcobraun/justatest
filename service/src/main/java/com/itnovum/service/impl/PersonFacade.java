package com.itnovum.service.impl;

import com.itnovum.dao.PersonDaoBean;
import com.itnovum.model.Person;
import com.itnovum.service.IPersonFacade;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Created by mbraun on 24.02.2016.
 */
@ApplicationScoped
public class PersonFacade implements IPersonFacade {

    @EJB
    PersonDaoBean pDao;

    public void add(Person p) {
        pDao.add(p);
    }

    public void del(Person p) {
        pDao.del(p);
    }

    public List<Person> getPersonList (){
        return pDao.getAllPersons();
    }
}
