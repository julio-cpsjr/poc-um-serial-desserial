package br.com.poc.desafio.controller;


import br.com.poc.desafio.service.DesafioService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.swagger.v3.core.util.Json;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

@RestController
@RequestMapping("/file")
public class DesafioController {

    public final DesafioService service;

    public DesafioController (DesafioService service){
        this.service = service;
    }


    @PostMapping("/save")
    public ResponseEntity saveFile(@RequestBody String string, SessionStatus sessionStatus) throws IOException {
        if(service.saveString(string)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Json Inválido.");
        }
    }

    @GetMapping
    public ResponseEntity getFile()throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootJson = mapper.readTree(service.getString());
        Object srtJson = rootJson.asText();


        //Set conjunt = new HashSet(List.of("coisa", "casa", "texto", "casa", "chão"));
        return ResponseEntity.status(HttpStatus.OK).body("A string é:" +new String(service.getString()) +"O Json: " + rootJson.asText() + " Classe Objeto: "+ srtJson.getClass()+ " O objeto:" + srtJson.toString());
    }
}
