package co.itm.edu.software.development.clinic.medicalcatalogservice.service;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.DiagnosticAid;
import co.itm.edu.software.development.clinic.medicalcatalogservice.repository.DiagnosticAidRepository;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.mappers.DiagnosticAidMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DiagnosticAidServiceTest {

    @Mock
    private DiagnosticAidRepository diagnosticAidRepository;

    @Mock
    private DiagnosticAidMapper diagnosticAidMapper;

    @InjectMocks
    private DiagnosticAidService diagnosticAidService;

    private DiagnosticAid diagnosticAid;

    private co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid entity;

    @BeforeEach
    public void setUp() {
        // No specific setup required as we are using @ExtendWith and @InjectMocks
        diagnosticAid = new DiagnosticAid(
                UUID.randomUUID(),
                "X-Ray Machine",
                "Imaging",
                "Used for taking X-Ray images",
                "Available",
                60,
                false,
                "code",
                "Equipment for radiographic imaging",
                "storageInfo",
                LocalDateTime.now()
        );

        entity = co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid.builder()
                .id(diagnosticAid.id().toString())
                .name(diagnosticAid.name())
                .type(diagnosticAid.type())
                .description(diagnosticAid.description())
                .deliveryTime(diagnosticAid.deliveryTime())
                .requiresAuthorization(diagnosticAid.requiresAuthorization())
                .preparation(diagnosticAid.preparation())
                .code(diagnosticAid.code())
                .requiredEquipment(diagnosticAid.requiredEquipment())
                .requiresStock(diagnosticAid.requiresStock() != null && Boolean.parseBoolean(diagnosticAid.requiresStock()))
                .updatedAt(diagnosticAid.updatedAt())
                .build();
    }

    @Test
    void findAllDiagnosticAid_whenEntitiesExist_returnsOptionalWithDtos() {
        //var entity = mock(co.itm.edu.software.development.clinic.medicalcatalogservice.entity.DiagnosticAid.class);
        //var dto = mock(DiagnosticAid.class);

        when(diagnosticAidRepository.findAll()).thenReturn(List.of(entity));
        //when(diagnosticAidMapper.toDTO(any())).thenReturn(diagnosticAid);
        when(diagnosticAidMapper.toDTOList(any())).thenReturn(List.of(diagnosticAid));

        Optional<List<DiagnosticAid>> result = diagnosticAidService.findAllDiagnosticAid();

        assertTrue(result.isPresent());
        assertEquals(1, result.get().size());
        assertSame(diagnosticAid, result.get().get(0));

        //verify(diagnosticAidRepository).findAll();
        //verify(diagnosticAidMapper).toDTOList(any());
    }

    @Test
    void findAllDiagnosticAid_whenNoEntities_returnsOptionalEmpty() {
        when(diagnosticAidRepository.findAll()).thenReturn(List.of());

        Optional<List<DiagnosticAid>> result = diagnosticAidService.findAllDiagnosticAid();

        assertTrue(result.isPresent());
        assertTrue(result.get().isEmpty());
        verify(diagnosticAidRepository).findAll();
        //verify(diagnosticAidMapper, never()).toDTOList(any());
    }
}
