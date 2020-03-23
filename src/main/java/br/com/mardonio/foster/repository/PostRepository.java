package br.com.mardonio.foster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mardonio.foster.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}