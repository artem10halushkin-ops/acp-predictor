package Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
class ServerController {

    @PostMapping("")
    public ResponseEntity<Boolean> postSamples(@RequestBody  ) {


    }




}