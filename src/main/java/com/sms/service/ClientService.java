package com.sms.service;

import com.sms.dto.ClientLoginDTO;
import com.sms.dto.ClientRegisterDTO;
import com.sms.entity.Client;
import com.sms.enums.ProfileStatusEnum;
import com.sms.exception.ItemAlreadyExistException;
import com.sms.exception.ItemNotFoundException;
import com.sms.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String save(ClientRegisterDTO dto) {
        Optional<Client> optional = clientRepository.findByLoginOrEmail(dto.getLogin(), dto.getEmail());
        if(optional.isPresent()){
            throw new ItemAlreadyExistException("Login or Email already exists");
        }
        Client client = new Client();
        client.setCompanyName(dto.getCompanyName());
        client.setOwnerName(dto.getOwnerName());
        client.setOwnerSurname(dto.getOwnerSurname());
        client.setPhone(dto.getPhone());
        client.setLogin(dto.getLogin());
        client.setEmail(dto.getEmail());
        client.setPassword(passwordEncoder.encode(dto.getPassword()));
        client.setBalance(0D);
        client.setVisible(Boolean.TRUE);
        client.setStatus(ProfileStatusEnum.ACTIVE);
        client.setCreatedDate(LocalDateTime.now());

        clientRepository.save(client);

        return "Successfully registered";
    }

    public Integer login(ClientLoginDTO dto) {
        Optional<Client> optional = clientRepository.findByLogin(dto.getLogin());
        if(optional.isEmpty()){
            throw new ItemNotFoundException("Login or password is wrong");
        }

        if(!passwordEncoder.matches(dto.getPassword(), optional.get().getPassword())){
            throw new ItemNotFoundException("Login or password is wrong");
        }
        return optional.get().getId();
    }
}
