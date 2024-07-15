package com.esteban.forohub.service;

import com.esteban.forohub.model.DTO.RegisterResponse;
import com.esteban.forohub.model.Response;
import com.esteban.forohub.model.Topic;
import com.esteban.forohub.model.User;
import com.esteban.forohub.repository.IResponseRepository;
import com.esteban.forohub.repository.ITopicRepository;
import com.esteban.forohub.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponseService {
    private ITopicRepository topicRepository;
    private IUserRepository userRepository;
    private IResponseRepository responseRepository;
    public ResponseService(@Autowired  ITopicRepository topicRepository,@Autowired IUserRepository userRepository,@Autowired IResponseRepository responseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.responseRepository = responseRepository;
    }
    public Response saveResponse(RegisterResponse registerResponse) {
        Response response = new Response(registerResponse);

        Optional<User> user = userRepository.findById(registerResponse.getIdAuthor());

        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }else{
            response.setAuthor(user.get());
        }
        Optional<Topic> topic = topicRepository.findById(registerResponse.getIdTopic());
        if(topic.isEmpty()) {
            throw new RuntimeException("Course not found");
        }else{
            response.setTopic(topic.get());
        }
        return responseRepository.save(response);
    }
}
