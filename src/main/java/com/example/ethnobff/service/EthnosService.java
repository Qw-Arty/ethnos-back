package com.example.ethnobff.service;

import com.example.ethnobff.model.Ethnos;
import com.example.ethnobff.repository.EthnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EthnosService {
    @Autowired
    private EthnosRepository ethnosRepository;

    public List<Ethnos> findAll() {
        return ethnosRepository.findAll();
    }

    public Ethnos findById(Long id) {
        return ethnosRepository.findById(id).orElse(null);
    }

    public Ethnos save(Ethnos ethnos) {
        return ethnosRepository.save(ethnos);
    }

    public void deleteById(Long id) {
        ethnosRepository.deleteById(id);
    }
}