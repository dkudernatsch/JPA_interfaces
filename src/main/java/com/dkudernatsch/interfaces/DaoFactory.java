package com.dkudernatsch.interfaces;

/**
 * Created by daniel on 1/13/17.
 */
public class DaoFactory {

    private String persistenceUnit;

    public DaoFactory(String persistenceUnit){
        this.persistenceUnit = persistenceUnit;
    }

    public  <K, E> Dao<K, E> getGenericJpaDao(Class<E> entityClass, Class<K> keyClass){
        return new JpaDao<K, E>() {};
    }
}
