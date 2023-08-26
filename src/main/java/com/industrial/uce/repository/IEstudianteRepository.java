package com.industrial.uce.repository;

import java.util.List;

import com.industrial.uce.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public Estudiante buscarPorId(Integer id);
	
	public Estudiante seleccionarPorCedula(String cedula);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String suscripcionActual, String suscripcionNueva);

	public void borrar(Integer id);
	
	public List<Estudiante> buscarTodos();
	
}