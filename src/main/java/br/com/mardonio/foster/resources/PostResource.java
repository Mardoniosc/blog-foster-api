package br.com.mardonio.foster.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mardonio.foster.domain.Post;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@GetMapping()
	public List<Post> listar() {
		Post p1 = new Post(1, "Teste", "Conteudo do post aqui", new Date(), null);
		Post p2 = new Post(2, "Covid-19", "Conteudo e noticias sobre o virus", new Date(), null);
		
		List<Post> lista = new ArrayList<>();
		
		lista.add(p1);
		lista.add(p2);
		
		return lista;
	}

}
