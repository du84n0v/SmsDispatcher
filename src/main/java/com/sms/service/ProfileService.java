package com.sms.service;

import com.sms.dto.LoginDTO;
import com.sms.dto.ProfileDTO;
import com.sms.entity.Profile;
import com.sms.repository.ProfileRepository;
import com.sms.util.MD5Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile create(ProfileDTO dto) {
        exist(dto.getUsername());
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setSurname(dto.getSurname());
        profile.setUsername(dto.getUsername());
        profile.setPassword(MD5Encode.encode(dto.getPassword()));
        profile.setToken(UUID.randomUUID().toString());
        profile.setCreatedDate(LocalDateTime.now());

        profileRepository.save(profile);
        return profile;
    }

    private void exist(String username) {
        Optional<Profile> optional = profileRepository.findByUsername(username);
        if(optional.isPresent()){
            throw new RuntimeException("Profile already exists");
        }
    }

    public String login(LoginDTO dto) {
        Optional<Profile> optional = profileRepository.findByUsernameAndPassword(dto.getUsername(), MD5Encode.encode(dto.getPassword()));
        if(optional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return optional.get().getToken();
    }

    public void existToken(String userToken) {
        Optional<Profile> optional = profileRepository.findByToken(userToken);
        if(optional.isEmpty()){
            throw new RuntimeException("Token not found");
        }
    }
}
