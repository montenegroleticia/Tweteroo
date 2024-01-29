package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.repositories.TweteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/")
public class TweteController {

    private TweteRepository tweteRepository;

    TweteController(TweteRepository tweteRepository) {
        this.tweteRepository = tweteRepository;
    }

    @GetMapping
    public List<TweteModel> getTwete() {
        return tweteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TweteModel> getTweteById(@PathVariable("id") Long id) {
        Optional<TweteModel> twete = tweteRepository.findById(id);

        if (!twete.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(twete.get());
    }

    @PostMapping
    public String postMethodName(@RequestBody String body) {
        return body;
    }

    @PutMapping("/{id}")
    public String putTwete(@PathVariable Long id, @RequestBody String body) {
        return body + id;
    }

    @DeleteMapping("/{id}")
    public String deleteTwete(@PathVariable Long id) {
        return "Deletar item " + id;
    }

}
