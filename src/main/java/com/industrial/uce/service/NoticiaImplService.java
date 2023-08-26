package com.industrial.uce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.industrial.uce.repository.INoticiaRepository;
import com.industrial.uce.repository.modelo.Noticia;
import com.industrial.uce.service.to.NoticiaTO;

@Service
public class NoticiaImplService implements INoticiaService {

	@Autowired
	private INoticiaRepository noticiaRepository;

	@Override
	public void guardarNoticia(Noticia noticia) {
		this.noticiaRepository.insertaNoticia(noticia);
	}

	@Override
	public NoticiaTO buscarPorId(Integer id) {
		return this.convertirNoticiaATo(this.noticiaRepository.buscaNoticia(id));
	}

	@Override
	public List<NoticiaTO> buscarTodas() {
		List<Noticia> lista = this.noticiaRepository.buscaTodasNoticias();
		List<NoticiaTO> listaTO = lista.stream().map(noticia -> this.convertirNoticiaATo(noticia))
				.collect(Collectors.toList());
		return listaTO;
	}

	public void actualizar (Noticia noticia) {
		this.noticiaRepository.actualizar(noticia);
	}
	
	@Override
	public void eliminar(Integer id) {
		this.noticiaRepository.eliminar(id);
	}

	private NoticiaTO convertirNoticiaATo(Noticia noticia) {
		NoticiaTO noticiaTO = new NoticiaTO();
		noticiaTO.setId(noticia.getId());
		noticiaTO.setTitulo(noticia.getTitulo());
		noticiaTO.setTexto(noticia.getTexto());
		noticiaTO.setImagen(noticia.getImagen());
		noticiaTO.setVideo(noticia.getVideo());
		noticiaTO.setFechaPublicacion(noticia.getFechaPublicacion());
		return noticiaTO;
	}

}
