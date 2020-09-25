package br.newtonpaiva.lab.AV1.applications.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.lab.AV1.api.livros.request.LivroRequest;
import br.newtonpaiva.lab.AV1.api.livros.resource.LivroResource;
import br.newtonpaiva.lab.AV1.api.livros.response.LivroResponse;
import br.newtonpaiva.lab.AV1.common.exceptions.NotFoundException;
import br.newtonpaiva.lab.AV1.domain.entity.Livro;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class LivroController implements LivroResource{

	private Map<String, Livro> livros = new HashMap<String, Livro>();
	
//	@Override
//	public ResponseEntity<LivroResponse> livro() {
//		Date date = new Date();
//		var response = new LivroResponse("IDLivro", "TituloLivro", "Autor", "EditoraLivro", date, 0);
//		
//		return ResponseEntity.ok(response);
//	}

	@Override
	public ResponseEntity<List<LivroResponse>> getAll() {
		
		List<Livro> lista = new ArrayList<Livro>(livros.values());	
		List<LivroResponse> response = new ArrayList<LivroResponse>();
		lista.forEach(livro -> {
			response.add(new LivroResponse(livro));
		});
	
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<LivroResponse> create(Optional<LivroRequest> request) {
		Livro livro = new Livro(
				UUID.randomUUID().toString(),
				request.get().getTitulo(),
				request.get().getAutor(),
				request.get().getEditora(),
				request.get().getDataDePublicacao(),
				request.get().getStatus());

		livro.setCreated(LocalDateTime.now());
		livro.setModified(LocalDateTime.now());
		
		livros.put(livro.getId(), livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(new LivroResponse(livro));
	}

	@Override
	public ResponseEntity<LivroResponse> getById(Optional<String> id) {
		
		Livro livro = Livro.get(id.get());		
		if (livro == null) {
			//HTTP 404
			throw new NotFoundException(id.get());
		}
		
		return ResponseEntity.ok(new LivroResponse(livro));
	}
	
	@Override
	public ResponseEntity<LivroResponse> update(
			Optional<String> id, 
			Optional<LivroRequest> request
			) {

		Livro livro = livros.get(id.get());
		
		if (livro == null) {
			//HTTP 404
			throw new NotFoundException(id.get());
		}
		
		livro.setTitulo(request.get().getTitulo());
		livro.setAutor(request.get().getAutor());
		livro.setEditora(request.get().getEditora());
		livro.setDataDePublicacao(request.get().getDataDePublicacao());
		livro.setStatus(request.get().getStatus());
		

		livro.setModified(LocalDateTime.now());

		livros.put(livro.getId(), livro);
		return ResponseEntity.status(HttpStatus.OK).body(new LivroResponse(livro));
	}
	
	@Override
	public ResponseEntity<Void> deleteById(Optional<String> id) {

		Livro livro = Livro.get(id.get());		
		if (livro == null) {
			//HTTP 404
			throw new NotFoundException(id.get());
		}

		livros.remove(id.get());
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
