package co.itm.edu.software.development.clinic.medicalcatalogservice.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "diagnostic_aids")
public class DiagnosticAid {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;

    private String type;
    private String preparation;
    private int deliveryTime;
    private Boolean requiresAuthorization;
    private String code;

    private String requiredEquipment;
    private Boolean requiresStock;

    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }
}
