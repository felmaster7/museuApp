package br.edu.infnet.museuApp.app.model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.edu.infnet.museuApp.app.model.Museu_Obra;


@Repository
public class MuseuObraDao {

	
	@PersistenceContext
	private EntityManager em;
	
//	@Transactional
//	public void removeObraMuseu(Integer obraId, Integer museuId) {
//		Query query=em.createQuery("DELETE FROM Museu_Obra MO WHERE Museu_id="+museuId+" and acervo_id="+obraId);
//		//TypedQuery<Obra> query=em.createQuery("SELECT MO.acervo_id FROM Museu_Obra MO",Obra.class);
//		System.out.println("Deveria executar o update aqui");
//		query.executeUpdate();
//		em.getTransaction().commit();
//	}
	
	
	public void deletar(Integer id) {
		System.out.println(id);
		Museu_Obra m = em.find(Museu_Obra.class,id);
		em.remove(m);
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
		
	}
}
