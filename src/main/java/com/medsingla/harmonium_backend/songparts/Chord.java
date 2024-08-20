package com.medsingla.harmonium_backend.songparts;

import java.util.List;

public record Chord(
        List<Integer> keys,
        Float duration
) {
}
