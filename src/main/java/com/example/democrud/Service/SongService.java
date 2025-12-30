package com.example.democrud.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.democrud.Entity.Song;
import com.example.democrud.Repository.SongRepository;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
}
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
    
    public Optional<Song> getSongById(Integer id) {
        return songRepository.findById(id);
    }
    
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }
    
    public void deleteSong(Integer id) {
        songRepository.deleteById(id);
    }
}