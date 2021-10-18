package com.example.jpademo.service;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class SongService {

    @Persistent
    EntityManager em;
}
