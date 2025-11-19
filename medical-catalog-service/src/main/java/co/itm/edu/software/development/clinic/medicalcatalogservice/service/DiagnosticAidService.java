package co.itm.edu.software.development.clinic.medicalcatalogservice.service;


import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.DiagnosticAid;
import co.itm.edu.software.development.clinic.medicalcatalogservice.repository.DiagnosticAidRepository;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers.DiagnosticAidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticAidService {

    @Autowired
    private DiagnosticAidRepository diagnosticAidRepository;

    @Autowired
    private DiagnosticAidMapper diagnosticAidMapper;

    public Optional<List<DiagnosticAid>> findAllDiagnosticAid() {
        List<DiagnosticAid> diagnosticAids = diagnosticAidMapper.toDTOList(diagnosticAidRepository.findAll());
        return Optional.ofNullable(diagnosticAids);
    }

    public Optional<DiagnosticAid> findById(String id) {
        return diagnosticAidRepository.findById(id)
                .map(diagnosticAidMapper::toDTO);
    }
}
