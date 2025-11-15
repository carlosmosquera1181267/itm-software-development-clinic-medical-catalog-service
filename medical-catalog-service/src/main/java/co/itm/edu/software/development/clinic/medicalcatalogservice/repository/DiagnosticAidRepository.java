package co.itm.edu.software.development.clinic.medicalcatalogservice.repository;

import co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticAidRepository extends JpaRepository<DiagnosticAid, String> {
}
