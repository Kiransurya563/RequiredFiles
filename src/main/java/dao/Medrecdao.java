package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Doctor;
import dto.Hospital;
import dto.Med_rec;
import dto.Patient;

public class Medrecdao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ui");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insertMed(Med_rec m)
	{
		entityTransaction.begin();
		entityManager.persist(m);
		entityTransaction.commit();	
	}
	public Med_rec findmedRec(int i)
	{
		Med_rec mr1=entityManager.find(Med_rec.class,i);
		return mr1;
	}
	
	public void deleteMedrec(int id)
	{
			
		Med_rec m1 = entityManager.find(Med_rec.class, id);
		if(m1!=null){
			entityTransaction.begin();
			entityManager.remove(m1);
			entityTransaction.commit();
			return;
		}
		else
			return;
	}
	
	public void updatemedRec(Med_rec h2)
	{
		entityTransaction.begin();
		entityManager.merge(h2);
		entityTransaction.commit();
	}
	
	public List<Med_rec> fetchMed()
	{	
		Query q=entityManager.createQuery("select m from Med_rec m",Med_rec.class);
		List<Med_rec> mr=q.getResultList();
		return mr;
	}
}
