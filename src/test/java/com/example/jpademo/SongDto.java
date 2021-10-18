package com.example.jpademo;

import com.example.jpademo.domain.Person;
import com.example.jpademo.domain.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private Long id;

    private String title;
    private String singer;

    private Person person;


    public SongDto(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.singer = song.getSinger();
        this.person = song.getPerson();
    }

    @Override
    public String toString() {
        return "SongDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", person=" + person +
                '}';
    }
}
