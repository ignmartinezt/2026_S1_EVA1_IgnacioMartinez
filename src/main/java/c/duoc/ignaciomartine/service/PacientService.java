package c.duoc.ignaciomartine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.duoc.ignaciomartine.model.Pacient;

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

    public Optional<Pacient> updatePacient(int id,string name,string especiality,int priority){
        if (pacientRepository.existsById(id)){
            pacient.setId(id);
            return Optional.of(pacientRepository.save(pacient));

        }
        return Optional.empty();
    }

    public boolean deleteProduct(int id){
        if (pacientRepository.existsById(id))
            pacientRepository.deletedById(id);
            return true;
    }
    return false;
    
}
