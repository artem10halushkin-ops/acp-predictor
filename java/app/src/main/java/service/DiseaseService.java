package service;

import org.springframework.stereotype.Service;


@Service
class DiseaseService {

    private final repository.DiseaseRepository diseaseRepository;


    public DiseaseService(repository.DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;

    }

}
