package io.github.evandrolopes85.landingpage.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.evandrolopes85.landingpage.model.Lead;
import io.github.evandrolopes85.landingpage.services.ILeadService;

@RestController
@CrossOrigin("*")
public class LeadController {
	
	@Autowired
	private ILeadService service;
	
	@GetMapping("/lead")
	public ResponseEntity<ArrayList<Lead>> recuperaTodosOsLeads(@RequestParam(name = "url") String url) throws IOException{
		ArrayList<Lead> leads = service.recuperaTodosOsLeads();
		
		if(leads != null) {
			FileWriter fw = new FileWriter("./"+url, false);
			BufferedWriter br = new BufferedWriter(fw);
			br.write("id_lead;nome;email"+"\n");
			for (Lead lead : leads) {
				br.write(lead.getIdLead() + ";" + lead.getNome() + ";" + lead.getEmail()+"\n");
			}
			br.close();
			fw.close();
			return ResponseEntity.ok(leads);
		}
		
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
