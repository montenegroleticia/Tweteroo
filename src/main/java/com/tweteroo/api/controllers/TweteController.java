package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/")
public class TweteController {

    @GetMapping
    public String getTwete() {
        return "data";
    }

    @GetMapping("/{id}")
    public String getTweteById(@PathVariable Long id) {
        return "Data no id " + id;
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
