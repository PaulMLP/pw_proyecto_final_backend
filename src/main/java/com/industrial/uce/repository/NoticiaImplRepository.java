package com.industrial.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.industrial.uce.repository.modelo.Noticia;

@Repository
@Transactional
public class NoticiaImplRepository implements INoticiaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Noticia buscaNoticia(Integer id) {
		return this.entityManager.find(Noticia.class, id);
	}

	@Override
	public List<Noticia> buscaTodasNoticias() {
		TypedQuery<Noticia> myQuery = this.entityManager
				.createQuery("SELECT n FROM Noticia n ORDER BY n.fechaPublicacion DESC", Noticia.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertaNoticia(Noticia noticia) {
		this.entityManager.persist(noticia);
	}

	
	@Override
	public void actualizar(Noticia noticia) {
		this.entityManager.merge(noticia);

	}
	
	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscaNoticia(id));
	}

}
