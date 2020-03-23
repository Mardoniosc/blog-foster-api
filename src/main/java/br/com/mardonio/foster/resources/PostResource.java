package br.com.mardonio.foster.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mardonio.foster.domain.Post;
import br.com.mardonio.foster.dto.PostDTO;
import br.com.mardonio.foster.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> find(@PathVariable Integer id){
		Post obj = postService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PostDTO objDTO){
		Post obj = postService.fromDTO(objDTO); 
		postService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody PostDTO objDTO, @PathVariable Integer id){
		Post obj = postService.fromDTO(objDTO);
		obj.setId(id);
		obj = postService.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		postService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<Post> list = postService.findAll();
		List<PostDTO> listDTO = list.stream().map(obj -> new PostDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<PostDTO>> findPage(
				@RequestParam(value = "page", defaultValue = "0" ) Integer page,
				@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage,
				@RequestParam(value = "orderBy", defaultValue = "titulo" ) String orderBy,
				@RequestParam(value = "direction", defaultValue = "ASC" ) String direction
			) {
		Page<Post> list = postService.findPage(page, linesPerPage, orderBy, direction);
		Page<PostDTO> listDTO = list.map(obj -> new PostDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
}
