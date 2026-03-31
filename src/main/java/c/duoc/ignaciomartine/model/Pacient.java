package c.duoc.ignaciomartine.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacient {
    
    @NotNull(message = "El rut no puede estar vacio");
    private int id;

    @NotBlank(message = "El nombre de el paciente no puede estar vacio");
    private String name;

    @NotBlank(message = "El especialidad de atención no pude estar en blanco")
    private String especiality;

    @NotNull(message = "Porfavor establezca un numero de prioridad de el 1 al 3")
    private int priority;



}
