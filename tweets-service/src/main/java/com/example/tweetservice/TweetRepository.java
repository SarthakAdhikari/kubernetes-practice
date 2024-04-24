package com.example.tweetservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    public List<Tweet> findTweetsByUser(User user);

}
