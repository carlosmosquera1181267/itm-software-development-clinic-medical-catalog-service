package co.itm.edu.software.development.clinic.medicalcatalogservice.repository;

import co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, String> {
}
