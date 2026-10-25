package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.DiseaseService;
import service.PeptidesService;


@RestController
@RequestMapping("api/diseases")
public class DiseaseController {
    private DiseaseService diseaseService;
    //private PeptidesService peptidesService;

    @PostMapping("/upload")
    public ResponseEntity<String> postSamples(@RequestParam("file") MultipartFile file) {



        return ResponseEntity.noContent().build();
    }




}