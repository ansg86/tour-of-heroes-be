package com.hero.service;

import com.hero.model.Hero;
import com.hero.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getHeroes() {
        return StreamSupport.stream(heroRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Hero getHeroById(int id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero insertOrUpdateHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public void deleteHero(int id) {
        heroRepository.deleteById(id);
    }

    public List<Hero> findHeroWithNameLike(String name) {
        return heroRepository.findByNameContaining(name);
    }
}
