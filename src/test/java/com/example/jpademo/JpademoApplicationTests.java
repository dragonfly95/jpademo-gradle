package com.example.jpademo;

import com.example.jpademo.domain.Song;
import com.example.jpademo.dto.SongDto;
import com.example.jpademo.dto.SongDto2;
import com.example.jpademo.dto.SongDto3;
import com.example.jpademo.repository.PersonRepository;
import com.example.jpademo.repository.SongRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	void print1() {
//		List<Map> resultList = em.createQuery("select new Map(s.id, s.singer, s.title, s.person) from Song s join s.person as p", Map.class).getResultList();
//		resultList.stream().forEach(songDto -> System.out.println("songDto = " + songDto));

		List<Song> resultList = em.createQuery("select s from Song s join fetch s.person as p", Song.class).getResultList();
		List<SongDto> collect = resultList.stream().map(SongDto::new).collect(Collectors.toList());
		for (SongDto v : collect) {
			System.out.println("v = " + v);
		}
	}

	@Test
	@Transactional
	@DisplayName("n + 1 문제를 확인하는 테스트")
	void contextLoads() {

//		em.flush();
//		em.clear();
		PageRequest pageable = PageRequest.of(0, 7);
		List<Song> songs = songRepository.findAll();

		List<SongDto> collect = songs.stream().map(SongDto::new).collect(Collectors.toList());
		for (SongDto song : collect) {
			System.out.println("song = " + song);
		}

		Page<SongRepository.PersonView> pages = songRepository.findAllByTitleContaining("title", pageable);
		System.out.println("pages = " + pages);

		List<SongDto> allTt = songRepository.retrieveSongs("hello");
		System.out.println("allTt = " + allTt);

		List<HashMap> eee = songRepository.mapSongs("eee");
		System.out.println("eee = " + eee);

		Page<SongRepository.PersonView> title0 = songRepository.findByTitle("title0", pageable);
//		System.out.println("title0 = " + title0.getContent());
		for (SongRepository.PersonView v: title0.getContent()) {
			System.out.println("v.getPerson().getName() = " + v.getPerson().getName());
		}
		assertEquals(collect.size(), 10);
		System.out.println("true = " + true);
	}

}
