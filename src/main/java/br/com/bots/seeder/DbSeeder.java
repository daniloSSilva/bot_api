package br.com.bots.seeder;

import br.com.bots.model.Bot;
import br.com.bots.repository.BotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DbSeeder implements CommandLineRunner {

	private BotRepository botRepository;
	
	public DbSeeder(BotRepository botRepository) {
		this.botRepository = botRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		botRepository.deleteAll();
		Bot bot = new Bot();

		bot.setId(UUID.randomUUID().toString());
		bot.setName("Aureo");

		botRepository.insert(bot);
	}

}
