package br.edu.infnet.museuApp.app.controller;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.museuApp.app.model.Museu;
import br.edu.infnet.museuApp.app.model.Obra;
import br.edu.infnet.museuApp.app.model.persistence.MuseuDao;
import br.edu.infnet.museuApp.app.model.persistence.MuseuObraDao;
import br.edu.infnet.museuApp.app.model.persistence.ObraDao;


@Service
public class MuseuObraService {

	@Autowired
	private MuseuDao dao;
	@Autowired
	private ObraDao oDao;
	@Autowired
	private MuseuObraDao moDao;
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAdd(String obraId, String museuId) {
		Objects.requireNonNull(obraId, "Vai para lá com esse id nullo");
		Objects.requireNonNull(museuId, "Vai para lá com esse id nullo");
		Integer obra = Integer.valueOf(obraId);
		Integer museu = Integer.valueOf(museuId);
		Museu m=dao.findOne(museu);
		Obra o = oDao.findOne(obra);
		Set<Obra>s= m.getAcervo();
		s.add(o);
		m.setAcervo(s);
		dao.editar(m);
	}
		
	@Transactional(propagation = Propagation.REQUIRED) //nenhum dos tipos de propagação funcionou (NESTED apagou dos dois bancos)
	public void updateRemove(String obraId, String museuId) {
		System.out.println("Entrei no service do obra museu");
		Objects.requireNonNull(obraId, "Vai para lá com esse id nullo");
		Objects.requireNonNull(museuId, "Vai para lá com esse id nullo");
		Integer obra = Integer.valueOf(obraId);
		//Integer museu = Integer.valueOf(museuId);
		moDao.deletar(obra);
		
//		Museu m=dao.findOne(museu);
//		Obra o = oDao.findOne(obra);
//		Set<Obra>s= m.getAcervo();
//		s.remove(o);
//		m.setAcervo(s);

	}
	
}
