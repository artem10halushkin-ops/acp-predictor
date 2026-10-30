package com.predictor.app.controller;

import com.predictor.app.service.DiseaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("api/diseases")
public class DiseaseController {
    private final DiseaseService diseaseService;
    //private final StructureService structureService;
    //private PeptidesService peptidesService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
        // this.structureService = structureService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> postSamples(@RequestParam("file") MultipartFile file) {

        // this.diseaseService.
        String str = file.getContentType();
        return ResponseEntity.ok(str);
    }

    @GetMapping("/delete")
    public ResponseEntity<Void> clearTables() {

        return null;
    }


}