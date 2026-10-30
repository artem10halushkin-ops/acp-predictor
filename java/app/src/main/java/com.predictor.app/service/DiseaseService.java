package com.predictor.app.service;

import com.predictor.app.repository.DiseaseRepository;
import org.springframework.stereotype.Service;


@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;


    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;

    }

}
