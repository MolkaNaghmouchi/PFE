package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response,Integer> {
    Optional<Response> findByResponse(String response);
    Void deleteByResponse(String response);
}
