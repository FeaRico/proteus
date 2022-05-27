package ru.makhach.proteus.sse.client;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class Client {
    private final String id;
    private final SseEmitter emitter;

    public Client(String id, SseEmitter emitter) {
        this.id = id;
        this.emitter = emitter;
    }

    public String getId() {
        return id;
    }

    public SseEmitter getEmitter() {
        return emitter;
    }
}
