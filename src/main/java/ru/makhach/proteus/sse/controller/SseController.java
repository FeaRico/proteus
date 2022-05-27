package ru.makhach.proteus.sse.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ru.makhach.proteus.sse.service.subscribe.EventSubscribeService;

import javax.validation.constraints.NotNull;

// TODO: 27.05.2022 Пока передаём айди клиента в параметрах, поменять

@RestController
@RequestMapping("api/v1/sse")
@Validated
public class SseController {
    private final EventSubscribeService subscribeService;

    public SseController(EventSubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @GetMapping("/subscribe")
    public SseEmitter subscribe(@RequestParam @NotNull String clientId) {
        return subscribeService.subscribe(clientId, -1L);
    }

    @GetMapping("/unsubscribe")
    public void unsubscribe(@RequestParam @NotNull String clientId) {
        subscribeService.unsubscribe(clientId);
    }
}
