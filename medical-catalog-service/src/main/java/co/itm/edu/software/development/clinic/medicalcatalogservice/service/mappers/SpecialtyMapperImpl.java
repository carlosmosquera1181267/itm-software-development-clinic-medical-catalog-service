package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Specialty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SpecialtyMapperImpl implements SpecialtyMapper {
    @Override
    public Specialty toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty specialtyEntity) {
        if (specialtyEntity == null) return null;

        UUID id = null;
        if (specialtyEntity.getId() != null) {
            try {
                id = UUID.fromString(specialtyEntity.getId());
            } catch (IllegalArgumentException e) {
                id = null;
            }
        }

        return new Specialty(
                id,
                specialtyEntity.getName(),
                specialtyEntity.getDescription(),
                specialtyEntity.getRequiresAuthorization(),
                specialtyEntity.getAvgAttentionTime(),
                specialtyEntity.getCode(),
                specialtyEntity.getUpdatedAt()
        );
    }

    @Override
    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty toEntity(Specialty specialtyDTO) {
        if (specialtyDTO == null) return null;

        return co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty.builder()
                .id(specialtyDTO.id() != null ? specialtyDTO.id().toString() : null)
                .name(specialtyDTO.name())
                .description(specialtyDTO.description())
                .code(specialtyDTO.code())
                .updatedAt(specialtyDTO.updatedAt())
                .build();
    }

    @Override
    public List<Specialty> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty> specialtyEntities) {
        if (specialtyEntities == null || specialtyEntities.isEmpty()) return List.of();
        return specialtyEntities.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty> toEntityList(List<Specialty> specialtyDTOs) {
        if (specialtyDTOs == null || specialtyDTOs.isEmpty()) return List.of();
        return specialtyDTOs.stream()
                        .filter(Objects::nonNull)
                        .map(this::toEntity)
                        .collect(Collectors.toList());
    }
}
