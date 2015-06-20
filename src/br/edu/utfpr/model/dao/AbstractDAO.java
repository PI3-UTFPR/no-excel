package br.edu.utfpr.model.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.edu.utfpr.util.JPAUtil;

@SuppressWarnings("unchecked")
public class AbstractDAO<PK, T> {
	
	protected EntityManager entityManager;

	public AbstractDAO() {
		this.entityManager = JPAUtil.getEntityManager();		
	}
	
	/**
	 * Retorna uma entidade pelo seu ID
	 * 
	 * @param pk id da entidade
	 * @return
	 */
	public T getById(PK pk) {
		this.entityManager = JPAUtil.getEntityManager();
		return (T) entityManager.find(getTypeClass(), pk);
	}
	
	/**
	 * Retorna a entidade pelo atributo único, ou seja, assumirá que há apenas uma entidade com este atributo, 
	 * retornando apenas um elemento. 
	 * 
	 * @param propertyName nome do atributo
	 * @param propertyValue valor do atributo
	 * @return
	 */
	public T getByProperty(String propertyName, String propertyValue){
		this.entityManager = JPAUtil.getEntityManager();
		
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";		
		
		Query query = entityManager.createQuery(queryString);		
		query.setParameter("param", propertyValue);
		
	    List<T> queryResult = query.getResultList();
	    
	    T returnObject = null;

	    if (!queryResult.isEmpty()){
	        returnObject = queryResult.get(0);
	    }

	    return returnObject;
	}
	
	public void save(T entity) throws SQLException {
		try {
			this.entityManager = JPAUtil.getEntityManager();
			entityManager.persist(entity);			
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public void update(T entity) {
		this.entityManager = JPAUtil.getEntityManager();
		entityManager.merge(entity);
	}
	
	public void delete(T entity) {
		this.entityManager = JPAUtil.getEntityManager();
		T _entity = this.entityManager.merge(entity);
		entityManager.remove(_entity);
	}
	
	public List<T> findAll() {
		this.entityManager = JPAUtil.getEntityManager();
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}
	
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().
				getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}

