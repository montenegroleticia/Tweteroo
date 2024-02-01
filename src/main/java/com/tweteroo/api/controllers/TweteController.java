package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.repositories.TweteRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/")
public class TweteController {

    final TweteRepository tweteRepository;

    TweteController(TweteRepository tweteRepository) {
        this.tweteRepository = tweteRepository;
    }

    @GetMapping
    public ResponseEntity<List<TweteModel>> getTwete() {
        List<TweteModel> twetes = tweteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(twetes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTweteById(@PathVariable("id") Long id) {
        Optional<TweteModel> twete = tweteRepository.findById(id);

        if (!twete.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Twete not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(twete);
    }

    @PostMapping
    public ResponseEntity<TweteModel> postTwete(@RequestBody @Valid TweteDTO body) {
        TweteModel twete = new TweteModel(body);
        return ResponseEntity.status(HttpStatus.OK).body(tweteRepository.save(twete));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putTwete(@PathVariable Long id, @RequestBody TweteDTO body) {
        Optional<TweteModel> twete = tweteRepository.findById(id);

        if (!twete.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Twete not found");
        }

        TweteModel newTwete = new TweteModel(body);
        newTwete.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tweteRepository.save(newTwete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTwete(@PathVariable Long id) {
        tweteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
