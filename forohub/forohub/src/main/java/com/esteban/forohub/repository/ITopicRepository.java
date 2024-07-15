package com.esteban.forohub.repository;

import com.esteban.forohub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

    public List<Topic> findByStatusTrue();
}
