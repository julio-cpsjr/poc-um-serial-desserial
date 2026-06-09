package br.com.poc.desafio.controller;


import br.com.poc.desafio.service.DesafioService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/file")
public class DesafioController {

    public final DesafioService service;

    public DesafioController (DesafioService service){
        this.service = service;
    }


    @PostMapping("/save")
    public ResponseEntity saveFile(@RequestBody String string) throws IOException {
        if(service.saveJson(string)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Json Inválido.");
        }
    }

    @GetMapping
    public ResponseEntity getFile()throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootJson = mapper.readTree(service.getBytes());
        Object jsonObject = rootJson;
        return ResponseEntity.status(HttpStatus.OK).body("Json Enviado: " + rootJson.asText() + " Classe: " + jsonObject.getClass());
    }
}
