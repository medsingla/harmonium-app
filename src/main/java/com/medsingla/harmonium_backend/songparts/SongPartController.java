package com.medsingla.harmonium_backend.songparts;

import com.medsingla.harmonium_backend.songs.Song;
import com.medsingla.harmonium_backend.songs.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SongPartController {

    private final SongPartRepository songPartRepository;
    private final SongRepository songRepository;

    public SongPartController(SongPartRepository songPartRepository, SongRepository songRepository) {
        this.songPartRepository = songPartRepository;
        this.songRepository = songRepository;
    }

    @PostMapping("/songparts")
    public SongPart createSongPart(@RequestBody CreateSongPartRequest request) {

        Song song = songRepository.findById(request.songId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find a song with ID " + request.songId()));

        int part = song.parts() + 1;

        SongPart songPart = new SongPart(
                new SongPartKey(
                        request.songId(),
                        part
                ),
                new ArrayList<>()
        );

        songRepository.save(new Song(
                song.id(),
                song.name(),
                part,
                song.difficulty()
        ));

        songPartRepository.save(songPart);
        return songPart;
    }

    @GetMapping("/songchords/{songId}/{partNumber}")
    public SongPart getSongChord(@PathVariable String songId, @PathVariable Integer partNumber) {
        SongPartKey key = new SongPartKey(songId, partNumber);
        return songPartRepository.findByKey(key)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SongChord not found for songId " + songId + " and partNumber " + partNumber));
    }

    public record CreateSongPartRequest(
            String songId
    ){}


}
