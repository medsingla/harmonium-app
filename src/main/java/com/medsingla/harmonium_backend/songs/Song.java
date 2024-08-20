package com.medsingla.harmonium_backend.songs;

public record Song(
        String id,
        String name,
        Integer parts,
        Difficulty difficulty
) {
}
