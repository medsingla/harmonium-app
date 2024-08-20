package com.medsingla.harmonium_backend.songs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostMapping("/songs")
    public Song createSong(@RequestBody CreateSongRequest request) {
        Song song = new Song(
                request.songId(),
                request.name(),
                0,
                request.difficulty()
        );

        songRepository.save(song);
        return song;
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable String songId) {
        return songRepository.findById(songId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find conversation with id: " + songId));
    }

    public record CreateSongRequest(
            String songId,
            String name,
            Difficulty difficulty
    ){}
}
