package com.aj.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aj.entity.Load;

public interface LoadRepository extends JpaRepository<Load, Long>{
    List<Load> findByShipperId(UUID shipperId);


}
