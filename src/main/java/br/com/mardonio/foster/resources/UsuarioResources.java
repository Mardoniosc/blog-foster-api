package br.com.mardonio.foster.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mardonio.foster.domain.Usuario;
import br.com.mardonio.foster.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = usuarioService.find(id);
		return ResponseEntity.ok(obj);
	}

}
