package com.industrial.uce.service;

import java.util.List;

import com.industrial.uce.repository.modelo.Estudiante;
import com.industrial.uce.service.to.EstudianteTO;

public interface IEstudianteService {

	public void insertarEstudiante(Estudiante estudiante);

	public Estudiante buscarPorId(Integer id);

	public Estudiante seleccionarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);

	public List<EstudianteTO> buscarTodos();

}
