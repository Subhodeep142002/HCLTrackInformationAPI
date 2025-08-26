package com.hcl.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusicTrack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trackId;
	
	private String title;
	private String albumName;
	private LocalDate releaseDate;
	private Integer playCount;

}
