package controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/peptides")
public class PeptideController {



    @PostMapping("/upload")
    public ResponseEntity<String> postSamples(@RequestParam("file") MultipartFile file) {



        return ResponseEntity.noContent().build();
    }


}
