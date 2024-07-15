package com.esteban.forohub.Controller;

import com.esteban.forohub.model.DTO.RegisterTopic;
import com.esteban.forohub.model.DTO.TopicDetails;
import com.esteban.forohub.model.DTO.UpdateTopic;
import com.esteban.forohub.model.Topic;
import com.esteban.forohub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;
    @GetMapping()
    public ResponseEntity<List<TopicDetails>> getAllTopics(){
        HttpHeaders headers = new HttpHeaders();

        return ResponseEntity.ok().headers(headers).body(topicService.getAllTopics());
    }
    @PostMapping()
    public ResponseEntity<TopicDetails> registerTopic(@RequestBody @Valid RegisterTopic registerTopic){
        Topic topic = topicService.saveTopic(registerTopic);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(new TopicDetails(topic));
    }
    @PutMapping("{/id}")
    @Transactional
    public ResponseEntity<TopicDetails> updateTopic(@RequestBody UpdateTopic updateTopic, @PathVariable Long id){
        Topic topic = topicService.getTopicById(id);
        topic = topic.updateTopic(updateTopic);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(new TopicDetails(topic));
    }
    @DeleteMapping("{/id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id){
        Topic topic = topicService.getTopicById(id);
        topic.deleteTopic();
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).build();
    }
}
