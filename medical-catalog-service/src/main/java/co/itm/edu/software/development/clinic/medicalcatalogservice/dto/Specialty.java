package co.itm.edu.software.development.clinic.medicalcatalogservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record Specialty(
        UUID id,
        String name,
        String description,
        boolean requiresAuthorization,
        int avgAttentionTime,
        String code,
        LocalDateTime updatedAt
) {
    public Specialty {
        avgAttentionTime = avgAttentionTime < 0 ? avgAttentionTime : 10;
        //requiresAuthorization = requiresAuthorization == null ? false : requiresAuthorization;
    }
}
