package com.medsingla.harmonium_backend;

import com.medsingla.harmonium_backend.songparts.SongPart;
import com.medsingla.harmonium_backend.songparts.SongPartKey;
import com.medsingla.harmonium_backend.songparts.SongPartRepository;
import com.medsingla.harmonium_backend.songs.Difficulty;
import com.medsingla.harmonium_backend.songs.Song;
import com.medsingla.harmonium_backend.songs.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class HarmoniumBackendApplication implements CommandLineRunner {

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private SongPartRepository songPartRepository;

	public static void main(String[] args) {
		SpringApplication.run(HarmoniumBackendApplication.class, args);
	}

	public void run(String[] args) {

		songRepository.deleteAll();
		songPartRepository.deleteAll();

		Song song = new Song(
				"2",
				"Medhansh's Song",
				0,
				Difficulty.EASY
		);
		songRepository.save(song);
		songRepository.findAll().forEach(System.out::println);

		SongPart songPart = new SongPart(
				new SongPartKey(
						"2",
						1
				),
				new ArrayList<>()
		);
		songPartRepository.save(songPart);
		songPartRepository.findAll().forEach(System.out::println);

	}
}
