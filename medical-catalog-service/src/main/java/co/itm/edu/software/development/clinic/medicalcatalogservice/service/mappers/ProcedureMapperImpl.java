package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Procedure;
import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Specialty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProcedureMapperImpl implements ProcedureMapper {


    @Override
    public Procedure toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure procedureEntity) {
        if (procedureEntity == null) return null;

        UUID id = null;
        if (procedureEntity.getId() != null) {
            try {
                id = UUID.fromString(procedureEntity.getId());
            } catch (IllegalArgumentException e) {
                id = null;
            }
        }

        Specialty requiredSpecialtyDto = null;
        if (procedureEntity.getRequiredSpecialty() != null) {
            var s = procedureEntity.getRequiredSpecialty();
            UUID sid = null;
            if (s.getId() != null) {
                try {
                    sid = UUID.fromString(s.getId());
                } catch (IllegalArgumentException e) {
                    sid = null;
                }
            }
            requiredSpecialtyDto = new Specialty(
                    sid,
                    s.getName(),
                    s.getDescription(),
                    s.getRequiresAuthorization(),
                    s.getAvgAttentionTime(),
                    s.getCode(),
                    s.getUpdatedAt()
            );
        }

        return new Procedure(
                id,
                procedureEntity.getName(),
                procedureEntity.getDescription(),
                procedureEntity.getType(),
                requiredSpecialtyDto,
                procedureEntity.getEstimatedDurationMin(),
                procedureEntity.getRequiredSupplies(),
                procedureEntity.getRequiresStock(),
                procedureEntity.getBaseCost(),
                procedureEntity.getCode(),
                procedureEntity.getComplexityLevel(),
                procedureEntity.getUpdatedAt()
        );
    }

    @Override
    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure toEntity(Procedure procedureDTO) {
        if (procedureDTO == null) return null;

        co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty requiredSpecialtyEntity = null;
        if (procedureDTO.requiredSpecialty() != null) {
            var s = procedureDTO.requiredSpecialty();
            requiredSpecialtyEntity = co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty.builder()
                    .id(s.id() != null ? s.id().toString() : null)
                    .name(s.name())
                    .description(s.description())
                    .code(s.code())
                    .updatedAt(s.updatedAt())
                    .build();
        }

        return co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure.builder()
                .id(procedureDTO.id() != null ? procedureDTO.id().toString() : null)
                .name(procedureDTO.name())
                .description(procedureDTO.description())
                .type(procedureDTO.type())
                .requiredSpecialty(requiredSpecialtyEntity)
                .estimatedDurationMin(procedureDTO.estimatedDurationMinutes())
                .requiredSupplies(procedureDTO.requiredSupplies())
                .requiresStock(procedureDTO.requiresStock())
                .baseCost(procedureDTO.baseCost())
                .code(procedureDTO.code())
                .complexityLevel(procedureDTO.complexityLevel())
                .updatedAt(procedureDTO.updatedAt())
                .build();
    }

    @Override
    public List<Procedure> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure> procedureEntities) {
        if (procedureEntities == null || procedureEntities.isEmpty()) return List.of();
        return procedureEntities.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure> toEntityList(List<Procedure> procedureDTOs) {
        if (procedureDTOs == null || procedureDTOs.isEmpty()) return List.of();
        return procedureDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
