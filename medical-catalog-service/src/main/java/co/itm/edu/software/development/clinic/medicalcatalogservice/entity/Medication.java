package co.itm.edu.software.development.clinic.medicalcatalogservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String tradeName;
    private String genericName;
    private String manufacturer;
    private String concentration;
    private String presentation;
    private String administrationRoute;
    private String pharmaceutical_form;
    private String unitMeasure;
    private Integer stockAvailable;
    private Integer stockAlert;
    private Boolean controlled;
    String code;

    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }
}
