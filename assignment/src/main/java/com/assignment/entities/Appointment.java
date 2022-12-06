package com.assignment.entities;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Positive;



@Entity
@Table(name="Appointment_details")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@jakarta.validation.constraints.NotBlank
	@jakarta.validation.constraints.Size(min = 2, max = 200, message = "{validation.appointmentName.size}")
	private String appointmentName;
	
	@JsonFormat(pattern = "yyyy-MM-dd*HH:mm:ss",shape=Shape.STRING)
	private Date date;
	
	@NotBlank
	@Positive
	@Column(name="duration_in_mins")
	private int duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppointmentName() {
		return appointmentName;
	}
	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Appointment(int id, String appointmentName, Date date, int duration) {
		super();
		this.id = id;
		this.appointmentName = appointmentName;
		this.date = date;
		this.duration = duration;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
