package com.tournamentmanager.user;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNick(String nick);

    List<User>  findByEmail(String email);

}
