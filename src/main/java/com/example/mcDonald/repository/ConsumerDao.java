package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerDao extends JpaRepository<Consumer,Integer> {
}
