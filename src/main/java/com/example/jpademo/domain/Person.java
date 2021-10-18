package com.example.jpademo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person")
    private List<Song> songs = new ArrayList<>();

    @Builder
    public Person(String name, List<Song> playList) {
        this.name = name;
        if (playList != null) {
            this.songs = playList;
        }
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
