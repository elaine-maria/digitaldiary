package co.mydiary.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventAccessException extends RuntimeException {

    public EventAccessException() {

        super("No entry for event: %s in diary");
        log.warn("Unable to find event");
    }
}
