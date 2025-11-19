package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Medication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
public class MedicationMapperImpl implements MedicationMapper {
    @Override
    public Medication toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication medicationEntity) {
        if (medicationEntity == null) return null;

        UUID id = null;
        if (medicationEntity.getId() != null) {
            try {
                id = UUID.fromString(medicationEntity.getId());
            } catch (IllegalArgumentException e) {
                id = null;
            }
        }

        return new Medication(
                id,
                medicationEntity.getTradeName(),
                medicationEntity.getGenericName(),
                medicationEntity.getManufacturer(),
                medicationEntity.getConcentration(),
                medicationEntity.getPresentation(),
                medicationEntity.getAdministrationRoute(),
                medicationEntity.getPharmaceutical_form(),
                medicationEntity.getUnitMeasure(),
                medicationEntity.getStockAvailable(),
                medicationEntity.getStockAlert(),
                medicationEntity.getControlled(),
                medicationEntity.getCode(),
                medicationEntity.getUpdatedAt()
        );
    }

    @Override
    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication toEntity(Medication medicationDTO) {
        if (medicationDTO == null) return null;

        return co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication.builder()
                .id(medicationDTO.id() != null ? medicationDTO.id().toString() : null)
                .tradeName(medicationDTO.tradeName())
                .genericName(medicationDTO.genericName())
                .manufacturer(medicationDTO.manufacturer())
                .concentration(medicationDTO.concentration())
                .presentation(medicationDTO.presentation())
                .administrationRoute(medicationDTO.administrationRoute())
                .pharmaceutical_form(medicationDTO.farmaceuticalForm())
                .unitMeasure(medicationDTO.unitMeasure())
                .stockAvailable(medicationDTO.stockAavailable())
                .stockAlert(medicationDTO.stockAlert())
                .controlled(medicationDTO.controlled())
                .code(medicationDTO.code())
                .updatedAt(medicationDTO.updatedAt())
                .build();

    }

    @Override
    public List<Medication> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication> medicationEntities) {
        return medicationEntities.stream().map(this::toDTO).toList();
    }

    @Override
    public List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication> toEntityList(List<Medication> medicationEntities) {
        return medicationEntities.stream().map(this::toEntity).toList();
    }
}
