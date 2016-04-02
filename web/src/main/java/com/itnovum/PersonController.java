package com.itnovum;

import com.itnovum.model.Person;
import com.itnovum.service.IPersonFacade;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Created by mbraun on 25.02.2016.
 */

@Named
@ViewScoped
public class PersonController implements Serializable {
    private final static  Logger LOG = Logger.getLogger(PersonController.class);
    private final static String TIME_PATTERN_ENGLISH = "EEE MMM dd HH:mm:ss zzzz yyyy";
    private Locale currentLocale;
    private String currentTimePattern;

    @Inject
    private IPersonFacade personFacade;

    private String name;
    private int age;
    private Person person;
    private String selBirthDate;
    private List<Person> pList;

    public PersonController() {
    }

    @PostConstruct
    public void init() {
        pList = personFacade.getPersonList();
        currentLocale = Locale.ENGLISH;
        currentTimePattern = TIME_PATTERN_ENGLISH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getpList() {
        return personFacade.getPersonList();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSelBirthDate() {
        return selBirthDate;
    }

    public void setSelBirthDate(String selBirthDate) {
        this.selBirthDate = selBirthDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String add() {
        Person person = new Person();
        person.setName(name);
        person.setAge(calcAgeFromBirthdate());
        personFacade.add(person);
        LOG.debug("Name: " + name);

        return "viewPerson";
    }

    private int calcAgeFromBirthdate (){
        Locale currentLocale = Locale.ENGLISH;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(currentTimePattern, currentLocale);
        LocalDate birthDate = LocalDate.parse(selBirthDate,formatter);
        LocalDate now = LocalDate.now();
        Period between = Period.between(birthDate,now);

        return between.getYears();
    }
}
