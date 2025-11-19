package co.itm.edu.software.development.clinic.medicalcatalogservice.controllers;

import co.itm.edu.software.development.clinic.medicalcatalogservice.dto.DiagnosticAid;
import co.itm.edu.software.development.clinic.medicalcatalogservice.service.DiagnosticAidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diagnostic-aids")
public class DiagnosticAidController {

    @Autowired
    private DiagnosticAidService diagnosticAidService;

    @GetMapping
    public ResponseEntity<List<DiagnosticAid>> getAllDiagnosticAids() {
        var diagnosticAids = diagnosticAidService.findAllDiagnosticAid();

        return diagnosticAids.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticAid> getDiagnosticAidById(@PathVariable String id) {
        var diagnosticAid = diagnosticAidService.findById(id);

        return diagnosticAid.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
