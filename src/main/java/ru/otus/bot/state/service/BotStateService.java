package ru.otus.bot.state.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.state.data.BotState;
import ru.otus.bot.state.repository.BotStateRepository;
import ru.otus.bot.state.repository.model.BotStateWrapper;

@Service
@RequiredArgsConstructor
public class BotStateService {
    private final BotStateRepository botStateRepository;


    @Transactional
    public void save(BotStateWrapper botStateWrapper) {
        botStateRepository.save(botStateWrapper);
    }


    @Transactional(readOnly = true)
    public BotStateWrapper findById(Long id) {
        return botStateRepository.findById(String.valueOf(id))
                                 .orElse(new BotStateWrapper().setBotState(BotState.INFORM));
    }


    @Transactional(readOnly = true)
    public List<BotStateWrapper> findAllBotStates() {
        return botStateRepository.findAll();
    }
}
