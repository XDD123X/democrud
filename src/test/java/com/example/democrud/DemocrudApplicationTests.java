package com.example.democrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.democrud.Entity.Song;
import com.example.democrud.Repository.SongRepository;

@SpringBootTest
class DemocrudApplicationTests {

	@Autowired
	private SongRepository songRepository;

	@Test
	void saveSong_success() {
		Song song = new Song();
		song.setTitle("Hello");
		song.setArtist("Adele");
		song.setReleased(java.time.LocalDate.now());

		Song saved = songRepository.save(song);

		assertNotNull(saved.getId());
		assertEquals("Hello", saved.getTitle());
	}

}
