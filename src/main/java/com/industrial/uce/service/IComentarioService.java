package com.industrial.uce.service;

import java.util.List;

import com.industrial.uce.service.to.ComentarioLigero;
import com.industrial.uce.service.to.ComentarioTO;

public interface IComentarioService {
	
	public ComentarioTO buscarPorId(Integer id);
	public void eliminar(Integer id);
	public List<ComentarioTO> buscarTodos();
	public List<ComentarioTO> buscarPorCedulaEstudiante(String cedula);
	public List<ComentarioTO> buscarPorIdForo(Integer idForo);
	public void guardar(ComentarioLigero comentario);
	
}