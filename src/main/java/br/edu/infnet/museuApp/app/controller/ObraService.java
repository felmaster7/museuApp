package br.edu.infnet.museuApp.app.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.museuApp.app.model.Obra;
import br.edu.infnet.museuApp.app.model.persistence.ObraDao;

@Service
public class ObraService {

	@Autowired
	private ObraDao dao;
	
	public ObraService() {
		
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Obra> getObras() {
		return dao.getAll();
	}
	
	public List<Obra> getObrasExtras() {
		return dao.getAllNot();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public Obra getObra(String id) {
		Objects.requireNonNull(id, "Vai para lá com esse id nullo");
		
		Integer integer = Integer.valueOf(id);
		return dao.findOne(integer);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void persite(Obra obra) {
		dao.salvar(obra);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Obra obra) {
		dao.editar(obra);
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void delete(String id) {
		Objects.requireNonNull(id, "Vai para lá com esse id nullo");
		System.out.println("Entrei no service deletar");
		Integer integer = Integer.valueOf(id);
		dao.deletar(integer);
	}


	
}
