package co.itm.edu.software.development.clinic.medicalcatalogservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Procedure(
        UUID id,
        String name,
        String description,
        String type,
        Specialty requiredSpecialty,
        int estimatedDurationMinutes,
        String requiredSupplies,
        boolean requiresStock,
        BigDecimal baseCost,
        String code,
        String complexityLevel,
        LocalDateTime updatedAt
) {
    public Procedure {
        estimatedDurationMinutes = estimatedDurationMinutes < 0 ? 0 : estimatedDurationMinutes;
        baseCost = baseCost.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : baseCost;
    }
}
