package com.example.tweetservice;

import com.example.tweetservice.User;
import com.example.tweetservice.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@Component
public class UserMessageListener {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    Queue queue() {
        return new Queue("userQueue", false);
    }

    @RabbitListener(queues = "userQueue")
    public void receiveMessage(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        System.out.println("Received a new user: " + userDTO.getFirstName());
    }
}
