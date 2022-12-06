package com.assignment.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
public Appointment findByAppointmentName(String appointmentName);
public List<Appointment> findByDateBetween(Date a,Date b);
}
