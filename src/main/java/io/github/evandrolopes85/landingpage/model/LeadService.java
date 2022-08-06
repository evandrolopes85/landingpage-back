package io.github.evandrolopes85.landingpage.model;

import java.util.ArrayList;

public interface LeadService {
	public Lead cadastraLead(Lead lead);
	public ArrayList<Lead> recuperaTodosOsLeads();
}
