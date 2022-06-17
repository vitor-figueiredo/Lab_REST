package br.inatel.labs.labrest.server.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.inatel.labs.labrest.server.model.Curso;

@Service
public class CursoService {
	
	private Map<Long, Curso> mapa = new HashMap<>();
	
	
	@PostConstruct
	private void setup() {
		Curso c1 = new Curso(1L, "REST com Spring Boot", 20);
		Curso c2 = new Curso(2L, "Java 11", 80);
		Curso c3 = new Curso(3L, "Configurado e Desenvolvendo com Eclipxe", 40);
		
		mapa.put(c1.getId(), c1);
		mapa.put(c2.getId(), c2);
		mapa.put(c3.getId(), c3);
	}
	
	
	public List<Curso> pesquisarCurso() {
		return mapa.entrySet().stream()
				.map( m -> m.getValue() )
				.collect( Collectors.toList() );
	}
	
	
	public Curso buscarCursoPeloId(Long cursoId) {
		Curso cursoEncontrado = mapa.get( cursoId );
		return cursoEncontrado;
	}
	
	
	public Curso criarCurso(Curso curso) {
		Long cursoId = gerarCursoIdUnico();
		curso.setId(cursoId);
		mapa.put(curso.getId(), curso);
		return curso;
	}

	private Long gerarCursoIdUnico() {
		return System.currentTimeMillis();
	}
	
	
	public void atualizarCurso(Curso curso) {
		mapa.put(curso.getId(), curso);
	}
	
	
	public void removerCurso(Long cursoId) {
		mapa.remove( cursoId );
	}
	
	
	public List<Curso> pesquisarCursoPeloFragDescricao(String fragDescricao){
		if (Objects.isNull(fragDescricao) || fragDescricao.isBlank()) {
			return Collections.emptyList();
		}
		
		List<Curso> listaCurso = mapa.values().stream()
			.filter(c -> c.getDescricao().trim().toLowerCase().contains( fragDescricao.trim().toLowerCase() ))
			.collect( Collectors.toList() )
			;
		
		return listaCurso;
	}

}
