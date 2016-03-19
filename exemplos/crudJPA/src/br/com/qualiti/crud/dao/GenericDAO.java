package br.com.qualiti.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T, P> {

	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
	private Class entityClass;

	public GenericDAO(String persistentUnit, 
			          Class entityClass) {

		this.entityClass = entityClass;
		
		emfactory = 
			Persistence
			.createEntityManagerFactory(
					persistentUnit 
			);
		entitymanager = 
			emfactory.createEntityManager();

	}

	public void save(T entity){

		entitymanager.getTransaction( ).begin( );
		//===============================
		entitymanager.persist( entity );
		//===============================
		entitymanager.getTransaction( ).commit( );
	}

	public void deleteById(P id){
		T t = find(id);
		delete(t);
	}
		
	public void delete(T entity){

		entitymanager.getTransaction( ).begin( );
		entitymanager.remove( entity );
		entitymanager.getTransaction( ).commit( );
	}

	public T find(P id){

		entitymanager.getTransaction( ).begin( );
		
		T entity = 
			(T)entitymanager.find(
					entityClass, 
				id
			);
		
		entitymanager.getTransaction( ).commit( );

		return entity;
	}


	public List<T> findAll(String namedQuery){

		entitymanager.getTransaction( ).begin( );
		
		List<T> entities =
			entitymanager
				.createNamedQuery(
						namedQuery, 
					entityClass
				)
				.getResultList();
		
		entitymanager.getTransaction( ).commit( );

		return entities;
	}

}
