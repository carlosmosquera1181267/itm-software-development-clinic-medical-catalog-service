package co.itm.edu.software.development.clinic.medicalcatalogservice.service;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Procedure;
import co.itm.edu.software.development.clinic.medicalcatalogservice.repository.ProcedureRepository;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers.ProcedureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Autowired
    private ProcedureMapper procedureMapper;

    public Optional<List<Procedure>> getAllProcedures() {
        return Optional.ofNullable(procedureMapper.toDTOList(procedureRepository.findAll()));
    }

    public Optional<Procedure> getProcedureById(String id) {
        return procedureRepository.findById(id)
                .map(procedureMapper::toDTO);
    }
}
