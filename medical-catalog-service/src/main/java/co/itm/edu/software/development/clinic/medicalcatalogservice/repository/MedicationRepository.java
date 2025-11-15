package co.itm.edu.software.development.clinic.medicalcatalogservice.repository;

import co.itm.edu.software.development.clinic.medicalcatalogservice.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, String> {
}
