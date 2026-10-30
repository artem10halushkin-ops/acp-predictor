package controller;


import entity.Peptide;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerRequest;
import service.StructureService;

import javax.xml.stream.events.EntityReference;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

        List<Peptide> list = this.structureService.getAllActiveSequences();
        if (list.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        StringBuilder content = new StringBuilder();
        content.append("ID, Sequence\n");
        for (Peptide p : list) {
            content.append(p.getId()).append(",").append(p.getSequence()).append("\n");
        }

        byte[] contentInBytes = content.toString().getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "active_peptides.csv");


        return ResponseEntity.ok().headers(headers).contentLength(contentInBytes.length).body(contentInBytes);
    }


    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearTheTables() {

        this.structureService.clearAllTheTables();
        return ResponseEntity.noContent().build();
    }


}
