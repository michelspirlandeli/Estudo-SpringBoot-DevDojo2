package br.com.devdojo.springbootessesntials2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devdojo.springbootessesntials2.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

	List<Anime> findByName(String name);
}