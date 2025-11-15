package co.itm.edu.software.development.clinic.medicalcatalogservice.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private Boolean requiresAuthorization;
    private Integer avgAttentionTime;
    String code;

    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }
}
