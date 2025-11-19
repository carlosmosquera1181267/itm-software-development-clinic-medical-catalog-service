package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.DiagnosticAid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DiagnosticAidMapper {

    DiagnosticAid toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid diagnosticAid);

    co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid toEntity(DiagnosticAid diagnosticAidDTO);

    List<DiagnosticAid> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid> diagnosticAids);

    List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid> toEntityList(List<DiagnosticAid> diagnosticAidDTOs);
}
