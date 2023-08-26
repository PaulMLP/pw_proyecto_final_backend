package com.industrial.uce.service;

import java.util.List;

import com.industrial.uce.repository.modelo.Noticia;
import com.industrial.uce.service.to.NoticiaTO;

public interface INoticiaService {

	public void guardarNoticia(Noticia noticia);

	public NoticiaTO buscarPorId(Integer id);

	public List<NoticiaTO> buscarTodas();
	
	public void actualizar (Noticia noticia);
	
	public void eliminar(Integer id);
}
