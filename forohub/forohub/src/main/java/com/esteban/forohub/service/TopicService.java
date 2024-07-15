package com.esteban.forohub.service;

import com.esteban.forohub.model.Course;
import com.esteban.forohub.model.DTO.RegisterTopic;
import com.esteban.forohub.model.DTO.TopicDetails;
import com.esteban.forohub.model.Topic;
import com.esteban.forohub.model.User;
import com.esteban.forohub.repository.ICourseRepository;
import com.esteban.forohub.repository.ITopicRepository;
import com.esteban.forohub.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
   private ITopicRepository topicRepository;
   private IUserRepository userRepository;
   private ICourseRepository courseRepository;
    public TopicService(@Autowired ITopicRepository topicRepository,@Autowired IUserRepository userRepository,@Autowired ICourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public List<TopicDetails> getAllTopics() {
        return topicRepository.findByStatusTrue().stream().map(t->  new TopicDetails(t)).toList();
    }
    public Topic saveTopic(RegisterTopic registerTopic) {
        Topic topic = new Topic(registerTopic);
        topic.setPublishDate(LocalDateTime.now());
        Optional<User> user = userRepository.findById(registerTopic.getIdUser());

        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }else{
            topic.setAuthor(user.get());
        }
        Optional<Course> course = courseRepository.findById(registerTopic.getIdCourse());
        if(course.isEmpty()) {
            throw new RuntimeException("Course not found");
        }else{
            topic.setCourse(course.get());
        }
        return topicRepository.save(topic);
    }
    public Topic getTopicById(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if(topic.isPresent()) {
            return (topic.get());
        }else {
            return null;
        }
    }




}
