package com.itnovum;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by mbraun on 23.03.2016.
 */
public class PersonControllerTest{

    @Test
    public void testDateTime (){
        String selBirthDate = "Fri Mar 04 00:00:00 CET 2016";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
        LocalDate birthDate = LocalDate.parse(selBirthDate,formatter);
        LocalDate now = LocalDate.now();
        Period between = Period.between(birthDate,now);
        int age = between.getYears();

        System.out.printf("birthdate: %s%n", birthDate);
        System.out.printf("now: %s%n", now);
        System.out.printf("age: %s%n", age);
    }

    @Test
    public void testGetDataFromES (){

    }
}
