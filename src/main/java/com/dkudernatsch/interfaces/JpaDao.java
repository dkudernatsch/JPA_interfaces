package com.dkudernatsch.interfaces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.lang.reflect.ParameterizedType;
import java.util.function.Consumer;

/**
 * Created by daniel on 1/13/17.
 */
public abstract class JpaDao<K, E> implements Dao<K, E> {

    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");



    protected final Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public JpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public void persist(E entity) {

        EntityManager entityManager = emf.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(entity);

            entityManager.getTransaction().commit();

        }catch (PersistenceException e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void remove(E entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.remove(entity);

            entityManager.getTransaction().commit();
            entityManager.close();

        }catch (PersistenceException e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public E findById(K id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return  entityManager.find(entityClass, id);
        }catch (PersistenceException e){
            e.printStackTrace();
            entityManager.close();
        }
        return null;
    }

    @Override
    public void update(E entity) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(entity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

