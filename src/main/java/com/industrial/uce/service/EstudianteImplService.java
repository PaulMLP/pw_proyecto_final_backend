package com.industrial.uce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.industrial.uce.repository.IEstudianteRepository;
import com.industrial.uce.repository.modelo.Estudiante;
import com.industrial.uce.service.to.EstudianteTO;

@Service
public class EstudianteImplService implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepository.borrar(id);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.estudianteRepository.buscarPorId(id);
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		List<Estudiante> lista = this.estudianteRepository.buscarTodos();
		List<EstudianteTO> listaTO = lista.stream().map(estudiante -> this.convertir(estudiante))
				.collect(Collectors.toList());
		return listaTO;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estu = new EstudianteTO();
		estu.setId(estudiante.getId());
		estu.setCedula(estudiante.getCedula());
		estu.setNombre(estudiante.getNombre());
		estu.setSuscripcion(estudiante.getSuscripcion());
		estu.setApellido(estudiante.getApellido());
		estu.setImagen(estudiante.getImagen());

		return estu;
	}

}
