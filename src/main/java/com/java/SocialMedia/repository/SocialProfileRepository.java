package com.java.SocialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SocialMedia.model.SocialProfile;

public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {

}
