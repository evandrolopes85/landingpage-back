package io.github.evandrolopes85.landingpage.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.evandrolopes85.landingpage.model.Lead;

public interface LeadDAO extends CrudRepository<Lead, Integer>{

}
