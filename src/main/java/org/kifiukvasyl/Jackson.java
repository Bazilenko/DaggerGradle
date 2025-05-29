package org.kifiukvasyl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.kifiukvasyl.Entity.Match;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Jackson {
    ObjectMapper mapper;

    public Jackson() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public String serialization(List<Match> matches) {
        String json = null;
        try {
            json = mapper.writeValueAsString(matches);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

    public List<Match> deserialization(String json){
        List<Match>m = new ArrayList<>();
        try {
            m = mapper.readValue(json, new TypeReference<List<Match>>() {
            });
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return m;
    }

    public void writeToFile(String fileName, List<Match> matches){
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), matches);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Match> readFromFile(String fileName){
        List<Match> m = new ArrayList<>();
        try{
            m = mapper.readValue(new File(fileName), new TypeReference<List<Match>>() {});
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return m;
    }
}
