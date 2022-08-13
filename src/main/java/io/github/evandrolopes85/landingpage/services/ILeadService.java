package io.github.evandrolopes85.landingpage.services;

import java.util.ArrayList;

import io.github.evandrolopes85.landingpage.model.Lead;

public interface ILeadService {
	public Lead cadastraLead(Lead lead);
	public ArrayList<Lead> recuperaTodosOsLeads();
}
