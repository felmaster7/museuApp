package br.edu.infnet.museuApp.app.model.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import br.edu.infnet.museuApp.app.model.Obra;

@Repository
public class ObraDao extends JpaDao<Obra> {

	@PersistenceContext
	private EntityManager em;
	
	public List<Obra> getAllNot() {
		TypedQuery<Obra> query=em.createQuery("SELECT O FROM Obra O WHERE O.id not in (SELECT MO.acervo_id FROM Museu_Obra MO)",Obra.class);
		//TypedQuery<Obra> query=em.createQuery("SELECT MO.acervo_id FROM Museu_Obra MO",Obra.class);
		List<Obra> obras=query.getResultList();
		return obras;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
		
	}

}
