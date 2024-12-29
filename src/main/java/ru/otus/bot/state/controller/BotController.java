package ru.otus.bot.state.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.bot.state.repository.model.BotStateWrapper;
import ru.otus.bot.state.service.BotStateService;


@RestController
@RequiredArgsConstructor
public class BotController {
    private final BotStateService botStateService;


    @GetMapping(value = "${bot-state.api.sub-path.id}")
    public ResponseEntity<BotStateWrapper> getBotStateById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(botStateService.findById(id));
    }

    @GetMapping(value = "${bot-state.api.sub-path.all}")
    public ResponseEntity<List<BotStateWrapper>> getBotStateList() {
        return ResponseEntity.ok(botStateService.findAllBotStates());
    }
}
