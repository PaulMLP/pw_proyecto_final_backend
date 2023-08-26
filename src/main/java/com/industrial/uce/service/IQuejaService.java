package com.industrial.uce.service;

import java.util.List;

import com.industrial.uce.repository.modelo.Queja;
import com.industrial.uce.service.to.QuejaTO;

public interface IQuejaService {

	public void guardarQueja(Queja queja);

	public QuejaTO buscarPorId(Integer id);

	public List<QuejaTO> buscarTodas();
	
	public void actualizar (Queja queja);
	
	public void eliminar(Integer id);
}
