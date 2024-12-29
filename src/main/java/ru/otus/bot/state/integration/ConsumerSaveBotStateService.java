package ru.otus.bot.state.integration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.state.repository.model.BotStateWrapper;
import ru.otus.bot.state.service.BotStateService;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerSaveBotStateService {

  private static final String topicTelegram = "${topic.consumer.state}";
  private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
  private final BotStateService botStateService;

  @Transactional
  @KafkaListener(topics = topicTelegram, groupId = kafkaConsumerGroupId, properties = {"spring.json.value.default.type=ru.otus.bot.state.repository.model.BotStateWrapper"})
  public BotStateWrapper createOrder(BotStateWrapper botStateWrapper) {
    log.info("Message consumed {}", botStateWrapper);
    botStateService.save(botStateWrapper);
    return botStateWrapper;
  }
}
