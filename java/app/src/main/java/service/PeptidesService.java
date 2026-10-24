package service;

import org.springframework.stereotype.Service;
import repository.PeptideRepository;


@Service
class PeptidesService {

    private final PeptideRepository peptideRepository;


    public PeptidesService(PeptideRepository peptideRepository) {
        this.peptideRepository = peptideRepository;

    }

}