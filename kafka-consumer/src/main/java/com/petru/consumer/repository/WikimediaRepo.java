package com.petru.consumer.repository;

import com.petru.consumer.entity.WikimediaDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepo extends JpaRepository<WikimediaDatabase, Long> {
}
