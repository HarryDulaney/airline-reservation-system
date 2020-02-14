package com.example.careers;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JobPostings")
public class Careers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Job_ID")
    private long job_ID;
	@Column(name = "Department_Name")
    private String department_Name;
	@Column(name = "Job_Title")
    private String job_Title;
	@Column(name = "State")
    private String state;
	@Column(name = "City")
    private String city;
	@Column(name = "Date_Posted")
    private String date_Posted;
	@Column(name = "Description")
    private String description;
	
	
	public Careers() {
		
	}
	public Careers(long job_ID, String department_Name, String job_Title, String state, String city, String date_Posted,
			String description) {
		super();
		this.job_ID = job_ID;
		this.department_Name = department_Name;
		this.job_Title = job_Title;
		this.state = state;
		this.city = city;
		this.date_Posted = date_Posted;
		this.description = description;
	}


	public long getJob_ID() {
		return job_ID;
	}


	public void setJob_ID(long job_ID) {
		this.job_ID = job_ID;
	}


	public String getDepartment_Name() {
		return department_Name;
	}


	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}


	public String getJob_Title() {
		return job_Title;
	}


	public void setJob_Title(String job_Title) {
		this.job_Title = job_Title;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDate_Posted() {
		return date_Posted;
	}


	public void setDate_Posted(String date_Posted) {
		this.date_Posted = date_Posted;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

}
