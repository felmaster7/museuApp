package br.edu.infnet.museuApp.app.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.museuApp.app.model.Todo;
import br.edu.infnet.museuApp.app.model.persistence.TodoDao;




@Service
public class TodoService {
 
	@Autowired
	private TodoDao dao;

	public TodoService() {
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Todo> getTodos() {
		return dao.getAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void persite(Todo todo) {
		dao.salvar(todo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Todo todo) {
		dao.editar(todo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String id) {
		Objects.requireNonNull(id, "vai para lá com esse id nullo");
		Integer integer = Integer.valueOf(id);
		dao.deletar(integer);
	}

	@Transactional(propagation = Propagation.NEVER)
	public Todo getTodo(String id) {
		Objects.requireNonNull(id, "vai para lá com esse id nullo");
		
		Integer integer = Integer.valueOf(id);
		return dao.findOne(integer);
	}

	public TodoDao getDao() {
		return dao;
	}

	public void setDao(TodoDao dao) {
		this.dao = dao;
	}

}
