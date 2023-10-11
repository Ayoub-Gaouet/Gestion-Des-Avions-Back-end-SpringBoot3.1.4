package com.ayoub.avions.service;
import java.util.List;

import com.ayoub.avions.dto.AvionDTO;
import com.ayoub.avions.entities.Avions;
import com.ayoub.avions.entities.Company;

public interface AvionsService {
    AvionDTO saveAvions(AvionDTO a);
    AvionDTO updateAvions(AvionDTO a);
    void deleteAvions(Avions a);
    void deleteAvionsById(Long id);
    AvionDTO getAvions(Long id);
    List<AvionDTO> getAllAvions();
    List<Avions> findByNomAvions(String nom);
    List<Avions> findByNomAvionsContains(String nom);
    List<Avions> findByNomPrix (String nom, Double prix);
    List<Avions> findByCompany (Company company);
    List<Avions> findByCompanyIdCom(Long id);
    List<Avions> findByOrderByNomAvionsAsc();
    List<Avions> trierAvionsNomsPrix();
    AvionDTO convertEntityToDto (Avions avions);
    Avions convertDtoToEntity(AvionDTO avionDTO);
}
