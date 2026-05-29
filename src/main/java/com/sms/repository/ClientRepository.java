package com.sms.repository;

import com.sms.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByLoginOrEmail(String login, String email);

    Optional<Client> findByLogin(String login);
}
