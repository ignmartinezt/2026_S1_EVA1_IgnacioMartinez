package c.duoc.ignaciomartine.controller;

import org.springframework.web.bind.annotation.RestController;

import c.duoc.ignaciomartine.model.Pacient;
import c.duoc.ignaciomartine.service.PacientService;
import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
@RequestMapping("/api/v1/pacients")
public class PacientController {

    @Autowired
    private PacientService pacientService;

    @GetMapping
    public ResponseEntity<List<Pacient>> getAllPacients(){
        return ResponseEntity.ok(pacientService.getAllPacients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPacientById(@PathVariable int id){
        return pacientService.getPacientById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("path/{id}")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Pacient pacient){
        return ResponseEntity.ok(service.createPacient(pacient));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePacient(@PathVariable int id, @Valid @RequestBody Pacient pacient) {
        return service.updatePacient(int, pacient)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePacient(@PathVariable int id){
        return service.deletePacient(id)
                ? ResponseEntity.noContent().build();
                ? ResponseEntity.notFound().build();
    }
    
    
}
