package com.java.SocialMedia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SocialMedia.model.SocialUser;
import com.java.SocialMedia.service.SocialService;

@RestController
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("/activeUsers")
    public ResponseEntity<List<SocialUser>> getActiveUsers() {
        return ResponseEntity.ok(socialService.getActiveUsers());
    }

    @PostMapping("/addUser")
    public ResponseEntity<SocialUser> addUser(@RequestBody SocialUser user) {
        return ResponseEntity.ok(socialService.addUser(user));
    }
}
