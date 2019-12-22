package com.flex.BackendAPI.controllers;

import com.flex.BackendAPI.utility.Constants;
import com.flex.BackendAPI.utility.Utils;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        allTuplesSubmitted.add(tuple);
        allSampleObjectsReturned.add(new SampleObject(tuple.getTotal()));

        return allSampleObjectsReturned.get(allSampleObjectsReturned.size() - 1);
    }

    /**
     * Get example containing different types of data,
     * including lists, and single JSON objects
     * @return  Returns a list of generic items.
     */
    @CrossOrigin
    @GetMapping(Constants.API_HEADER + "getAll")
    public List<?> getAllData() {
        int findFirstTotal = 0;
        int findSecondTotal = 0;
        int findTotal = 0;

        for (int i = 0; i < allSampleObjectsReturned.size(); i++) {
            findFirstTotal += allTuplesSubmitted.get(0).getFirst();
            findSecondTotal += allTuplesSubmitted.get(0).getSecond();
            findTotal += allSampleObjectsReturned.get(0).getValue();
        }

        return Arrays.asList(allTuplesSubmitted,
                allSampleObjectsReturned,
                Utils.createJSON("firstTotal", findFirstTotal),
                Utils.createJSON("secondTotal", findSecondTotal),
                Utils.createJSON("total", findTotal)
        );
    }



    @Data
    private static class SampleObject {
        private String id;
        private int value;

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
