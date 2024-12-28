package ru.otus.bot.state.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.otus.bot.state.data.BotState;

@Data
@Entity
@Table(schema = "general", name = "bot_state")
@Accessors(chain = true)
@NoArgsConstructor
public class BotStateWrapper {
    @Id
    private String id;
    @Column(name = "bot_state")
    @Enumerated(EnumType.STRING)
    private BotState botState;
}
