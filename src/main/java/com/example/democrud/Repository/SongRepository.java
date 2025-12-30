package com.example.democrud.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.democrud.Entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}