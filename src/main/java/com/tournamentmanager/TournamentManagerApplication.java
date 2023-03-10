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
public class TournamentManagerApplication {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(TournamentManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TournamentManagerApplication.class, args);
	}


}
