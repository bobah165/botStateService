package ru.otus.bot.state.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.bot.state.repository.model.BotStateWrapper;

@Repository
public interface BotStateRepository extends JpaRepository<BotStateWrapper, String> {
}
