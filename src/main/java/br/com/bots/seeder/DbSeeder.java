package br.com.bots.seeder;

import br.com.bots.model.Bot;
import br.com.bots.model.Message;
import br.com.bots.repository.BotRepository;
import br.com.bots.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class DbSeeder implements CommandLineRunner {

    private BotRepository botRepository;
    private MessageRepository messageRepository;

    public DbSeeder(BotRepository botRepository, MessageRepository messageRepository) {
        this.botRepository = botRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        botRepository.deleteAll();
        messageRepository.deleteAll();
        {
            Bot bot = new Bot();
            bot.setId(UUID.randomUUID().toString());
            bot.setName("Bot 1");

            botRepository.insert(bot);


            Message m = new Message();
            m.setId(UUID.randomUUID().toString());
            m.setFrom(bot.getId());
            m.setTo(UUID.randomUUID().toString());
            m.setConversationId(UUID.randomUUID().toString());
            m.setText("Olá posso ajudar? (Bot)");
            m.setTimestamp(new Date());

            messageRepository.insert(m);

            Message m2 = new Message();
            m2.setId(UUID.randomUUID().toString());
            m2.setFrom(m.getTo());  // id do user nao sei quem é
            m2.setTo(bot.getId());
            m2.setConversationId(m.getConversationId());
            m2.setText("Gostaria de fazer um upgrade do meu plano (User)");
            m2.setTimestamp(new Date());

            messageRepository.insert(m2);


            Message m3 = new Message();
            m3.setId(UUID.randomUUID().toString());
            m3.setFrom(bot.getId());
            m3.setTo(m.getTo());
            m3.setConversationId(m.getConversationId());
            m3.setText("Plano atualizado com sucesso. ");
            m3.setTimestamp(new Date());

            messageRepository.insert(m3);
        }
        {
            Bot bot = new Bot();
            bot.setId(UUID.randomUUID().toString());
            bot.setName("Bot 2");

            botRepository.insert(bot);

            Message m = new Message();
            m.setId(UUID.randomUUID().toString());
            m.setFrom(bot.getId());
            m.setTo(UUID.randomUUID().toString());
            m.setConversationId(UUID.randomUUID().toString());
            m.setText("Olá posso ajudar? (Bot)");
            m.setTimestamp(new Date());

            messageRepository.insert(m);

            Message m2 = new Message();
            m2.setId(UUID.randomUUID().toString());
            m2.setFrom(m.getTo());
            m2.setTo(bot.getId());
            m2.setConversationId(m.getConversationId());
            m2.setText("Não. (User)");
            m2.setTimestamp(new Date());

            messageRepository.insert(m2);
        }
    }

}
