package ru.otus.bot.state.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.bot.state.repository.model.BotStateWrapper;
import ru.otus.bot.state.service.BotStateService;


@RestController
@RequiredArgsConstructor
@Slf4j
public class BotController {
    private final BotStateService botStateService;


    @GetMapping(value = "${bot-state.api.sub-path.id}")
    public ResponseEntity<BotStateWrapper> getBotStateById(@PathVariable("id") Long id) {
        log.info("Get request from bot for id {}", id);
        return ResponseEntity.ok(botStateService.findById(id));
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        log.info("Get request from bot for id {}");
        return ResponseEntity.ok("hello from bot state");
    }

    @GetMapping(value = "${bot-state.api.sub-path.all}")
    public ResponseEntity<List<BotStateWrapper>> getBotStateList() {
        return ResponseEntity.ok(botStateService.findAllBotStates());
    }
}
