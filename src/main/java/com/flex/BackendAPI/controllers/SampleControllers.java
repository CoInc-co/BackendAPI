package com.flex.BackendAPI.controllers;

import com.flex.BackendAPI.utility.Constants;
import lombok.Data;
import org.springframework.web.bind.annotation.*;



@RestController
public class SampleControllers {
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


    @PostMapping(Constants.API_HEADER + "sample")
    public SampleObject getSampleObject(@RequestBody Tuple tuple) {
        System.out.println("Got tuple: " + tuple.toString());
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
