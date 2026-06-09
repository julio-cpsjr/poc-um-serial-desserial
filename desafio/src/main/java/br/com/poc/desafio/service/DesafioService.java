package br.com.poc.desafio.service;


import com.fasterxml.jackson.core.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DesafioService {

    public Path BASE_DIR = Path.of("./storage");

    public boolean saveJson(String string) throws IOException {

        if(Files.notExists(BASE_DIR)){
             Files.createDirectory(BASE_DIR);
         }

        Path path_archive = BASE_DIR.resolve("processed.json");

       if(string.contains("{") && string.contains("}") && string.contains(":")){
           byte[] jsonString = string.getBytes();
           Files.write(path_archive,jsonString);

           return true;
       }else{
           System.out.println("Json inválido ");
           return false;
       }
    }

    public byte[] getBytes() throws IOException{
        Path path_arquive = BASE_DIR.resolve("processed.json");


        if(Files.notExists(path_arquive)){
            System.out.println("Arquivo não encontrado");
        }

        byte[] jsonString = Files.readAllBytes(path_arquive);

        return jsonString;
    }


}
