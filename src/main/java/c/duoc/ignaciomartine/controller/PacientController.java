package c.duoc.ignaciomartine.controller;

import org.springframework.web.bind.annotation.RestController;
import c.duoc.ignaciomartine.model.Pacient;
import c.duoc.ignaciomartine.service.PacientService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/v1/pacients")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    public ResponseEntity<List<Pacient>> getAllPacients() {
        return ResponseEntity.ok(pacientService.getAllPacients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacient> getPacientById(@PathVariable int id) {
        return pacientService.getPacientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pacient> createPacient(@Valid @RequestBody Pacient pacient) {
        return ResponseEntity.ok(pacientService.createPacient(pacient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacient> updatePacient(@PathVariable int id, @Valid @RequestBody Pacient pacient) {
        return pacientService.updatePacient(id, pacient)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacient(@PathVariable int id) {
        if (pacientService.deletePacient(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}