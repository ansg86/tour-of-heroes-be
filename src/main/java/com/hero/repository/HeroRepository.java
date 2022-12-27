package com.hero.repository;

import com.hero.model.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

    List<Hero> findByNameContaining(String name);
}
