package com.flex.BackendAPI.controllers;

import com.flex.BackendAPI.utility.Constants;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SampleControllers {
    private static List<Tuple> allTuplesSubmitted = new ArrayList<>();
    private static List<SampleObject> allSampleObjectsReturned = new ArrayList<>();

    /**
     * Default response with no request body or params
     */
    @GetMapping(Constants.API_HEADER + "ping")
    public String getResponse() {
        return "pong";
    }

    /**
     * Returns a string constructed from URL param
     * @param name URL argument in form of ?name=[nameHere]
     */
    @GetMapping(Constants.API_HEADER + "hello")
    public String getHelloWithName(String name) {
        return "Hello " + name;
    }

    /**
     * Post example to a server with a JSON object
     * @param tuple A JSON object of type {@link Tuple}
     * @return      Returns a {@link SampleObject} with the total value of the tuple loaded in
     */
    @CrossOrigin
    @PostMapping(Constants.API_HEADER + "sample")
    public SampleObject getSampleObject(@RequestBody Tuple tuple) {
        return new SampleObject(tuple.getTotal());
    }



    @Data
    private static class SampleObject {
        private String id;
        private int value;

        public SampleObject() {

        }

        SampleObject(int value) {
            setValue(value);
        }
    }

    @Data
    private static class Tuple {
        private int first;
        private int second;

        public int getTotal() {
            return getFirst() + getSecond();
        }
    }
}
