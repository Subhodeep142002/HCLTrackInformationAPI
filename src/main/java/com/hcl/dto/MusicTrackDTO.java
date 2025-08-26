package com.hcl.dto;

import java.time.LocalDate;

public record MusicTrackDTO(String title, String albumName, LocalDate releaseDate, Integer playCount) {

}
