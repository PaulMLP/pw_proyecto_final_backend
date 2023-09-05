package com.industrial.uce.service;

import java.util.List;

import com.industrial.uce.repository.modelo.Foro;
import com.industrial.uce.service.to.ForoTO;

public interface IForoService {
	public void guardar(ForoTO foro);

	public ForoTO buscarPorId(Integer id);

	public Foro buscarPorIdNormal(Integer id);

	public List<ForoTO> buscarTodos();

	public void actualizar(Foro foro);

	public void eliminar(Integer id);

	public List<ForoTO> buscarPorCedulaEstudiante(String cedula);
}
