package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Medication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedicationMapper {

    public Medication toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication medicationEntity);

    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication toEntity(Medication medicationDTO);

    List<Medication> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication> medicationEntities);

    List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication> toEntityList(List<Medication> medicationEntities);
}
