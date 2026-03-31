package c.duoc.ignaciomartine.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import c.duoc.ignaciomartine.model.Pacient;

@Repository
public class PacientRepository {
    private final Map<Integer, Pacient> pacientHosp = new HashMap<>();


    public List<Pacient> findAll(){
        return new ArrayList<>(pacientHosp.values());
    }

    public Optional<Pacient> findById(int id){
        return Optional.ofNullable(pacientHosp.get(id));
    }

    public Pacient save(Pacient pacient){
        pacientHosp.put(pacient.getId(),pacient);
        return pacient;
    }

    public void deletedById(int id){
        pacientHosp.remove(id);
    }

    public boolean existsById(int id){
        return pacientHosp.containsKey(id);
        
    }
}