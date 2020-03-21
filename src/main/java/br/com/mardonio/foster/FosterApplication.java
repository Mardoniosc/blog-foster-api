package br.com.mardonio.foster;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mardonio.foster.domain.Post;
import br.com.mardonio.foster.repository.PostRepository;

@SpringBootApplication
public class FosterApplication implements CommandLineRunner{
	
	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(FosterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Post p1 = new Post(1, "Teste", "Conteudo do post aqui", new Date(), null);
		Post p2 = new Post(2, "Covid-19", "Conteudo e noticias sobre o virus", new Date(), null);
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
