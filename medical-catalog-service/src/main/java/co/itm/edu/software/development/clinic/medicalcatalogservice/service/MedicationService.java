package co.itm.edu.software.development.clinic.medicalcatalogservice.service;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Medication;
import co.itm.edu.software.development.clinic.medicalcatalogservice.repository.MedicationRepository;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers.MedicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private MedicationMapper medicationMapper;

    public Optional<List<Medication>> getAllMedications() {
        return Optional.ofNullable(medicationMapper.toDTOList(medicationRepository.findAll()));
    }

    public Optional<Medication> getMedicationById(String id) {
        return medicationRepository.findById(id)
                .map(medicationMapper::toDTO);
    }
}
