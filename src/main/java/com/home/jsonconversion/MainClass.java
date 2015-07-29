package com.home.jsonconversion;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class MainClass {

    public static void main(String[] args) {

        String jsonString = "{\"verticalId\":1,\"name\":\"Not Applicable\",\"id\":1}";

        Vertical vertical = new Vertical();

        try {

            vertical = new ObjectMapper().readValue(jsonString, Vertical.class);
            System.out.println(vertical);

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
