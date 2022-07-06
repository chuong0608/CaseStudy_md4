package com.example.airbnb.service;

import com.example.airbnb.model.Song;

import java.util.Optional;

public interface GeneralService<T> {
    //save, delete
    void save(T t);
    void delete(T t);

    //findAll
    Iterable<T> findAll();

    //findById
    Optional<T> findById(Long id);

    //findByName
    T findByName(String name);



}
