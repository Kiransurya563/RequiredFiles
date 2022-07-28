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
public class Doctordao 
{
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ui");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();

public void insertDoc(Doctor d)
{
	entityTransaction.begin();
	entityManager.persist(d);
	entityTransaction.commit();	
}

public Doctor findDoc(int i)
{
	Doctor ds1=entityManager.find(Doctor.class,i);
	return ds1;
}

public void deleteDoctor(int i)
{
	Doctor ds1=entityManager.find(Doctor.class,i);
	if(ds1!=null)
	{
		entityTransaction.begin();
		entityManager.remove(ds1);
		entityTransaction.commit();
	}
	else
	return;
}

public void updateDoc(Doctor d1)
{
	entityTransaction.begin();
	entityManager.merge(d1);
	entityTransaction.commit();
}

public List<Doctor> fetchHos()
{	
	Query q=entityManager.createQuery("select d from Doctor d",Doctor.class);
	List<Doctor> ld=q.getResultList();
	return ld;
}


}
