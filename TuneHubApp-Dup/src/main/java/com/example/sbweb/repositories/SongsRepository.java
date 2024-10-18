package com.example.sbweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbweb.entities.Song;

public interface SongsRepository extends JpaRepository <Song,Integer>{
	public Song findBySongname(String songname); 

}
