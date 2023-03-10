package com.tournamentmanager;

import com.tournamentmanager.user.User;
import com.tournamentmanager.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TournamentManagerApplication implements CommandLineRunner {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(TournamentManagerApplication.class);

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(TournamentManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(new User("nick1", "email1", "pass1"));
		userRepo.save(new User("nick2", "email2", "pass2"));
		userRepo.save(new User("nick3", "email3", "pass3"));

		for (User user : userRepo.findAll()){
			logger.info("Nick: " + user.getNick() + " Email: " + user.getEmail() + " Pass: " + user.getPassword());
		}
	}

}
