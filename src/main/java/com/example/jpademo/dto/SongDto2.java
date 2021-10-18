package com.example.jpademo.dto;

import com.example.jpademo.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDto2 {

    private Long id;

    private String title;
    private String singer;

}
