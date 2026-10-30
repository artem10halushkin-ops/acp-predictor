package controller;


import entity.Peptide;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.StructureService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/data")
public class MainController {

    private final StructureService structureService;

    public MainController(StructureService structureService) {
        this.structureService = structureService;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadTable(MultipartFile file) {
        String message = "";
        switch (this.structureService.upload(file)) {
            case 0:
                message = "Uploading was successful.";
                System.out.println("Uploading was successful.");
                return ResponseEntity.ok(message);
            case -1:
                message = "file is empty.";
                System.out.println(message);
                break;
            case -2:
                message = "Something went wrong within try";
                System.out.println(message);
                break;
            case -3:
                message = "Name of the table is problematic";
                System.out.println(message);
                break;
            case -4:
                message = "wrong amount of columns in the given table";
                System.out.println(message);
                break;
            default:
                message = "default";

        }

        return ResponseEntity.badRequest().body(message);
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
