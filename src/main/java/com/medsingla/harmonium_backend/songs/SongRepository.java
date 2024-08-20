package com.medsingla.harmonium_backend.songs;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
