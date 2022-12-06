package com.assignment.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entities.Appointment;
import com.assignment.service.AppointmentService;

@RestController
public class Controller {

	@Autowired
	private AppointmentService as;
	
	@GetMapping("/all")
	public List<Appointment> appointments(){
		return this.as.getAllAppointments();
	}
	
	@GetMapping("/id/{t}")
	public Optional<Appointment> appointmentById(@PathVariable("t") int id) {
		return this.as.getAppointmentById(id);
	}
	
	@GetMapping("/name/{t}")
	public Appointment appointmentByName(@PathVariable("t") String name) {
		return this.as.getAppointmentByName(name);
	}
	
	@PostMapping("/add")
	public ResponseEntity addAppointment(@Valid @RequestBody Appointment ap,BindingResult br) {
		if(br.hasErrors())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("AppointmentName should not be blank, string size should be greater than 2, duration should be positive and timestamp format should be yyyy-MM-dd*HH:mm:ss!!");
			
		}
		Optional<Appointment> a=this.as.addAppointment(ap);
		return ResponseEntity.of(a);
				
		
	}
	
	@DeleteMapping("/id/{t}")
	public void deleteAppointmentById(@PathVariable("t")int id)
	{
		this.as.deleteById(id);
	}
	
	@DeleteMapping("/all")
	public void deleteAll() {
		this.as.deleteAll();
	}
	
	@PutMapping("/update")
	public void updateById(@RequestBody Appointment ap) {
		int id=ap.getId();
		this.as.updateAppointment(id, ap);
	}
	
	@GetMapping("/range")
	public List<Appointment> appointmentInBetween(@DateTimeFormat(pattern = "yyyy-MM-dd*HH:mm:ss") Date begin,@DateTimeFormat(pattern = "yyyy-MM-dd*HH:mm:ss") Date end ){
		return this.as.appointmentInBetween(begin, end);
	}
}
