package com.example.airbnb.repository;

import com.example.airbnb.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository  extends JpaRepository<Singer, Long> {


    Singer findByNameContaining(String name);
}
