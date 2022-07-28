package dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Med_rec
{
@Id
private int Record_id;
private String problem;
private String Date_of_examination;

@ManyToOne
@JoinColumn
private Patient mp;

public int getRecord_id() {
	return Record_id;
}

public void setRecord_id(int record_id) {
	Record_id = record_id;
}

public String getProblem() {
	return problem;
}

public void setProblem(String problem) {
	this.problem = problem;
}

public String getDate_of_examination() {
	return Date_of_examination;
}

public void setDate_of_examination(String date_of_examination) {
	Date_of_examination = date_of_examination;
}

public Patient getMp() {
	return mp;
}

public void setMp(Patient mp) {
	this.mp = mp;
}
}
