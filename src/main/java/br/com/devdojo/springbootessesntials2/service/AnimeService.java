package br.com.devdojo.springbootessesntials2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devdojo.springbootessesntials2.domain.Anime;
import br.com.devdojo.springbootessesntials2.exception.BadRequestException;
import br.com.devdojo.springbootessesntials2.repository.AnimeRepository;
import br.com.devdojo.springbootessesntials2.requests.AnimePostRequestBody;
import br.com.devdojo.springbootessesntials2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }
    
    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(anime);
    }
}
