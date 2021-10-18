package com.example.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDto3 {
    private BigInteger id;

    private String title;
    private String singer;
}
