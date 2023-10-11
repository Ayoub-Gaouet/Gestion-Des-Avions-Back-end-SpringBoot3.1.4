package com.ayoub.avions.entities;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomAv", types = { Avions.class })
public interface AvionsProjection {
	public String getNomAvions();
}