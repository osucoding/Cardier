package osu.example.cardier.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SampleService {

    @GetMapping(value = "/status/ping" , produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFact () throws JsonProcessingException{

        return "pong";
    }
}
