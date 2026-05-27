package br.com.poc.desafio.controller;


import br.com.poc.desafio.service.DesafioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class DesafioController {

    public final DesafioService service;

    public DesafioController (DesafioService service){
        this.service = service;
    }


    @PostMapping("/save")
    public ResponseEntity saveFile(@RequestBody String string, SessionStatus sessionStatus) throws IOException {
        service.saveString(string);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity getFile()throws IOException{
        String string = new String(service.getString());
        return ResponseEntity.status(HttpStatus.OK).body("A String enviada é: "+ string);
    }
}
