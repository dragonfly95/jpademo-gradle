package com.example.jpademo.repository;

import com.example.jpademo.domain.Song;
import com.example.jpademo.dto.SongDto;
import com.example.jpademo.dto.SongDto3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Override
    @Query(value = "select distinct s from Song s join fetch s.person")
//    , countQuery = "select count(s) from Song s inner join s.person")
//    @EntityGraph(attributePaths = {"person"})
    List<Song> findAll();

    Page<PersonView> findAllByTitleContaining(String title, Pageable pageable);

    @Query(value = "select new com.example.jpademo.dto.SongDto(s.id, s.singer, s.title, s.person) from Song s join  s.person as r")
    List<SongDto> retrieveSongs(@Param("str") String str);

    @Query(value = "select new Map(s.id, s.singer, s.title, s.person) from Song s join s.person as r")
    List<HashMap> mapSongs(@Param("str") String str);

    Page<PersonView> findByTitle(String title, Pageable pageable);

    public interface PersonView {
        String getTitle();
        Persona getPerson();
//        String getPersonName();
    }

    public interface Persona {
        String getName();
    }
}
