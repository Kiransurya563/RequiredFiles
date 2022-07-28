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

public class Patientdao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ui");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insertPat(Patient p) 
	{
		entityTransaction.begin();
		entityManager.persist(p);
		entityTransaction.commit();
	}
	
	public Patient findPat(int i)
	{
		Patient ps1=entityManager.find(Patient.class,i);
		return ps1;
	}

	public void deletePatient(int i)
	{
		Patient ps1=entityManager.find(Patient.class,i);
		if(ps1!=null)
		{
			entityTransaction.begin();
			entityManager.remove(ps1);
			entityTransaction.commit();
		}
		else
			return;
	}
		
	public void updatePat(Patient p1)
	{
		entityTransaction.begin();
		entityManager.merge(p1);
		entityTransaction.commit();
	}
	
	public List<Patient> fetchPat()
	{	
		Query q=entityManager.createQuery("select p from Patient p",Patient.class);
		List<Patient> lt=q.getResultList();
		return lt;
	}
}
