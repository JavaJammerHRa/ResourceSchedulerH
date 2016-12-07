package com.ReourceEntity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@Column(name="reservationId")
	private int reversationId;
	
	@Column(name="resourceId")
	private int sourceId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="timeSlot")
	private int timeSlot;
	
	public Reservation(){
		
	}

	public Reservation(int sourceId, Date date, int timeSlot) {
		super();
		this.sourceId = sourceId;
		this.date = date;
		this.timeSlot = timeSlot;
	}

	public int getReversationId() {
		return reversationId;
	}

	public void setReversationId(int reversationId) {
		this.reversationId = reversationId;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public String toString() {
		return "Reservation [reversationId=" + reversationId + ", sourceId=" + sourceId + ", date=" + date
				+ ", timeSlot=" + timeSlot + "]";
	}
	
	
	
}
