package co.itm.edu.software.development.clinic.medicalcatalogservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "procedures")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private int estimatedDurationMin;
    private String requiredSupplies;
    private Boolean requiresStock;
    private String type;
    private BigDecimal baseCost;
    private String code;
    private String complexityLevel;


    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }

    @OneToOne
    @JoinColumn(name = "required_specialty_id")
    private Specialty requiredSpecialty;

    public Specialty getRequiredSpecialty() {
        return requiredSpecialty;
    }

    public void setRequiredSpecialty(Specialty requiredSpecialty) {
        this.requiredSpecialty = requiredSpecialty;
    }
}
