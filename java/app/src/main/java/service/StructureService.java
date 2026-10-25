package service;

import entity.Disease;
import entity.Peptide;
import entity.Peptide_Activity;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import repository.DiseaseRepository;
import repository.PeptideActivityRepository;
import repository.PeptideRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class StructureService {

    private final DiseaseRepository diseaseRepository;
    private final PeptideRepository peptideRepository;
    private final PeptideActivityRepository peptideActivityRepository;


    public StructureService(DiseaseRepository diseaseRepository, PeptideRepository peptideRepository, PeptideActivityRepository peptideActivityRepository) {
        this.diseaseRepository = diseaseRepository;
        this.peptideActivityRepository = peptideActivityRepository;
        this.peptideRepository = peptideRepository;
    }

    @Transactional
    public int upload(MultipartFile file) {

        if (file.isEmpty()) {

            return -1;
        }


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String name, line, peptideSeq, activity;
            Disease disease;
            Peptide peptide;
            Peptide_Activity peptide_activity;


            name = reader.readLine();

            if (name == null || name.trim().isEmpty()) {
                return -3;
            }
            //saving in the first Disease Table
            disease = this.diseaseRepository.findByName(name).orElse(null);
            if (disease == null) {
                Disease newDisease = new Disease();
                newDisease.setName(name);
                disease = this.diseaseRepository.save(newDisease);
            }

            reader.readLine();
            // second part saving in the second Disease Table


            while ((line = reader.readLine()) != null) {


                String[] data = line.split("\t");

                if (data.length >= 3) {
                    peptideSeq = data[1];
                    activity = data[2];
                    peptide = this.peptideRepository.findBySequence(peptideSeq).orElse(null);
                    if (peptide == null) {
                        Peptide tosavePeptide = new Peptide();
                        tosavePeptide.setSequence(peptideSeq);
                        peptide = this.peptideRepository.save(tosavePeptide);
                    }

                    peptide_activity = new Peptide_Activity();
                    peptide_activity.setDisease(disease);
                    peptide_activity.setPeptide(peptide);
                    peptide_activity.setActivityClass(activity);

                    Example<Peptide_Activity> example = Example.of(peptide_activity);
                    if (!this.peptideActivityRepository.exists(example)) {

                        this.peptideActivityRepository.save(peptide_activity);
                    }

                } else {

                    return -4;
                }

            }


        } catch (Exception e) {
            return -2;
        }


        return 0;
    }


    public List<Peptide> getAllActiveSequences() {

        List<Peptide> peptides = new ArrayList<>();


        peptides = this.peptideActivityRepository.findAll().stream()
                .filter(peptideActivity ->
                        peptideActivity.getActivityClass().equals("mod. active") || peptideActivity.getActivityClass().equals("very active"))
                .map(p -> p.getPeptide()).toList();

        return peptides;
    }

}
