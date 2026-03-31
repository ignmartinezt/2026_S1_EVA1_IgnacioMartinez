package c.duoc.ignaciomartine.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacient {
    
    @NotNull(message = "El rut no puede estar vacío")
    private Integer id;

    @NotBlank(message = "El nombre de el paciente no puede estar vacio")
    private String name;

    @NotBlank(message = "El especialidad de atención no pude estar en blanco")
    private String especiality;

    @Min(value = 1, message = "La prioridad minima es 1")
    @Max(value = 3, message = "La prioridad max es 3")
    private int priority;



}
