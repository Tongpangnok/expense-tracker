package com.tom.demo.repository;

import com.tom.demo.model.TrackerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<TrackerModel,Long> {
}