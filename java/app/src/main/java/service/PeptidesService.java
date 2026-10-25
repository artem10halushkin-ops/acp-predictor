package service;

import org.springframework.stereotype.Service;
import repository.PeptideRepository;


@Service
public class PeptidesService {

    private final PeptideRepository peptideRepository;


    public PeptidesService(PeptideRepository peptideRepository) {
        this.peptideRepository = peptideRepository;

    }

}