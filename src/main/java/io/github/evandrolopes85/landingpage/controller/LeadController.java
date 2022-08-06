package io.github.evandrolopes85.landingpage.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.evandrolopes85.landingpage.model.Lead;
import io.github.evandrolopes85.landingpage.model.LeadService;

@RestController
@CrossOrigin("*")
public class LeadController {
	
	@Autowired
	private LeadService service;
	
	@GetMapping("/lead")
	public ResponseEntity<ArrayList<Lead>> recuperaTodosOsLeads(){
		ArrayList<Lead> leads = service.recuperaTodosOsLeads();
		
		if(leads != null)
			return ResponseEntity.ok(leads);
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/lead")
	public ResponseEntity<Lead> cadastraLead(@RequestBody Lead lead){
		Lead novoLead = null;
		if(lead != null) {
			novoLead = service.cadastraLead(lead);
			return ResponseEntity.ok(novoLead);
		}
			
		return ResponseEntity.badRequest().build();
	}
}
