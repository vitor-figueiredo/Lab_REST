package br.inatel.labs.labrest.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.labs.labrest.server.model.Curso;
import br.inatel.labs.labrest.server.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	
	@GetMapping
	public List<Curso> listar() {
		List<Curso> listaCurso = service.pesquisarCurso();
		return listaCurso;
	}
	
	
	@GetMapping("/{id}")
	public Curso buscar(@PathVariable("id") Long cursoId) {
		Curso curso = service.buscarCursoPeloId( cursoId );
		if (curso != null) {
			return curso;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Curso criar(@RequestBody Curso curso) {
		Curso cursoCriado = service.criarCurso(curso);
		return cursoCriado;
	}
	
	
	@PutMapping
	public void atualizar(@RequestBody Curso curso) {
		service.atualizarCurso(curso);;
	}
	
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable("id") Long cursoIdParaRemover) {
		service.removerCurso(cursoIdParaRemover);
	}
	
	
	@GetMapping("/pesquisa")
	public List<Curso> listaPeloFragDescricao(@RequestParam("descricao") String fragDescricao) {
		List<Curso> listaCursoPesquisada = service.pesquisarCursoPeloFragDescricao(fragDescricao);
		return listaCursoPesquisada;
	}

	
}

