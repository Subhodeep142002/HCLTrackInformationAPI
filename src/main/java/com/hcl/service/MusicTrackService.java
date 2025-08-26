package com.hcl.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.MusicTrackDTO;
import com.hcl.entity.MusicTrack;
import com.hcl.repository.MusicTrackRepository;

@Service
public class MusicTrackService {
	
	@Autowired
	private MusicTrackRepository musicRepo;
	
	public MusicTrackDTO createTrack(MusicTrackDTO musicdto) {
		MusicTrack track = new MusicTrack();
		track.setTitle(musicdto.title());
		track.setAlbumName(musicdto.albumName());
		track.setReleaseDate(musicdto.releaseDate());
		track.setPlayCount(musicdto.playCount());
		MusicTrackDTO dto = new MusicTrackDTO(
				track.getTitle(),
				track.getAlbumName(),
				track.getReleaseDate(),
				track.getPlayCount()
			);
		return dto;
	}
	
	public List<MusicTrackDTO> getAllTracks(){
		List<MusicTrack> tracks = musicRepo.findAll();
		
		return tracks
		.stream()
		.map(e -> new MusicTrackDTO(e.getTitle(),e.getAlbumName(),e.getReleaseDate(),e.getPlayCount()))
		.collect(Collectors.toList());
	}
	
	
	public List<MusicTrackDTO> getSortedTrackByTitle() {
		List<MusicTrack> tracks = musicRepo.findAll();
		return tracks
				.stream()
				.map(e -> new MusicTrackDTO(e.getTitle(),e.getAlbumName(),e.getReleaseDate(),e.getPlayCount()))
				.sorted(Comparator.comparing(MusicTrackDTO::title))
				.toList();
	}
	
	
	public void deleteById(Long Id) {
		musicRepo.deleteById(Id);
	}

}
