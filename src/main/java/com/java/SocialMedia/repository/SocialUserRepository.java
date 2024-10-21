package com.java.SocialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SocialMedia.model.SocialUser;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {

}
