package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.repositories.TweteRepository;

@Service
public class TweteService {

    final TweteRepository tweteRepository;

    TweteService(TweteRepository tweteRepository) {
        this.tweteRepository = tweteRepository;
    }

    public List<TweteModel> findAll() {
        return tweteRepository.findAll();
    }

    public Optional<TweteModel> findById(Long id) {
        return tweteRepository.findById(id);
    }

    public TweteModel save(TweteDTO dto) {
        TweteModel twete = new TweteModel(dto);
        return tweteRepository.save(twete);
    }

    public TweteModel update(TweteDTO dto, Long id) {
        TweteModel newTwete = new TweteModel(dto);
        newTwete.setId(id);
        return tweteRepository.save(newTwete);
    }

    public void deleteById(Long id) {
        tweteRepository.deleteById(id);
    }

}
