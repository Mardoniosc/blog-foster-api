package br.com.mardonio.foster.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@GetMapping()
	public String listar() {
		return "Rest funcionando perfeitamente";
	}

}
