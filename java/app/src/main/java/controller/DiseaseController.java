package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.DiseaseService;
import service.PeptidesService;


@RestController
@RequestMapping("api/diseases")
public class DiseaseController {
    private final DiseaseService diseaseService;
    //private PeptidesService peptidesService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;

    }

    @PostMapping("/upload")
    public ResponseEntity<String> postSamples(@RequestParam("file") MultipartFile file) {

        // this.diseaseService.
        String str = file.getContentType();
        return ResponseEntity.ok(str);
    }


}