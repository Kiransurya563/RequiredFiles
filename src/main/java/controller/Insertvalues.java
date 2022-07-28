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

public class Insertvalues 
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
    System.out.println("please select 1->to add hospital details 2->to add doctor details 3->to add patient details 4->to add medical record details 5->exit");
    Scanner sc=new Scanner(System.in);
    int a=sc.nextInt();
    switch(a)
    {
    case 1://to insert hospital details
    	Hospital ht=new Hospital();
        System.out.println("enter Hosp id");
        int p2=sc.nextInt();
        System.out.println("enter Hosp name");
        String q2=sc.nextLine();
                      q2=sc.nextLine();
        System.out.println("enter Hosp address");
        String r2=sc.nextLine();
        System.out.println("enter Hosp city");
        String s2=sc.nextLine();
        
        //set the values
        ht.setHosp_id(p2); 
        ht.setHosp_name(q2);
        ht.setHosp_add(r2);
        ht.setHosp_city(s2);
        //insert the values by calling insert method
        hm1.insertHos(ht);
        System.out.println("inserted");
        break;
        
    case 2://to insert doctor details
    	Scanner sc2=new Scanner(System.in);//user input
    	System.out.println("id of hospital for which doctor belongs");
    	int j=sc2.nextInt();
    	Hospital hv1=hm1.findHos(j);
    	if(hv1!=null)
    	{
    	System.out.println("enter doctor id");
    	int p=sc2.nextInt();
    	System.out.println("enter doctor name");
    	String q=sc2.next();
    	System.out.println("enter doctor qualification");
    	String r=sc2.next();
    	System.out.println("enter doctor salary");
    	double s=sc2.nextDouble();

    	Doctor dt=new Doctor(); 
    	dt.setDoc_id(p);//set the values 
    	dt.setDoc_name(q);
    	dt.setDoc_qual(r);
    	dt.setDoc_sal(s);
        dt.setHd(hv1);//setting hospital to doctor.
        //insert the values by calling insert method
        dm1.insertDoc(dt);
    	System.out.println("inserted");
    	
    	//List<Doctor> d=new ArrayList<Doctor>();---not possible because it will create new object every time so old doctor details get erased in link table
        List<Doctor> d=hv1.getHdo();//get the list of doctors from that particular hospital address & then add the new doctor to old list.
    	d.add(dt);
    	hv1.setHdo(d);//setting doctor(s) to given hospital id.
    	hm1.updateHos(hv1);//update hospital table--important
    	}
    	break;	 
    	
    case 3://to insert patient details
    	Scanner sc3=new Scanner(System.in);//user input
    	System.out.println("enter the id of doctor whom patient wants to consult");
    	int k=sc3.nextInt();
    	Doctor dr=dm1.findDoc(k);
    	if(dr!=null)
    	{
        System.out.println("enter patient id");
        int p1=sc3.nextInt();
        System.out.println("enter patient name");
        String q1=sc3.next();
        System.out.println("enter patient diagnosis");
        String r1=sc3.next();
        System.out.println("enter patient Address");
        String s1=sc3.next();

        Patient pt=new Patient(); 
        pt.setPat_id(p1);//set the values 
        pt.setPat_Name(q1);
        pt.setPat_diagnosis(r1);
        pt.setPat_Address(s1);
        pt.setDto(dr);//setting doctor to patient
        
        pm1.insertPat(pt);//insert the values by calling insert method
        System.out.println("inserted");
        List<Patient> p=dr.getPt();//get the list of patients who are treated by that particular doctor. 
        p.add(pt);
        dr.setPt(p);//setting patient(s) to given doctor id
        dm1.updateDoc(dr);//update doctor table--important
        }
    	break;
    case 4://to insert Medical record details
    	Scanner sc4=new Scanner(System.in);//user input
    	System.out.println("enter patient id");
    	int g=sc4.nextInt();
    	Patient x=pm1.findPat(g);
    	if(x!=null)
    	{
        System.out.println("enter patient record id");
        int p3=sc4.nextInt();
        System.out.println("enter patient problem");
        String q3=sc4.next();
        System.out.println("enter date of examination");
        String r3=sc4.next();
        
        //set the values
        Med_rec mcr=new Med_rec();
        mcr.setRecord_id(p3); 
        mcr.setProblem(q3);
        mcr.setDate_of_examination(r3);
        mcr.setMp(x);//setting patient to medical record
        mm1.insertMed(mcr);//insert the values by calling insert method
        System.out.println("inserted");
        
        List<Med_rec> mr1=x.getMr();//get the list of patients who are treated by that particular doctor.
        mr1.add(mcr);//add medical report to that particular patient
        x.setMr(mr1);//setting medical record(s) to given patient id
        pm1.updatePat(x);//update patient table--important by passing object
    	}
    	break;
        
        case 5: me=false;
        break;
        
        default: System.out.println("enter proper digit");
    }
   }        
}}

