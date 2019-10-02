package br.edu.infnet.museuApp.app.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.museuApp.app.model.Museu;
import br.edu.infnet.museuApp.app.model.persistence.MuseuDao;


@Service
public class MuseuService {

	@Autowired
	private MuseuDao dao;
	
	
	public MuseuService() {
		
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Museu> getMuseus() {
		return dao.getAll();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public Museu getMuseu(String id) {
		Objects.requireNonNull(id, "Vai para lá com esse id nullo");
		
		Integer integer = Integer.valueOf(id);
		return dao.findOne(integer);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void persite(Museu museu) {
		dao.salvar(museu);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Museu museu) {
		dao.editar(museu);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String id) {
		Objects.requireNonNull(id, "Vai para lá com esse id nullo");
		Integer integer = Integer.valueOf(id);
		dao.deletar(integer);
	}
	

	
}
