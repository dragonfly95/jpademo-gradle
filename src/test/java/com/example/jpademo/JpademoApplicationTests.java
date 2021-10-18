package com.example.jpademo;

import com.example.jpademo.domain.Person;
import com.example.jpademo.domain.Song;
import com.example.jpademo.repository.PersonRepository;
import com.example.jpademo.repository.SongRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JpademoApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	SongRepository songRepository;

	@Autowired
	EntityManager em;
/*
	@BeforeEach
	void setUp() {
		for (int i = 0; i < 10; i++) {
			Person person = Person.builder().name("person" + i)
					.build();
			personRepository.save(person);

			Song song = Song.builder().person(person)
					.singer("song" + i)
					.title("title" + i)
					.build();
			songRepository.save(song);
		}
	}
*/
	@Test
	@Transactional
	@DisplayName("n + 1 문제를 확인하는 테스트")
	void contextLoads() {

//		em.flush();
//		em.clear();
		PageRequest pageable = PageRequest.of(0, 7);
		Page<Song> songs = songRepository.findAll(pageable);
		List<SongDto> collect = songs.stream().map(SongDto::new).collect(Collectors.toList());
		for (SongDto song : collect) {
			System.out.println("song = " + song);
		}

		List<SongRepository.PersonView> title0 = songRepository.findByTitle("title0");
		System.out.println("title0 = " + title0);
		assertEquals(collect.size(), 10);
		System.out.println("true = " + true);
	}

}
