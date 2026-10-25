package service;

import entity.Peptide;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.PeptideRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Service
public class PeptidesService {

    private final PeptideRepository peptideRepository;


    public PeptidesService(PeptideRepository peptideRepository) {
        this.peptideRepository = peptideRepository;

    }

    public int upload(MultipartFile file) {
        List<Peptide> peptides = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))


        ) {
            String line, name;
            name = reader.readLine();


        } catch (Exception e) {

        }

        return 0;
    }


}