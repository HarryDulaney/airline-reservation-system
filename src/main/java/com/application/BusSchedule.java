package com.application;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BusSchedule")
public class BusSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BusID")
    private long busID;
	@Column(name = "BusNumber")
    private String busNumber;
	@Column(name = "BusDate")
    private String busDate;
	@Column(name = "BusFrom")
    private String busFrom;
	@Column(name = "BusTo")
    private String busTo;
	@Column(name = "Price")
    private BigDecimal price;
	


    public BusSchedule() {
    }
    
    public BusSchedule(String busNumber,String busDate, String busFrom,String busTo,BigDecimal price) {
    	this.busNumber=busNumber;
    	this.busDate=busDate;
    	this.busFrom=busFrom;
    	this.busTo=busTo;
    	this.price=price;

    }

	public long getBusID() {
		return busID;
	}

	public void setBusID(long busID) {
		this.busID = busID;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusDate() {
		return busDate;
	}

	public void setBusDate(String busDate) {
		this.busDate = busDate;
	}

	public String getBusFrom() {
		return busFrom;
	}

	public void setBusFrom(String busFrom) {
		this.busFrom = busFrom;
	}

	public String getBusTo() {
		return busTo;
	}

	public void setBusTo(String busTo) {
		this.busTo = busTo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}



}
