package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.DiagnosticAid;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DiagnosticAidMapperImpl implements DiagnosticAidMapper {
    @Override
    public DiagnosticAid toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid diagnosticAid) {
        if (diagnosticAid == null) return null;
        return new DiagnosticAid(
                UUID.fromString(diagnosticAid.getId()),
                diagnosticAid.getName(),
                diagnosticAid.getType(),
                diagnosticAid.getDescription(),
                diagnosticAid.getPreparation(),
                diagnosticAid.getDeliveryTime(),
                diagnosticAid.isRequiresAuthorization(),
                diagnosticAid.getCode(),
                diagnosticAid.getRequiredEquipment(),
                String.valueOf(diagnosticAid.isRequiresStock()),
                diagnosticAid.getUpdatedAt()
        );
    }

    @Override
    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid toEntity(DiagnosticAid diagnosticAidDTO) {
        if (diagnosticAidDTO == null) return null;

        return co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid.builder()
                .id(diagnosticAidDTO.id() != null ? diagnosticAidDTO.id().toString() : null)
                .name(diagnosticAidDTO.name())
                .type(diagnosticAidDTO.type())
                .description(diagnosticAidDTO.description())
                .preparation(diagnosticAidDTO.preparation())
                .deliveryTime(diagnosticAidDTO.deliveryTime())
                .requiresAuthorization(diagnosticAidDTO.requiresAuthorization())
                .code(diagnosticAidDTO.code())
                .requiredEquipment(diagnosticAidDTO.requiredEquipment())
                .requiresStock(Boolean.parseBoolean(diagnosticAidDTO.requiresStock()))
                .updatedAt(diagnosticAidDTO.updatedAt())
                .build();
    }

    @Override
    public List<DiagnosticAid> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid> diagnosticAids) {
        return diagnosticAids.stream().map(this::toDTO).toList();
    }

    @Override
    public List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid> toEntityList(List<DiagnosticAid> diagnosticAidDTOs) {
        return diagnosticAidDTOs.stream().map(this::toEntity).toList();
    }
}
