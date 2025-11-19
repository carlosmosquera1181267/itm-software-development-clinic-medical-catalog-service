package co.itm.edu.software.development.clinic.medicalcatalogservice.controllers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Specialty;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping
    public ResponseEntity<List<Specialty>> getAll() {
        var specialties = specialtyService.getAllSpecialties();

        return specialties.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> getById(@PathVariable String id) {
        var specialty = specialtyService.getSpecialtyById(id);
        return specialty.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
