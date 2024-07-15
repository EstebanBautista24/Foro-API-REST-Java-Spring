package com.esteban.forohub.repository;

import com.esteban.forohub.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResponseRepository extends JpaRepository<Response,Long> {
}
