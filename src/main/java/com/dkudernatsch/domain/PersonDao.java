package com.dkudernatsch.domain;

import com.dkudernatsch.interfaces.JpaDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 1/13/17.
 */
public class PersonDao extends JpaDao<Integer, Person> {


    @SuppressWarnings("unchecked")
    public List<Person> findAll(){
        return (List<Person>) emf.createEntityManager().createNamedQuery("person.findAll").getResultList();
    }
}
