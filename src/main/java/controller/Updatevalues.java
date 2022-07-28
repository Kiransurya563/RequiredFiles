package controller;

import java.util.Scanner;

import dao.Doctordao;
import dao.Hospitaldao;
import dao.Medrecdao;
import dao.Patientdao;
import dto.Doctor;
import dto.Hospital;

public class Updatevalues 
{
public static void main(String[] args) 
{
	Doctordao dm1=new Doctordao();      //dao class objects
	Patientdao pm1=new Patientdao();
	Hospitaldao hm1=new Hospitaldao();
	Medrecdao mm1=new Medrecdao();

	boolean me=true;
    while(me)
    {
    System.out.println("please select 1->to update hospital details 2->to update doctor details 3->to update patient details 4->to update medical record details 5->exit");
    Scanner sc=new Scanner(System.in);
    int a=sc.nextInt();
    switch(a)
    {
    case 1://to update hospital details
         boolean mi=true;
         while(mi)
         {
        	 System.out.println("*******update hospital details-name/address/city********");
        	 System.out.println("1.update name 2.update address 3.update city 4.exit");
        	 int b=sc.nextInt();
         switch(b)
         {
         case 1:
         //to get dynamic input
         System.out.println("enter hospital id which details needs to be updated");
         int hid=sc.nextInt();
         System.out.println("enter name");
         String hname=sc.next();
         Hospital h1=hm1.findHos(hid);
         if(h1!=null)
         {
         h1.setHosp_name(hname);
         hm1.updateHos(h1);
         System.out.println("updated");
         }  
        else
        System.out.println("no data to update");
        break;
        case 2:
        //to get dynamic input
        System.out.println("enter hospital id which details needs to be updated");
        int h_id=sc.nextInt();
        System.out.println("enter address");
        String h_add=sc.next();
        Hospital h2=hm1.findHos(h_id);
        if(h2!=null)
        {
        h2.setHosp_name(h_add);
        hm1.updateHos(h2);
        System.out.println("updated");
        }  
        else
        System.out.println("no data to update");
        break;
        case 3:
            //to get dynamic input
            System.out.println("enter hospital id which details needs to be updated");
            int hId=sc.nextInt();
            System.out.println("enter city");
            String h_city=sc.next();
            Hospital h21=hm1.findHos(hId);
            if(h21!=null)
            {
            h21.setHosp_city(h_city);
            hm1.updateHos(h21);
            System.out.println("updated");
            }  
            else
            System.out.println("no data to update");
            break;
            
        case 4: mi=false;
        break;
        
        default: System.out.println("enter proper digit");
        }}
        break;//outer code case-1 break.
         
    case 2: //to update doctor details
    	boolean red=true;
    	while(red)
    	{
    	System.out.println("*****update doctor details - name/qualification/salary");
    	System.out.println("1.update name 2.update qualification 3.update salary 4.exit");
    	int c=sc.nextInt();
    	switch(c)
    	{
    	case 1:
    	System.out.println("enter doctor id whose details needs to be updated");	
    	int d_id=sc.nextInt();
    	System.out.println("enter name");
    	String dname=sc.next();
    	Doctor d1=dm1.findDoc(d_id);//find the doctor by id
    	if(d1!=null)
    	{
    		d1.setDoc_name(dname);
    		dm1.updateDoc(d1);
    		System.out.println("updated");
    	}
    	else
    	System.out.println("no data to update");
    	break;
    	case 2:
        	System.out.println("enter doctor id whose details needs to be updated");	
        	int did=sc.nextInt();
        	System.out.println("enter qualification");
        	String dqual=sc.next();
        	Doctor d2=dm1.findDoc(did);//find the doctor by id
        	if(d2!=null)
        	{
        		d2.setDoc_qual(dqual);
        		dm1.updateDoc(d2);
        		System.out.println("updated");
        	}
        	else
        	System.out.println("no data to update");
        	break;
    	case 3:
        	System.out.println("enter doctor id whose details needs to be updated");	
        	int dId=sc.nextInt();
        	System.out.println("enter salary");
        	double dsal=sc.nextDouble();
        	Doctor d3=dm1.findDoc(dId);//find the doctor by id
        	if(d3!=null)
        	{
        		d3.setDoc_sal(dsal);
        		dm1.updateDoc(d3);
        		System.out.println("updated");
        	}
        	else
        	System.out.println("no data to update");
        	break;
        
    	case 4: red=false;
        break;
        
        default: System.out.println("enter proper digit");
    	}}  
    	break;//outer code case-2 break
    	
 case 3: System.out.println("yet to write the code");
 break;
 case 4: System.out.println("yet to write the code");
 break;
 case 5: me=false;
 break;
 default: System.out.println("enter proper digit");
    
}}}}
