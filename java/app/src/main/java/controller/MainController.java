package controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import service.StructureService;

import javax.xml.stream.events.EntityReference;
import java.io.File;

@Controller
@RequestMapping("api/data")
public class MainController {

    private final StructureService structureService;

    public MainController(StructureService structureService) {
        this.structureService = structureService;
    }


    @PostMapping("/upload")
    public void uploadTable(MultipartFile file) {

        switch (this.structureService.upload(file)) {
            case 0:
                System.out.println("Uploading was successful.");
            case -1:
                System.out.println("file is empty.");
            case -2:
                System.out.println("Something went wrong within try");
            case -3:
                System.out.println("Name of the table is problematic");
            case -4:
                System.out.println("wrong amount of columns in the given table");
        }


    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> getActiveSequences() {


        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearTheTables() {

        this.structureService.clearAllTheTables();
        return ResponseEntity.noContent().build();
    }


}
