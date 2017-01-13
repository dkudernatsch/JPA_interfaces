package com.dkudernatsch.domain;

import com.dkudernatsch.interfaces.Dao;
import com.dkudernatsch.interfaces.JpaDao;

/**
 * Created by daniel on 1/13/17.
 */
public class DaoFactory {

    public <K,E> Dao<K,E> getDao(Class<E> entity, Class<K> keyclass){
        return new JpaDao<K, E>() {};
    }

}
