package co.itm.edu.software.development.clinic.medicalcatalogservice.service;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Specialty;
import co.itm.edu.software.development.clinic.medicalcatalogservice.repository.SpecialtyRepository;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private SpecialtyMapper specialtyMapper;

    public Optional<List<Specialty>> getAllSpecialties() {
        return Optional.ofNullable(specialtyMapper.toDTOList(specialtyRepository.findAll()));
    }

    public Optional<Specialty> getSpecialtyById(String id) {
        return specialtyRepository.findById(id)
                .map(specialtyMapper::toDTO);
    }
}
