package co.itm.edu.software.development.clinic.medicalcatalogservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record Medication(
        UUID id,
        String tradeName,
        String genericName,
        String manufacturer,
        String concentration,
        String presentation,
        String administrationRoute,
        String farmaceuticalForm,
        String unitMeasure,
        int stockAavailable,
        int stockAlert,
        boolean controlled,
        String code,
        LocalDateTime updatedAt
) {
    public Medication {
        stockAavailable = stockAavailable > 0 ? stockAavailable : 0;
        stockAlert = stockAlert > 0 ? stockAlert : 0;
    }
}
