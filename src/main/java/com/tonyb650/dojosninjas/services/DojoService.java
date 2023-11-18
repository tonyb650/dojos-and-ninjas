package com.tonyb650.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.dojosninjas.models.Dojo;
import com.tonyb650.dojosninjas.respositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepository;

	public Dojo getDojoById(Long id) {
		Optional<Dojo> optDojo = dojoRepository.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}
		return null;
	}
	
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo update(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public void delete(Dojo dojo) {
		dojoRepository.delete(dojo);
	}
	
}

