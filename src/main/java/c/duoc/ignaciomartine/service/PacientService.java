package c.duoc.ignaciomartine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.duoc.ignaciomartine.model.Pacient;
import c.duoc.ignaciomartine.repository.PacientRepository;

@Service
public class PacientService {

    @Autowired
    private final PacientRepository pacientRepository;

    public PacientService(PacientRepository pacientRepository){
        this.pacientRepository = pacientRepository;
    }

    public List<Pacient> getAllPacients(){
        return pacientRepository.findAll();    
    }
    
    public Optional<Pacient> getPacientById(int id){
        return pacientRepository.findById(id);
    }

    public Pacient createPacient(Pacient pacient){
        return pacientRepository.save(pacient);
    }

    public Optional<Pacient> updatePacient(int id, Pacient updatedPacient) {
        if (pacientRepository.existsById(id)) {
            updatedPacient.setId(id);
            return Optional.of(pacientRepository.save(updatedPacient));
        }
        return Optional.empty();
    }

    public boolean deletePacient(int id) {
        if (pacientRepository.existsById(id)) {
            pacientRepository.deletedById(id);
            return true;
        }
        return false;
    }
}
