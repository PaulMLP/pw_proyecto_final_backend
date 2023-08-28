package com.industrial.uce.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.industrial.uce.repository.modelo.Estudiante;
import com.industrial.uce.service.IEstudianteService;
import com.industrial.uce.service.to.EstudianteTO;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.seleccionarPorCedula(cedula);
	}

	// GET
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodos() {
		List<EstudianteTO> lista = this.estudianteService.buscarTodos();
		for (EstudianteTO e : lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).consultarPorCedula(e.getCedula()))
					.withSelfRel();
			e.add(myLink);
		}
		return new ResponseEntity<>(lista, new HttpHeaders(), 200);
	}

	// POST
	@PostMapping(consumes = "application/json", produces = "application/json")
	public void insertarEstudiante(@RequestBody Estudiante estudiante) {
		this.estudianteService.insertarEstudiante(estudiante);
	}

	// PUT
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	// PATCH
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);

		String cedula = "1001865409";
		Estudiante estu1 = this.estudianteService.seleccionarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());

		this.estudianteService.actualizar(estu1);
	}

	// DELETE
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
	public Estudiante borrar(@PathVariable Integer id) {
		Estudiante est = this.estudianteService.buscarPorId(id);
		this.estudianteService.eliminar(id);
		return est;
	}

}
