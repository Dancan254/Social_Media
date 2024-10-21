package com.java.SocialMedia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.SocialMedia.model.Groups;
import com.java.SocialMedia.model.Post;
import com.java.SocialMedia.model.SocialProfile;
import com.java.SocialMedia.model.SocialUser;
import com.java.SocialMedia.repository.GroupsRepository;
import com.java.SocialMedia.repository.PostRepository;
import com.java.SocialMedia.repository.SocialProfileRepository;
import com.java.SocialMedia.repository.SocialUserRepository;

@Configuration
public class DataInitializer {

    @Autowired
    private SocialUserRepository socialUserRepository;
    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SocialProfileRepository socialProfileRepository;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();

            // Save users
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);

            // Create some profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();

            // Set profiles to users
            user1.setProfile(profile1);
            user2.setProfile(profile2);

            // Save profiles
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);

            // Create groups
            Groups group1 = new Groups();
            Groups group2 = new Groups();

            // Save groups first
            groupsRepository.save(group1);
            groupsRepository.save(group2);

            // Add users to groups
            group1.getMembers().add(user1);
            group1.getMembers().add(user2);

            group2.getMembers().add(user1);
            group2.getMembers().add(user2);

            // Associate groups to users
            user1.getGroups().add(group1);
            user1.getGroups().add(group2);

            user2.getGroups().add(group1);
            user2.getGroups().add(group2);

            // Save users again to update associations
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);

            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();

            // Set posts to users
            post1.setAuthor(user2);
            post2.setAuthor(user1);

            // Save posts
            postRepository.save(post1);
            postRepository.save(post2);
        };
    }
}