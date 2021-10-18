package com.example.jpademo.repository;

import com.example.jpademo.domain.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

//    @Query(value = "select s from Song s join fetch s.person")
////    , countQuery = "select count(s) from Song s inner join s.person")
////    @EntityGraph(attributePaths = {"person"})
//    List<Song> findAll();


    List<PersonView> findByTitle(String title);

    public interface PersonView {
        String getTitle();
        String getPersonName();
    }
}
