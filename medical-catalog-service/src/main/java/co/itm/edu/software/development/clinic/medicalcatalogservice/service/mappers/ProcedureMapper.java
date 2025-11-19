package co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Procedure;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProcedureMapper {

    public Procedure toDTO(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure procedureEntity);

    public co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure toEntity(Procedure procedureDTO);

    List<Procedure> toDTOList(List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure> procedureEntities);

    List<co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure> toEntityList(List<Procedure> procedureDTOs);
}
