package com.industrial.uce.repository;

import java.util.List;

import com.industrial.uce.repository.modelo.Noticia;

public interface INoticiaRepository {
	public void insertaNoticia(Noticia noticia);

	public Noticia buscaNoticia(Integer id);

	public List<Noticia> buscaTodasNoticias();
	
	public void actualizar (Noticia noticia);
	
	public void eliminar(Integer id);

}
