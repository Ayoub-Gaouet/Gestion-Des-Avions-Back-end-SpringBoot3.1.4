package com.ayoub.avions.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayoub.avions.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
