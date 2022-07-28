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
public class Patient 
{
@Id
private int pat_id;
private String pat_Name;
private String pat_diagnosis;
private String pat_Address;

@ManyToOne
@JoinColumn
private Doctor dto; //for many patients one hospital

@OneToMany(mappedBy = "mp",cascade=CascadeType.REMOVE)
private List<Med_rec> mr=new ArrayList(); //for one patient many medical records

public Doctor getDto()
{
	return dto;
}
public void setDto(Doctor dto) {
	this.dto = dto;
}

public int getPat_id() {
	return pat_id;
}
public void setPat_id(int pat_id) {
	this.pat_id = pat_id;
}
public String getPat_Name() {
	return pat_Name;
}
public void setPat_Name(String pat_Name) {
	this.pat_Name = pat_Name;
}
public String getPat_diagnosis() {
	return pat_diagnosis;
}
public void setPat_diagnosis(String pat_diagnosis) {
	this.pat_diagnosis = pat_diagnosis;
}
public String getPat_Address() {
	return pat_Address;
}
public void setPat_Address(String pat_Address) {
	this.pat_Address = pat_Address;
}

public List<Med_rec> getMr() {
	return mr;
}
public void setMr(List<Med_rec> mr) {
	this.mr = mr;
}
}
