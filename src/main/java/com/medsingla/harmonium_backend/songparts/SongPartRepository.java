package com.medsingla.harmonium_backend.songparts;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SongPartRepository extends MongoRepository<SongPart, SongPartKey> {
    List<SongPart> findByKeySongId(String songId);
}
