package by.uniqo.telegrambot.repository;

import by.uniqo.telegrambot.model.TextHistorySendedToClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface TextHistorySendedToClientsRepository extends JpaRepository<TextHistorySendedToClients, Long> {
    TextHistorySendedToClients findTextHistorySendedToClientsByMessageIdAndAndChatId(Long messageId, Long chatId);
    Long getTextHistorySendedToClientsByMessageId(Long messageId);
    Long getTextHistorySendedToClientsByChatId(Long chatId);
}
