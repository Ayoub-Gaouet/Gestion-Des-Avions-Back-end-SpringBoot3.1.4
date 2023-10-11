package com.ayoub.avions.service;
import java.util.List;
import java.util.stream.Collectors;

import com.ayoub.avions.dto.AvionDTO;
import com.ayoub.avions.entities.Avions;
import com.ayoub.avions.entities.Company;
import com.ayoub.avions.repos.AvionsRepository;
import com.ayoub.avions.repos.ImageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionsServiceImpl implements AvionsService {
    @Autowired
    AvionsRepository avionsRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public AvionDTO saveAvions(AvionDTO a) {
        return convertEntityToDto( avionsRepository.save(convertDtoToEntity(a)));
    }

    @Override
    public AvionDTO updateAvions(AvionDTO p) {
        Long oldProdImageId =
                this.getAvions(p.getIdAvions()).getImage().getIdImage();
        Long newProdImageId = p.getImage().getIdImage();
        AvionDTO avUpdated = convertEntityToDto(avionsRepository.save(convertDtoToEntity(p)));
        if (oldProdImageId != newProdImageId) //si l'image a été modifiée
            imageRepository.deleteById(oldProdImageId);
        return avUpdated;
    }
    @Override
    public void deleteAvions(Avions a) {
        avionsRepository.delete(a);
    }

    @Override
    public void deleteAvionsById(Long id) {
        avionsRepository.deleteById(id);
    }

    @Override
    public AvionDTO getAvions(Long id) {
        return convertEntityToDto( avionsRepository.findById(id).get());
    }

    @Override
    public List<AvionDTO> getAllAvions() {
        return avionsRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<Avions> findByNomAvions(String nom) {
        return avionsRepository.findByNomAvions(nom);
    }
    @Override
    public List<Avions> findByNomAvionsContains(String nom) {
        return  avionsRepository.findByNomAvionsContains(nom);
    }
    @Override
    public List<Avions> findByNomPrix(String nom, Double prix) {
        return  avionsRepository.findByNomPrix(nom, prix);
    }
    @Override
    public List<Avions> findByCompany(Company company) {
        return  avionsRepository.findByCompany(company);
    }
    @Override
    public List<Avions> findByCompanyIdCom(Long id) {
        return  avionsRepository.findByCompanyIdCom(id);
    }
    @Override
    public List<Avions> findByOrderByNomAvionsAsc() {
        return  avionsRepository.findByOrderByNomAvionsAsc();
    }
    @Override
    public List<Avions> trierAvionsNomsPrix() {
        return  avionsRepository.trierAvionsNomsPrix();
    }
    @Override
    public AvionDTO convertEntityToDto(Avions avions) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AvionDTO avionDTO = modelMapper.map(avions, AvionDTO.class);
        return avionDTO;
    }
    @Override
    public Avions convertDtoToEntity(AvionDTO avionDTO) {
        Avions avions = new Avions();
        avions = modelMapper.map(avionDTO, Avions.class);

        return avions;
    }

}

