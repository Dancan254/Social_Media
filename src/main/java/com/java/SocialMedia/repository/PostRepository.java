package com.java.SocialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SocialMedia.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
