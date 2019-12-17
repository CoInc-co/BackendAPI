package com.flex.BackendServer.utility;

import com.flex.BackendServer.utility.structures.TimeAtMoment;

public class Utils {
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

        for (Object object : objects)
            message = message.replaceFirst(Constants.OBJECT_INSERT_TO_STRING_REGEX, object.toString());

        System.out.println("[" + timeAtMoment + "] " + message);
    }
}