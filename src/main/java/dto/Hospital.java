package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital
{
@Id
private int Hosp_id;
private String Hosp_name;
private String Hosp_add;
private String Hosp_city;

@OneToMany(mappedBy = "hd",cascade=CascadeType.REMOVE)
private List<Doctor> hdo=new ArrayList<Doctor>();//one hospital multiple doctors

public int getHosp_id() 
{
	return Hosp_id;
}
public void setHosp_id(int hosp_id) {
	Hosp_id = hosp_id;
}
public String getHosp_name() {
	return Hosp_name;
}
public void setHosp_name(String hosp_name) {
	Hosp_name = hosp_name;
}
public String getHosp_add() {
	return Hosp_add;
}
public void setHosp_add(String hosp_add) {
	Hosp_add = hosp_add;
}
public String getHosp_city() {
	return Hosp_city;
}
public void setHosp_city(String hosp_city) {
	Hosp_city = hosp_city;
}
public List<Doctor> getHdo() {
	return hdo;
}
public void setHdo(List<Doctor> hdo) {
	this.hdo = hdo;
}
@Override
public String toString() {
	return "Hospital [Hosp_id=" + Hosp_id + ", Hosp_name=" + Hosp_name + ", Hosp_add=" + Hosp_add + ", Hosp_city="
			+ Hosp_city + ", hdo=" + hdo + "]";
}


}
