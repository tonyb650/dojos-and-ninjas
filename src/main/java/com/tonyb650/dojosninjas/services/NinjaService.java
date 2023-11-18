package com.tonyb650.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.dojosninjas.models.Ninja;
import com.tonyb650.dojosninjas.respositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepository;
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}
		return null;
	}
	
	public List<Ninja> getAllNinjas(){
		return ninjaRepository.findAll();
	}
	public void create(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public void update(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public void delete(Ninja ninja) {
		ninjaRepository.delete(ninja);
	}
}
