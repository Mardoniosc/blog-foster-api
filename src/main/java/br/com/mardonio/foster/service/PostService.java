package br.com.mardonio.foster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mardonio.foster.domain.Post;
import br.com.mardonio.foster.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post find(Integer id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElse(null);
	}
}
