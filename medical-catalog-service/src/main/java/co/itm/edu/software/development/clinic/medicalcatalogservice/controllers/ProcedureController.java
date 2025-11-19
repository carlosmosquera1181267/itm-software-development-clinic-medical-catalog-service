package co.itm.edu.software.development.clinic.medicalcatalogservice.controllers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.Procedure;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @GetMapping
    public ResponseEntity<List<Procedure>> getAllProcedures() {
        var procedures = procedureService.getAllProcedures();

        return procedures.map(data -> ResponseEntity.ok(data))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedure> getProcedureById(@PathVariable String id) {
        var procedure = procedureService.getProcedureById(id);
        return procedure.map(data -> ResponseEntity.ok(data))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
