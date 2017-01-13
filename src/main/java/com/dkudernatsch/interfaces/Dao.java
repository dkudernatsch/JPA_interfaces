package com.dkudernatsch.interfaces;

/**
 * Created by daniel on 1/13/17.
 */
public interface Dao<K, E> {

    void persist(E entity);
    void remove(E entity);
    E findById(K id);
    void update(E entity);

}