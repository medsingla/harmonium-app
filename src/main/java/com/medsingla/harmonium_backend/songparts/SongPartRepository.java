package com.medsingla.harmonium_backend.songparts;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface SongPartRepository extends MongoRepository<SongPart, SongPartKey> {
    Optional<SongPart> findByKey(SongPartKey key);
}
