package br.com.mardonio.foster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mardonio.foster.domain.Post;
import br.com.mardonio.foster.repository.PostRepository;
import br.com.mardonio.foster.service.exceptions.DataIntegrityException;
import br.com.mardonio.foster.service.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post find(Integer id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Post.class.getName()));
	}
	
	public Post insert(Post obj) {
		obj.setId(null);
		return postRepository.save(obj);
	}
	
	public Post update(Post obj) {
		find(obj.getId());
		
		return postRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			postRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o post");
		}
	}
}
