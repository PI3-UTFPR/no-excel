package br.edu.utfpr.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.dao.AbstractDAO;
import br.edu.utfpr.util.JPAUtil;

public class AbstractService<PK, T> {

  protected AbstractDAO<PK, T> dao;

  public void save(T entity){
        try{
            JPAUtil.beginTransaction();
            dao.save(entity);
            JPAUtil.commit();
        }
        catch(Exception e){
            JPAUtil.rollBack();
        }
        finally{
      JPAUtil.closeEntityManager();
    }
    }

  public T getById(PK pk){
    T entity = null;

    try{
            JPAUtil.beginTransaction();
            entity = dao.getById(pk);
            JPAUtil.commit();
        }
        catch(Exception e){
            JPAUtil.rollBack();
        }
        finally{
      JPAUtil.closeEntityManager();
    }

    return entity;
  }

  public T delete(T entity){
    try{
            JPAUtil.beginTransaction();
            dao.delete(entity);
            JPAUtil.commit();
        }
        catch(Exception e){
            JPAUtil.rollBack();
        }
        finally{
      JPAUtil.closeEntityManager();
    }

    return entity;
  }

  public T getByProperty(String propertyName, String propertyValue){
    T entity = null;
    try{
            JPAUtil.beginTransaction();
            entity = dao.getByProperty(propertyName, propertyValue);
            JPAUtil.commit();
        }
        catch(Exception e){
            JPAUtil.rollBack();
            e.printStackTrace();
        }
        finally{
      JPAUtil.closeEntityManager();
    }

    return entity;
  }

  public List<T> findAll(){
        return dao.findAll();
    }
}
