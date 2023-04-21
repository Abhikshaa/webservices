package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Lead;
import com.example.repository.LeadRepository;
import com.example.util.EmailService;


@RestController
@RequestMapping("/api/rest")
public class LeadController {

	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private EmailService emailservice;
	
	//http://localhost:8080/api/rest
	@PostMapping
	public void savedata(@RequestBody Lead lead) {
		
		emailservice.sendEmail(lead.getEmail(), "text", "Thanks for verryfying");
		
		leadRepository.save(lead);
		
	}
	@PutMapping
	public void updatedata(@RequestBody Lead lead) {
		
		leadRepository.save(lead);
		
	}
	
	@GetMapping
	public java.util.List<Lead> getAll(){
		
		java.util.List<Lead> leads = leadRepository.findAll();
		
		return leads;
		
	}
	@GetMapping("/search/{id}")
	public Lead getById(@PathVariable("id") long id) {
		Optional<Lead> list = leadRepository.findById(id);
		
		return list.get();
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") long id) {
		
		leadRepository.deleteById(id);
	}
}
