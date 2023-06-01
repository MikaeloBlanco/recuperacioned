package com.cpfifp.grijander.parkingfinal.vehiculo.domain;

import jakarta.validation.constraints.Pattern;

public class VehiculoDao {

    @Pattern(regexp = "[0-9]{4}[A-Z]{3}")
    private String matricula;

    public VehiculoDao() {
        this.matricula = "";
    }

    public VehiculoDao(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
