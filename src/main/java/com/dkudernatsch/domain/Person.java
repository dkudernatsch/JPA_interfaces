package com.dkudernatsch.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by daniel on 1/13/17.
 */
@Entity
@Table(name= "person")
@NamedQueries({
        @NamedQuery(query = "select p From Person p", name = "person.findAll")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int personId;

    private String name;

    private LocalDate birthday;

    @OneToMany
    @JoinColumn(name = "s_id")
    private List<Sock> sockList;

    public Person(String name, LocalDate birthday, List<Sock> sockList) {
        this.name = name;
        this.birthday = birthday;
        this.sockList = sockList;
    }

    protected Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Sock> getSockList() {
        return sockList;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setSockList(List<Sock> sockList) {
        this.sockList = sockList;
    }


}
