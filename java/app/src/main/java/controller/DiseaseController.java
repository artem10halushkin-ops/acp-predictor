package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.DiseaseService;
import service.PeptidesService;
import service.StructureService;


@RestController
@RequestMapping("api/diseases")
public class DiseaseController {
    // private final DiseaseService diseaseService;
    private final StructureService structureService;
    //private PeptidesService peptidesService;

    public DiseaseController(StructureService structureService) {
        // this.diseaseService = diseaseService;
        this.structureService = structureService;
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