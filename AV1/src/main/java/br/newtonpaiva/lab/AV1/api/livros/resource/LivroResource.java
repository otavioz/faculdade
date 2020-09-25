package br.newtonpaiva.lab.AV1.api.livros.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.newtonpaiva.lab.AV1.api.livros.request.LivroRequest;
import br.newtonpaiva.lab.AV1.api.livros.response.LivroResponse;

@RequestMapping(path = "/v1/livro")
public interface LivroResource {
	
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	ResponseEntity<LivroResponse>livro();
	
	//GET
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> getById(@PathVariable Optional<String> id);
	
	//CREATE
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> create(
    		@Valid @RequestBody Optional<LivroRequest> request);

	//GETALL
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroResponse>> getAll();
    
	//UPDATE
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> update(
    		@PathVariable Optional<String> id, 
    		@RequestBody Optional<LivroRequest> request);
    
	//DELETE
    @DeleteMapping(path = "/{id}")    
    public ResponseEntity<Void> deleteById(@PathVariable Optional<String> id);
   
}
