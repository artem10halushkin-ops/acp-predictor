package service;

import entity.Disease;
import org.springframework.stereotype.Service;
import repository.DiseaseRepository;
import repository.PeptideRepository;


@Service
class DiseaseService {

    private final DiseaseRepository diseaseRepository;


    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;

    }

}
