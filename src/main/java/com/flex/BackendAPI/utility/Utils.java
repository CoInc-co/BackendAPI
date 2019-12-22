package com.flex.BackendAPI.utility;

import com.flex.BackendAPI.utility.structures.TimeAtMoment;

import java.util.Collections;
import java.util.Map;

public class Utils {
    /**
     * Creates a JSON from a field name and object
     * @param fieldName The field name of the JSON
     * @param object    The object(s) stored in JSON
     * @return          A JSON mapped
     */
    public static Map<?, ?> createJSON(String fieldName, Object object) {
        return Collections.singletonMap(fieldName, object);
    }

    /**
     * Sends a message out to console with time stamp of log execution
     *
     * NOTE: use %s to replace part of string with object
     *
     * @param message   message to display with replaceable characters for objects
     * @param objects   Objects to replace inside of the message string
     */
    public static void log(String message, Object... objects) {
        TimeAtMoment timeAtMoment = new TimeAtMoment(System.currentTimeMillis());

        System.out.println("[" + timeAtMoment + "] " + String.format(message, objects));
    }
}
