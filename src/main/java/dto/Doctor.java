package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Doctor 
{
@Id
private int doc_id;
private String doc_name;
private String doc_qual;
private double doc_sal;

@ManyToOne
@JoinColumn
private Hospital hd;

@OneToMany(mappedBy = "dto",cascade=CascadeType.REMOVE)
private List<Patient> pt=new ArrayList<Patient>();

public List<Patient> getPt() 
{
	return pt;
}

public void setPt(List<Patient> pt) {
	this.pt = pt;
}

public int getDoc_id() {
	return doc_id;
}

public void setDoc_id(int doc_id) {
	this.doc_id = doc_id;
}

public String getDoc_name() {
	return doc_name;
}

public void setDoc_name(String doc_name) {
	this.doc_name = doc_name;
}

public String getDoc_qual() {
	return doc_qual;
}

public void setDoc_qual(String doc_qual) {
	this.doc_qual = doc_qual;
}

public double getDoc_sal() {
	return doc_sal;
}

public void setDoc_sal(double s) {
	this.doc_sal = s;
}

public Hospital getHd() {
	return hd;
}

public void setHd(Hospital hd) {
	this.hd = hd;
}
}
