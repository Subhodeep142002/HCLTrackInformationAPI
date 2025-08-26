package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.MusicTrack;

@Repository
public interface MusicTrackRepository extends JpaRepository<MusicTrack, Long>{

}
