package br.com.poc.desafio.service;


import br.com.poc.desafio.exceptions.InvalidJsonException;
import br.com.poc.desafio.models.UsuarioModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DesafioService {

    public Path BASE_DIR = Path.of("./storage");

    private boolean isJsonValid(String string){
        if(string ==null || string.trim().isEmpty() ){
            return false;
        }
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.readTree(string);
            return true;
        }catch(JsonProcessingException ex){
            return false;
        }
    }



    public void saveJson(String string) throws IOException {

        if(!isJsonValid(string)){
            throw new InvalidJsonException();
        }

        if(Files.notExists(BASE_DIR)){
             Files.createDirectory(BASE_DIR);
         }

        Path path_archive = BASE_DIR.resolve("processed.json");

        byte[] jsonString = string.getBytes();
        Files.write(path_archive,jsonString);

    }

    public UsuarioModel getUsuario() throws IOException{
        Path path_arquive = BASE_DIR.resolve("processed.json");

        if(Files.notExists(path_arquive)){
            throw new IOException();
        }

        byte[] jsonString = Files.readAllBytes(path_arquive);

        ObjectMapper mapper = new ObjectMapper();
        UsuarioModel usuario = mapper.readValue(jsonString,UsuarioModel.class);
        return usuario;

    }


}
