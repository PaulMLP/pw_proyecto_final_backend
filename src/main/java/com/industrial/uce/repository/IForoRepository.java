package com.industrial.uce.repository;

import java.util.List;

import com.industrial.uce.repository.modelo.Foro;

public interface IForoRepository {
	public void insertar(Foro foro);

	public Foro buscarPorId(Integer id);

	public List<Foro> buscarTodos();

	public void actualizar(Foro foro);

	public void eliminar(Integer id);

	public List<Foro> buscarPorCedulaEstudiante(String cedula);
}
