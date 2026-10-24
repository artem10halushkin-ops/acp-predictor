package service;

import org.springframework.stereotype.Service;


@Service
class DiseaseRepository {

    private final repository.DiseaseRepository diseaseRepository;


    public DiseaseRepository(repository.DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;

    }

}
