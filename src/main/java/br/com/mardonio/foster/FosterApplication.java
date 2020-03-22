package br.com.mardonio.foster;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mardonio.foster.domain.Post;
import br.com.mardonio.foster.domain.Usuario;
import br.com.mardonio.foster.domain.enums.TipoCliente;
import br.com.mardonio.foster.repository.PostRepository;
import br.com.mardonio.foster.repository.UsuarioRepository;

@SpringBootApplication
public class FosterApplication implements CommandLineRunner{
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(FosterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "Mardonio", "Mardonio@live.com", "03909809878", TipoCliente.PESSOAFISICA);
		
		Post p1 = new Post(null, "Teste", "Conteudo do post aqui", new Date(), null, user1);
		Post p2 = new Post(null, "Covid-19", "Conteudo e noticias sobre o virus", new Date(), null, user1);
		
		user1.getPosts().addAll(Arrays.asList(p1,p2));

		usuarioRepository.saveAll(Arrays.asList(user1));
		postRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
