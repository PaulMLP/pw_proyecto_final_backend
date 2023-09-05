package com.industrial.uce.repository;

import java.util.List;

import com.industrial.uce.repository.modelo.Comentario;

public interface IComentarioRepository {
	
	public void insertar(Comentario comentario);
	public Comentario buscarPorId(Integer id);
	public void eliminar(Integer id);
	public List<Comentario> buscarPorCedulaEstudiante(String cedula);
	public List<Comentario> buscarPorIdForo(Integer idForo);
	public List<Comentario> buscaTodosComentarios();
}
