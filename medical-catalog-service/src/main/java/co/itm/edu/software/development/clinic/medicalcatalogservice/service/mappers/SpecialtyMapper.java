package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Specialty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SpecialtyMapper {

    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty toEntity(Specialty specialtyDTO);

    public Specialty toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty specialtyEntity);

    public List<Specialty> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty> specialtyEntities);

    public List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty> toEntityList(List<Specialty> specialtyDTOs);
}
