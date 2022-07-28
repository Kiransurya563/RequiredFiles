package controller;

import java.util.List;
import java.util.Scanner;

import dao.Doctordao;
import dao.Hospitaldao;
import dao.Medrecdao;
import dao.Patientdao;
import dto.Doctor;
import dto.Hospital;
import dto.Med_rec;
import dto.Patient;

public class Fetchall 
{
	public static void main(String[] args) {
	Doctordao dm1=new Doctordao();      //dao class objects
	Patientdao pm1=new Patientdao();
	Hospitaldao hm1=new Hospitaldao();
	Medrecdao mm1=new Medrecdao();
	
	boolean u=true;
    while(u)
    {
    System.out.println("please select 1->to fetch hospital details 2->to fetch doctor details 3->to fetch patient details 4->to fetch medical record details 5->exit");
    Scanner sc=new Scanner(System.in);
    int a=sc.nextInt();
    switch(a)
    {
    case 1://to fetch hospital details
    	List<Hospital> lh=hm1.fetchHos();
    	if(lh.isEmpty()!=true)//to compare collection type
    	{
    	for(Hospital h:lh)
    	{   System.out.println("*******************************");
    		System.out.println("hospital details---->");
    		System.out.println(h.getHosp_id()+"   "+h.getHosp_name()+"  "+h.getHosp_city()+"  "+h.getHosp_add());
    		List<Doctor> d=h.getHdo();
    		for(Doctor d1:d)
    		{ 
    			System.out.println("Doctor details----->");
    			System.out.println(d1.getDoc_id()+" "+d1.getDoc_name()+" "+d1.getDoc_qual()+" "+d1.getDoc_sal());
    		    List<Patient> p=d1.getPt();
    		       for(Patient p1:p)
    		       {
    		    	   System.out.println("Patient details------->");
    		    	   System.out.println(p1.getPat_id()+"     "+p1.getPat_Name()+"    "+p1.getPat_diagnosis()+"     "+p1.getPat_Address());
    		       }
    	   }
    	}}
    	else
    		System.out.println("no data found");
        break;
	
    case 2://to fetch doctor details
    	List<Doctor> d=dm1.fetchHos();
    	if(d.isEmpty()!=true)
    	{
    	for(Doctor d1:d)
    	{   System.out.println("******************************");
    		System.out.println("doctor details----->");
    		System.out.println(d1.getDoc_id()+" "+d1.getDoc_name()+" "+d1.getDoc_qual()+" "+d1.getDoc_sal());
            List<Patient> p=d1.getPt();
            for(Patient p1:p)
            {
            	System.out.println("Patient details-------->");
            	System.out.println(p1.getPat_id()+"     "+p1.getPat_Name()+"     "+p1.getPat_diagnosis()+"        "+p1.getPat_Address());
    	    }
    	}}
    	else
    	System.out.println("no data found");
    	break;
    	
    case 3://to fetch patient details
        List<Patient> p=pm1.fetchPat();	
    	if(p.isEmpty()!=true)
    	{
    	for(Patient p1:p)	
    	{   
    		System.out.println("***************************");
    		System.out.println("Patient details---------->");
    		System.out.println(p1.getPat_id()+"      "+p1.getPat_Name()+"     "+p1.getPat_diagnosis()+"    "+p1.getPat_Address());
    		List<Med_rec> mr =p1.getMr();
    		for(Med_rec mr1:mr)
    		{   
    			System.out.println("medical record details");
    			System.out.println(mr1.getRecord_id()+"   "+mr1.getProblem()+"   "+mr1.getDate_of_examination());
    		}
    	}
    	}
    	else
        System.out.println("no data found");
    	break;
    	
    case 4://to fetch medical record details
    	List<Med_rec> mr=mm1.fetchMed();
    	if(mr.isEmpty()!=true)
    	{
    		for(Med_rec mr1:mr)
    		{
    		System.out.println("**********************************");
    		System.out.println(mr1.getRecord_id()+" "+mr1.getProblem()+" "+mr1.getDate_of_examination());	
    		Patient p2=mr1.getMp();
    		System.out.println(p2.getPat_id()+"  "+p2.getPat_Name()+"  "+p2.getPat_diagnosis()+"  "+p2.getPat_Address());
    		}
    	}
    	else
    		System.out.println("no data found");
    	break;
    	
    case 5:u=false;
    break;
    
    default:System.out.println("enter proper digit");
}}}}