package com.hero.controller;

import com.hero.model.Hero;
import com.hero.service.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/heroes")
    public List<Hero> getListOfHeroes() {
        return heroService.getHeroes();
    }

    @GetMapping("/hero/{id}")
    public Hero getHeroById(@PathVariable int id) {
        return heroService.getHeroById(id);
    }

    @GetMapping("/hero/search/{name}")
    public List<Hero> findHeroContainName(@PathVariable String name) {
        return heroService.findHeroWithNameLike(name);
    }

    @PutMapping("/hero")
    public void updateHero(@RequestBody Hero hero) {
        heroService.insertOrUpdateHero(hero);
    }

    @PostMapping("/hero")
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.insertOrUpdateHero(hero);
    }

    @DeleteMapping("/hero/{id}")
    public void deleteHeroById(@PathVariable int id) {
        heroService.deleteHero(id);
    }
}
