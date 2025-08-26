package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.MusicTrackDTO;
//import com.hcl.entity.MusicTrack;
import com.hcl.service.MusicTrackService;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class MusicTrackController {
	
	@Autowired
	private MusicTrackService musicService;
	
	@PostMapping("/music/platform/v1/tracks")
	public ResponseEntity<MusicTrackDTO> createTrack(MusicTrackDTO musicdto){
		return ResponseEntity.status(HttpStatus.CREATED).body(musicService.createTrack(musicdto));
	}
	
	@GetMapping("/music/platform/v1/tracks")
	public ResponseEntity<List<MusicTrackDTO>> getAllTracks(){
		return ResponseEntity.status(HttpStatus.OK).body(musicService.getAllTracks());
	}
	
	@GetMapping("/music/platform/v1/tracks/sorted")
	public ResponseEntity<List<MusicTrackDTO>> getSortedTrackByTitle(){
		return ResponseEntity.status(HttpStatus.OK).body(musicService.getSortedTrackByTitle());
	}
	
	@DeleteMapping("/music/platform/v1/tracks/{trackId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		musicService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
