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

public class Findvalues
{
	public static void main(String[] args) 
	{    
		Hospitaldao hm1=new Hospitaldao();
		Doctordao dm1=new Doctordao();
		Patientdao pm1=new Patientdao();
		Medrecdao mm1=new Medrecdao();
		
	    boolean me=true;
	    while(me)
	    {
	    System.out.println("please select 1->to find hospital details 2->to find doctor details 3->to find patient details 4->to find medical record details 5->exit");
	    Scanner sc=new Scanner(System.in);
	    int a=sc.nextInt();
	    switch(a)
	    {
	    case 1://to find hospital details along with doctor(s) present in that hospital
	    	System.out.println("enter the hospital id");
	    	int h1=sc.nextInt();
	    
	    	Hospital h11=hm1.findHos(h1);
	    	if(h11!=null)
	    	{
	        System.out.println("hospital details------->");
	        System.out.println(h11);
	  // System.out.println(h11.getHosp_id()+"  "+h11.getHosp_name()+"   "+h11.getHosp_city()+"   "+h11.getHosp_add());//fetching hospital details
	    	List<Doctor> d1=h11.getHdo();//for that hospital, fetching doctor(s) details
	    	for(Doctor d11:d1)
	    	{
	        System.out.println("doctor details-------------->");
	    	System.out.println(d11.getDoc_id()+"   "+d11.getDoc_name()+"   "+d11.getDoc_qual()+"   "+d11.getDoc_sal());	
	    	
	    	List<Patient> p11=d11.getPt();//for that doctor,fetching patient(s) details
	    	System.out.println("Patient details-------->");
	    	for(Patient p1:p11)
	    	{
	    	System.out.println(p1.getPat_id()+"  "+p1.getPat_Name()+" "+p1.getPat_diagnosis()+"  "+p1.getPat_Address());
	    	}
	    	}
	    	}
	    	else
	        System.out.println("no data found");
	        break; 
	    	
	 case 2://to find doctor details along with patient(s) consulting that particular doctor 
	    	System.out.println("enter id of doctor");
	    	int d1=sc.nextInt();
	    	Doctor d11=dm1.findDoc(d1);
	    	if(d11!=null)
	    	{
	    		//fetching doctor details
	    		System.out.println("doctor details------->");
	    		System.out.println(d11.getDoc_id()+"  "+d11.getDoc_name()+"  "+d11.getDoc_qual()+"  "+d11.getDoc_sal());
	    		//fetching hospital details for that particular doctor,in 2 ways,i can fetch it directly because only one hospital
	    		System.out.println("hospital details------->");
	    		System.out.println(d11.getHd().getHosp_id()+"  "+d11.getHd().getHosp_name()+"  "+d11.getHd().getHosp_city()+" "+d11.getHd().getHosp_add());
	    	    /*Hospital h2=d11.getHd();
	    	    System.out.println(h2.getHosp_id()+"   "+h2.getHosp_city()+"   "+h2.getHosp_name()+h2.getHosp_add());*/
	    		System.out.println("patient details---------->");
	    		//fetching patient details of that particular doctor
	    		List<Patient> p1=d11.getPt();
	    		for(Patient p11:p1)
	    		{
	    		System.out.println(p11.getPat_id()+"  "+p11.getPat_Name()+"  "+p11.getPat_diagnosis()+"  "+p11.getPat_Address());
	    		}
	    	}
	    	else
		    System.out.println("no data found");
	        break;	
	    	
	        case 3://to find patient details
	        System.out.println("enter the id of patient");
	    	int k=sc.nextInt();
	    	Patient p1=pm1.findPat(k);
	    	if(p1!=null)
	    	{
	    		System.out.println("patient details---------->");
	    		System.out.println(p1.getPat_id()+"  "+p1.getPat_Name()+"  "+p1.getPat_diagnosis()+"  "+p1.getPat_Address());
	    		System.out.println("doctor details----------->");
	    		System.out.println(p1.getDto().getDoc_id()+"  "+p1.getDto().getDoc_name()+"  "+p1.getDto().getDoc_qual());
	    	    System.out.println("patient medical record details----->");
	    	    List<Med_rec> md=p1.getMr();
	    	    for(Med_rec md1:md)
	    	    {
	    	    	if(md1!=null)
	    	    	{
	    	    	System.out.println(md1.getRecord_id()+"  "+md1.getProblem()+"  "+md1.getDate_of_examination());
	    	    	}
	    	    	else
	    	    	{
	    	        System.out.println("no data found");
	    	    	}
	    	    }
	    	}
	    	else
		    System.out.println("no data found");
	    	break;
	        
	    	
	    case 4://to find Medical record details
	    	System.out.println("enter record id");
	    	int g=sc.nextInt();    		 
	    	Med_rec m1=mm1.findmedRec(g);
	    	if(m1!=null)
	    	{
	    		System.out.println("patient details---->");
	    		System.out.println(m1.getMp().getPat_id()+"  "+m1.getMp().getPat_Name()+"  "+m1.getMp().getPat_diagnosis()+"  "+m1.getMp().getPat_Address());
	    		
	    		System.out.println("Medical record details for above patient---->");
	    		System.out.println(m1.getRecord_id()+"  "+m1.getProblem()+"  "+m1.getDate_of_examination());
	    	}
	    	else
	    	{
	    		System.out.println("no data found");
	    	}
	    break;
	    
	    case 5:me=false;
	    break;
	    default: System.out.println("enter proper digit");
	    }}}}
	


