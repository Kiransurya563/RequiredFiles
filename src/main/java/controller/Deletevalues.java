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

public class Deletevalues {
	public static void main(String[] args) 
	{    
		Hospitaldao hm1=new Hospitaldao();
		Doctordao dm1=new Doctordao();
		Patientdao pm1=new Patientdao();
		Medrecdao mm1=new Medrecdao();
		boolean me=true;
	    while(me)
	    {
	    System.out.println("please select 1->to delete hospital details 2->to delete doctor details 3->to delete patient details 4->to delete medical record details 5->exit");
	    Scanner sc=new Scanner(System.in);
	    int a=sc.nextInt();
	    switch(a)
	    {
	    case 1://to delete hospital details
	        System.out.println("enter hospital id which needs to be deleted");
	    	int h=sc.nextInt();
	    	Hospital h1=hm1.findHos(h);//find hospital detail
	         if(h1!=null)
	          {//without using cascading
	    	/*List<Doctor> dr=h1.getHdo();//get the list of doctors who are present in that hospital
	    		for(Doctor d1:dr)
	    		{  
		    				List<Patient> p=d1.getPt();//get the list of patient who are consulting that particular doctor
			    	        for(Patient p2:p)
			    	        { 
			    	        	List<Med_rec> m=p2.getMr();//get the list of medical record which belongs to particular patient
				    	        	for(Med_rec m1:m)
				    	        	{
			   	        		    mm1.deleteMedrec(m1.getRecord_id());//delete medical record details one by one
				    	        	}		    	        
		    	        	        pm1.deletePatient(p2.getPat_id());//delete patient details one by one
			    	        	}
	    		dm1.deleteDoctor(d1.getDoc_id());
	    		}*/
	    	hm1.deleteHospital(h1.getHosp_id());//delete hospital detail
	    	System.out.println("Hosiptal data deleted");
	        }
	        else
	        System.out.println("no data found");  
	    	break;
	    
	        case 2://to delete doctor details	
	    	System.out.println("enter doctor id whose details needs to be deleted");
	    	int d=sc.nextInt();
	    	Doctordao da = new Doctordao();
	    	Patientdao pa = new Patientdao();
	    	Doctor dt = da.findDoc(d);
	    	if(dt!=null)
	    	{
	    	List<Patient> pt = dt.getPt();
	    	for(Patient pts : pt)
	    	{
	    		pa.deletePatient(pts.getPat_id());
	    	}
	    	da.deleteDoctor(d);
	    	}
	    	else 
	    	System.out.println("no data found");
	    	break;
	        
	        case 3://to delete patient details
	        	System.out.println("enter patient id whose details needs to be deleted");
		    	int id=sc.nextInt();
		    	Patientdao dao = new Patientdao();
		    	Medrecdao mdao = new Medrecdao();
		    	Patient p = dao.findPat(id);
		    	if(p!=null)
		    	{
		    	List<Med_rec> mc = p.getMr();
		    	for(Med_rec mr : mc)
		    	{
		    		mdao.deleteMedrec(mr.getRecord_id());
		    	}
		    	dao.deletePatient(id);
		    	}
		    	else
		    	System.out.println("no data found");
	        break;
	        
	        case 4://to delete medical_rec details
	            System.out.println("enter the id of medical record which needs to be deleted");
	        	int m=sc.nextInt();
	        	Medrecdao med = new Medrecdao();
	        	med.deleteMedrec(m);
	            break;	
	            
	        case 5: me=false;
	                break;
	                
	        default:System.out.println("enter proper digit");
}
}
}
}
