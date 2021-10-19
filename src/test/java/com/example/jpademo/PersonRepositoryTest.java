package com.example.jpademo;


import com.example.jpademo.domain.Person;
import com.example.jpademo.domain.Song;
import com.example.jpademo.repository.PersonRepository;
import com.example.jpademo.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SongRepository songRepository;

    @Transactional
    @Test
    public void test1122() {

        Iterable<Person> top5By = personRepository.findTop5By();
        top5By.forEach(person -> System.out.println("person = " + person.getSongs()));
    }

    @Transactional
    @Test
    public void test112233() {

        Person person = personRepository.save(Person.builder()
                .name("홍길동")
                .build());

//        Song song1 = Song.builder().singer("홍길동").title("돌아와요 부산항에").build();
//        Song song2 = Song.builder().singer("홍길동").title("돌아와요 인천항에").build();
//        Song song3 = Song.builder().singer("홍길동").title("돌아와요 마산항에").build();

        Song song1 = songRepository.save(Song.builder().singer("홍길동").title("돌아와요 부산항에").person(person).build());
        Song song2 = songRepository.save(Song.builder().singer("홍길동").title("돌아와요 인천항에").person(person).build());
        Song song3 = songRepository.save(Song.builder().singer("홍길동").title("돌아와요 마산항에").person(person).build());

//        personRepository.save(person);

    }
}
