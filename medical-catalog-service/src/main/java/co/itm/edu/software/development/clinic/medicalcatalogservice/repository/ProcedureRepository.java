package co.itm.edu.software.development.clinic.medicalcatalogservice.repository;

import co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, String> {
}
