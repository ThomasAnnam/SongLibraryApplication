package com.annam.songs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.annam.songs.persistence.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

}