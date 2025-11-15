package co.itm.edu.software.development.clinic.medicalcatalogservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record DiagnosticAid(
        UUID id,
        String name,
        String type,
        String description,
        String preparation,
        int deliveryTime,
        boolean requiresAuthorization,
        String code,
        String requiredEquipment,
        String requiresStock,
        LocalDateTime updatedAt
) {
}
