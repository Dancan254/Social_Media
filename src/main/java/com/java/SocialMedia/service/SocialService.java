package com.java.SocialMedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.SocialMedia.model.SocialUser;
import com.java.SocialMedia.repository.SocialUserRepository;

@Service
public class SocialService {

    @Autowired
    SocialUserRepository socialUserRepository;

    public List<SocialUser> getActiveUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser addUser(SocialUser user) {
        return socialUserRepository.save(user);
    }
}
