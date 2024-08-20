package com.medsingla.harmonium_backend.songparts;

import java.util.List;

public record SongPart(
        SongPartKey key,
        List<Chord> chords
) {
}
