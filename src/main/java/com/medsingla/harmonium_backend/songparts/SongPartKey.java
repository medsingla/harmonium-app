package com.medsingla.harmonium_backend.songparts;

public record SongPartKey(
        String songId,
        Integer partNumber
) {
}
