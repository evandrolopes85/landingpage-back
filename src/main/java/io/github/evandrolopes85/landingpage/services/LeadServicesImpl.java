package io.github.evandrolopes85.landingpage.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.evandrolopes85.landingpage.dao.LeadDAO;
import io.github.evandrolopes85.landingpage.model.Lead;

@Component
public class LeadServicesImpl implements ILeadService{

	@Autowired
	private LeadDAO dao;
	
	@Override
	public Lead cadastraLead(Lead lead) {
		// TODO Auto-generated method stub
		if(lead != null)
			return dao.save(lead);
		
		return null;
	}

	@Override
	public ArrayList<Lead> recuperaTodosOsLeads() {
		// TODO Auto-generated method stub
		return (ArrayList<Lead>)dao.findAll();
	}
	
}
