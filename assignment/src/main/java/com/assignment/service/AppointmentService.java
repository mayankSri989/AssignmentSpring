package com.assignment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.AppointmentRepository;
import com.assignment.entities.Appointment;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository ar;
	
	public List<Appointment> getAllAppointments(){
		return (List<Appointment>)this.ar.findAll();
	}
	
	public Optional<Appointment> getAppointmentById(int id)
	{
		return this.ar.findById(id);
	}
	
	public Appointment getAppointmentByName(String name)
	{
		return this.ar.findByAppointmentName(name);
	}
	
	public Optional<Appointment> addAppointment(Appointment ap)
	{
		this.ar.save(ap);
		int id=ap.getId();
		return this.ar.findById(id);
	}
	
	public void deleteById(int id) {
		this.ar.deleteById(id);
	}
	
	public void deleteAll() {
		this.ar.deleteAll();
	}
	
	public void updateAppointment(int id, Appointment ap) {
		ap.setId(id);
		this.ar.save(ap);
	}
	
	public List<Appointment> appointmentInBetween(Date a,Date b){
		return this.ar.findByDateBetween(a, b);
	}
}
