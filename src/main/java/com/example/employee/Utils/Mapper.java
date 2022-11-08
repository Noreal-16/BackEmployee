package com.example.employee.Utils;

import org.modelmapper.ModelMapper;

public class Mapper {
    private Mapper(){
        throw new IllegalStateException("No se puede instanciar Utilitatio");
    }
    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
